package tools.samt.client

import tools.samt.client.generated.consumer.GreeterEndpointConsumer

fun main() {
    val client = GreeterEndpointConsumer("http://localhost:8080")

    println(client.greeting("Sam"))
}
