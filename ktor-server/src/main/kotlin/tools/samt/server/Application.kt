package tools.samt.server

import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.routing.*
import tools.samt.server.generated.greeter.*

fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0", module = Application::module)
        .start(wait = true)
}

class MyGreeter : Greeter {
    override fun greet(
        name: String,
        id: ID,
        binary: ByteArray?,
        type: GreetingType?,
        anotherString: String?,
        inBody: Complex?
    ): Greeting {
        return Greeting("Hello, $name!")
    }

    override fun greetAll(names: List<String?>): Map<String, Greeting?> {
        return names.associate { (it ?: "<unknown>") to Greeting("Hello, $it!") }
    }

    override fun greeting(name: String): String {
        return "Hello, $name!"
    }

}

fun Application.module() {
    install(ContentNegotiation) {
        json()
    }
    routing {
        routeGreeterEndpoint(
            greeter = MyGreeter(),
        )
    }
}
