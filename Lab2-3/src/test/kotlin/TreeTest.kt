import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class TreeTest {

    //Сразу 2 метода
    var tree = Tree()
    @Test
    fun main(){
        tree.add(value = 6)
        tree.add(value = 4)
        tree.add(value = 3)
        tree.add(value = 8)
        assertTrue(tree.check(value = 8))
    }

}