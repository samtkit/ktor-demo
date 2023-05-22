@file:Suppress("RemoveRedundantQualifierName", "unused", "UnusedImport", "LocalVariableName", "FunctionName", "ConvertTwoComparisonsToRangeCheck", "ReplaceSizeCheckWithIsNotEmpty", "NAME_SHADOWING")

package tools.samt.client.generated.greeter

import io.ktor.util.*
import kotlinx.serialization.json.*

/** Encode and validate record tools.samt.greeter.Greeting to JSON */
fun `encode Greeting`(record: tools.samt.client.generated.greeter.Greeting): JsonObject {
    // Encode field message
    val `field message` = run {
        val value = record.message
        Json.encodeToJsonElement(value.also { require(it.length <= 128) })
    }
    // Create JSON for tools.samt.greeter.Greeting
    return buildJsonObject {
        put("message", `field message`)
    }
}
/** Decode and validate record tools.samt.greeter.Greeting from JSON */
fun `decode Greeting`(json: JsonElement): tools.samt.client.generated.greeter.Greeting {
    // Decode field message
    val `field message` = run {
        val jsonElement = json.jsonObject["message"]!!
        jsonElement.jsonPrimitive.content.also { require(it.length <= 128) }
    }
    // Create record tools.samt.greeter.Greeting
    return tools.samt.client.generated.greeter.Greeting(
        message = `field message`,
    )
}

/** Encode and validate record tools.samt.greeter.Complex to JSON */
fun `encode Complex`(record: tools.samt.client.generated.greeter.Complex): JsonObject {
    // Encode field name
    val `field name` = run {
        val value = record.name
        Json.encodeToJsonElement(value)
    }
    // Encode field age
    val `field age` = run {
        val value = record.age
        Json.encodeToJsonElement(value.also { require(it >= 1) })
    }
    // Create JSON for tools.samt.greeter.Complex
    return buildJsonObject {
        put("name", `field name`)
        put("age", `field age`)
    }
}
/** Decode and validate record tools.samt.greeter.Complex from JSON */
fun `decode Complex`(json: JsonElement): tools.samt.client.generated.greeter.Complex {
    // Decode field name
    val `field name` = run {
        val jsonElement = json.jsonObject["name"]!!
        jsonElement.jsonPrimitive.content
    }
    // Decode field age
    val `field age` = run {
        val jsonElement = json.jsonObject["age"]!!
        jsonElement.jsonPrimitive.int.also { require(it >= 1) }
    }
    // Create record tools.samt.greeter.Complex
    return tools.samt.client.generated.greeter.Complex(
        name = `field name`,
        age = `field age`,
    )
}

/** Encode enum tools.samt.greeter.GreetingType to JSON */
fun `encode GreetingType`(value: tools.samt.client.generated.greeter.GreetingType) = when(value) {
    tools.samt.client.generated.greeter.GreetingType.HELLO -> "HELLO"
    tools.samt.client.generated.greeter.GreetingType.HI -> "HI"
    tools.samt.client.generated.greeter.GreetingType.HEY -> "HEY"
    tools.samt.client.generated.greeter.GreetingType.FAILED_TO_PARSE -> error("Cannot encode FAILED_TO_PARSE value")
}
/** Decode enum tools.samt.greeter.GreetingType from JSON */
fun `decode GreetingType`(json: JsonElement) = when(json.jsonPrimitive.content) {
    "HELLO" -> tools.samt.client.generated.greeter.GreetingType.HELLO
    "HI" -> tools.samt.client.generated.greeter.GreetingType.HI
    "HEY" -> tools.samt.client.generated.greeter.GreetingType.HEY
    // Value not found in enum tools.samt.greeter.GreetingType
    else -> tools.samt.client.generated.greeter.GreetingType.FAILED_TO_PARSE
}

