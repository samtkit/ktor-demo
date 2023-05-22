@file:Suppress("RemoveRedundantQualifierName", "unused", "UnusedImport", "LocalVariableName", "FunctionName", "ConvertTwoComparisonsToRangeCheck", "ReplaceSizeCheckWithIsNotEmpty", "NAME_SHADOWING")

package tools.samt.server.generated.greeter

import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.util.*
import kotlinx.serialization.json.*

/** Connector for SAMT provider GreeterEndpoint */
fun Routing.routeGreeterEndpoint(
    greeter: tools.samt.server.generated.greeter.Greeter,
) {
    /** Utility used to convert string to JSON element */
    fun String.toJson() = Json.parseToJsonElement(this)
    /** Utility used to convert string to JSON element or null */
    fun String.toJsonOrNull() = Json.parseToJsonElement(this).takeUnless { it is JsonNull }

    // Handler for SAMT Service Greeter
    route("") {
        // Handler for SAMT operation greet
        post("/greet/{name}") {
            // Parse body lazily in case no parameter is transported in the body
            val bodyAsText = call.receiveText()
            val body by lazy { bodyAsText.toJson() }

            // Decode parameter name
            val `parameter name` = run {
                // Read from path
                val jsonElement = call.parameters["name"]!!.toJson()
                jsonElement.jsonPrimitive.content.also { require(it.length >= 1 && it.length <= 50) }
            }

            // Decode parameter binary
            val `parameter binary` = run {
                // Read from header
                val jsonElement = call.request.headers["binary"]?.toJsonOrNull() ?: return@run null
                jsonElement.jsonPrimitive.content.decodeBase64Bytes()
            }

            // Decode parameter type
            val `parameter type` = run {
                // Read from cookie
                val jsonElement = call.request.cookies["type"]?.toJsonOrNull() ?: return@run null
                `decode GreetingType`(jsonElement)
            }

            // Decode parameter anotherString
            val `parameter anotherString` = run {
                // Read from query
                val jsonElement = call.request.queryParameters["anotherString"]?.toJsonOrNull() ?: return@run null
                jsonElement.jsonPrimitive.content
            }

            // Decode parameter inBody
            val `parameter inBody` = run {
                // Read from body
                val jsonElement = body.jsonObject["inBody"]?.takeUnless { it is JsonNull } ?: return@run null
                `decode Complex`(jsonElement)
            }

            // Call user provided implementation
            val value = greeter.greet(`parameter name`, `parameter binary`, `parameter type`, `parameter anotherString`, `parameter inBody`)

            // Encode response
            val response = `encode Greeting`(value)

            // Return response with 200 OK
            call.respondText(response.toString(), ContentType.Application.Json, HttpStatusCode.OK)
        }

        // Handler for SAMT operation greetAll
        get("/greet/all") {
            // Parse body lazily in case no parameter is transported in the body
            val bodyAsText = call.receiveText()
            val body by lazy { bodyAsText.toJson() }

            // Decode parameter names
            val `parameter names` = run {
                // Read from query
                val jsonElement = call.request.queryParameters["names"]!!.toJson()
                jsonElement.jsonArray.map { jsonElement -> jsonElement.jsonPrimitive.content.also { require(it.length >= 1 && it.length <= 50) } }
            }

            // Call user provided implementation
            val value = greeter.greetAll(`parameter names`)

            // Encode response
            val response = value.map { value -> `encode Greeting`(value) }

            // Return response with 200 OK
            call.respondText(response.toString(), ContentType.Application.Json, HttpStatusCode.OK)
        }

        // Handler for SAMT operation greeting
        get("/greeting/{name}") {
            // Parse body lazily in case no parameter is transported in the body
            val bodyAsText = call.receiveText()
            val body by lazy { bodyAsText.toJson() }

            // Decode parameter name
            val `parameter name` = run {
                // Read from path
                val jsonElement = call.parameters["name"]!!.toJson()
                jsonElement.jsonPrimitive.content.also { require(it.length >= 2 && it.length <= 10) }
            }

            // Call user provided implementation
            val value = greeter.greeting(`parameter name`)

            // Encode response
            val response = Json.encodeToJsonElement(value.also { require(it.length >= 1 && it.length <= 100) })

            // Return response with 200 OK
            call.respondText(response.toString(), ContentType.Application.Json, HttpStatusCode.OK)
        }

    }

}
