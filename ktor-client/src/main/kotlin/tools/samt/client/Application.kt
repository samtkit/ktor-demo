package tools.samt.client

import tools.samt.client.generated.consumer.GreeterEndpointImpl

fun main() {
    val client = GreeterEndpointImpl("http://localhost:8080")

    println(client.greeting("Sam"))


    println(client.greet(
        name = "Pascal",
        binary = byteArrayOf(1, 2, 3),
        type = tools.samt.client.generated.greeter.GreetingType.HEY,
        anotherString = "Hello",
        inBody = tools.samt.client.generated.greeter.Complex(
            name = "Sam",
            age = 25,
        ),
    ))


    println(client.greetAll(
        names = listOf("Sam", "Pascal", null, "John"),
    ))
}
