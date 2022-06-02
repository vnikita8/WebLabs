import kotlinx.serialization.Serializable
import kotlinx.serialization.json.*
import java.net.HttpURLConnection
import java.net.URL

fun main() {
    print(getPerson("spiderman"))
}

@Serializable
data class Person(val name: String = "",  val age: Int = 0, val count: Int = 0)

fun getPerson(personName: String): Person{
    var person = Person()
    try {
        val url = URL("https://api.agify.io?name=$personName")
        val con: HttpURLConnection = url.openConnection() as HttpURLConnection
        con.connectTimeout = 5000
        con.readTimeout = 5000

        //инфо
        println(con)
        println(con.responseCode)
        println(con.responseMessage)

        val reader = con.inputStream.reader()
        var json = reader.readText()
        reader.close()
        con.disconnect()
        var encode: JsonElement = Json.parseToJsonElement(json)
        person = Json.decodeFromJsonElement(encode,)
    } catch (e: Exception){
        e.printStackTrace()
    }
    return person

}