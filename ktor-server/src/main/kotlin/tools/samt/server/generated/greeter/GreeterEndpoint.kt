@file:Suppress("RemoveRedundantQualifierName", "unused", "UnusedImport", "LocalVariableName", "FunctionName", "ConvertTwoComparisonsToRangeCheck", "ReplaceSizeCheckWithIsNotEmpty", "NAME_SHADOWING", "UNUSED_VARIABLE", "NestedLambdaShadowedImplicitParameter", "KotlinRedundantDiagnosticSuppress")

/*
 * This file is generated by SAMT, manual changes will be overwritten.
 * Visit the SAMT GitHub for more details: https://github.com/samtkit/core
 */

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

            // Decode parameter id
            val `parameter id` = run {
                // Read from body
                val jsonElement = body.jsonObject["id"]?.takeUnless { it is JsonNull } ?: return@run null
                tools.samt.server.generated.greeter.`decode ID`(jsonElement)
            }

            // Decode parameter binary
            val `parameter binary` = run {
                // Read from body
                val jsonElement = body.jsonObject["binary"]?.takeUnless { it is JsonNull } ?: return@run null
                jsonElement.jsonPrimitive.content.decodeBase64Bytes()
            }

            // Decode parameter type
            val `parameter type` = run {
                // Read from body
                val jsonElement = body.jsonObject["type"]?.takeUnless { it is JsonNull } ?: return@run null
                tools.samt.server.generated.greeter.`decode GreetingType`(jsonElement)
            }

            // Decode parameter anotherString
            val `parameter anotherString` = run {
                // Read from body
                val jsonElement = body.jsonObject["anotherString"]?.takeUnless { it is JsonNull } ?: return@run null
                jsonElement.jsonPrimitive.content
            }

            // Decode parameter inBody
            val `parameter inBody` = run {
                // Read from body
                val jsonElement = body.jsonObject["inBody"]?.takeUnless { it is JsonNull } ?: return@run null
                tools.samt.server.generated.greeter.`decode Complex`(jsonElement)
            }

            // Call user provided implementation
            val value = greeter.greet(`parameter name`, `parameter id`, `parameter binary`, `parameter type`, `parameter anotherString`, `parameter inBody`)

            // Encode response
            val response = tools.samt.server.generated.greeter.`encode Greeting`(value)

            // Return response with 200 OK
            call.respond(HttpStatusCode.OK, response)
        }

        // Handler for SAMT operation greetAll
        get("/greet/all") {
            // Parse body lazily in case no parameter is transported in the body
            val bodyAsText = call.receiveText()
            val body by lazy { bodyAsText.toJson() }

            // Decode parameter names
            val `parameter names` = run {
                // Read from body
                val jsonElement = body.jsonObject["names"]!!
                jsonElement.jsonArray.map { it.takeUnless { it is JsonNull }?.let { it.jsonPrimitive.content.also { require(it.length >= 1 && it.length <= 50) } } }
            }

            // Call user provided implementation
            val value = greeter.greetAll(`parameter names`)

            // Encode response
            val response = JsonObject(value.mapValues { (_, value) -> value?.let { value -> tools.samt.server.generated.greeter.`encode Greeting`(value) } ?: JsonNull })

            // Return response with 200 OK
            call.respond(HttpStatusCode.OK, response)
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
            val response = JsonPrimitive(value.also { require(it.length >= 1 && it.length <= 100) })

            // Return response with 200 OK
            call.respond(HttpStatusCode.OK, response)
        }

    }

}
