import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class MainKtTest {

    @Test
    fun getPerson() {
        val person = getPerson("spiderman")
        assertTrue(person.equals(Person("spiderman", 41, 680)))
    }
}