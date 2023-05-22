@file:Suppress("RemoveRedundantQualifierName", "unused", "UnusedImport", "LocalVariableName", "FunctionName", "ConvertTwoComparisonsToRangeCheck", "ReplaceSizeCheckWithIsNotEmpty", "NAME_SHADOWING")

package tools.samt.client.generated.consumer

import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import io.ktor.util.*
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.json.*
import tools.samt.client.generated.greeter.Complex
import tools.samt.client.generated.greeter.Greeting
import tools.samt.client.generated.greeter.GreetingType

class GreeterEndpointConsumer(val host: String) : tools.samt.client.generated.greeter.Greeter {
    private val client = HttpClient(CIO) {
        install(ContentNegotiation) {
            json()
        }
    }

    override fun greet(
        name: String,
        binary: ByteArray?,
        type: GreetingType?,
        anotherString: String?,
        inBody: Complex?
    ): Greeting {
        TODO("Not yet implemented")
    }

    override fun greetAll(names: List<String>): List<Greeting> {
        TODO("Not yet implemented")
    }

    override fun greeting(name: String): String {
        TODO("Not yet implemented")
    }

}
