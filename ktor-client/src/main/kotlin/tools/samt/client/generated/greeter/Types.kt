@file:Suppress("RemoveRedundantQualifierName", "unused", "UnusedImport", "LocalVariableName", "FunctionName", "ConvertTwoComparisonsToRangeCheck", "ReplaceSizeCheckWithIsNotEmpty", "NAME_SHADOWING")

package tools.samt.client.generated.greeter

class Greeting(
    val message: String,
)

class Complex(
    val name: String,
    val age: Int,
)

enum class GreetingType {
    /** Default value used when the enum could not be parsed */
    FAILED_TO_PARSE,
    HELLO,
    HI,
    HEY,
}
interface Greeter {
    fun greet(
        name: String,
        binary: ByteArray? = null,
        type: tools.samt.client.generated.greeter.GreetingType? = null,
        anotherString: String? = null,
        inBody: tools.samt.client.generated.greeter.Complex? = null,
    ): tools.samt.client.generated.greeter.Greeting
    fun greetAll(
        names: List<String>,
    ): List<tools.samt.client.generated.greeter.Greeting>
    fun greeting(
        name: String,
    ): String
}
