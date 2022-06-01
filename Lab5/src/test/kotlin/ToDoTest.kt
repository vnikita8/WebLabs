import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
internal class ToDoTest {

    @Autowired
    var todo = ToDo()

    @Test
    fun add() {
        todo.add(ToDoItem())
        assertEquals(1, todo.listToDo().size)
    }

    @Test
    fun delete() {
        todo.add(ToDoItem())
        todo.add(ToDoItem())
        todo.delete("Новая задача")
        assertEquals(1, todo.listToDo().size)

    }

    @Test
    fun deleteActive() {
        todo.add(ToDoItem())
        todo.deleteActive()
        assertEquals(0, todo.listToDo().size)
    }

    @Test
    fun deleteDone() {
        todo.add(ToDoItem("1123", Status.DONE))
        todo.deleteDone()
        assertEquals(0, todo.listToDo().size)
    }

    @Test
    fun deleteAll() {
        todo.add(ToDoItem("1123", Status.DONE))
        todo.deleteAll()
        assertEquals(0, todo.listToDo().size)
    }

    @Test
    fun changeDescription() {
        todo.add(ToDoItem("1123", Status.DONE))
        todo.changeDescription("1123", "123", Status.ACTIVE)
        assertEquals(todo.find("123")?.description, "123")
    }

    @Test
    fun chaneStatus() {
        todo.add(ToDoItem("1123", Status.DONE))
        todo.chaneStatus("1123", Status.ACTIVE)
        assertEquals(todo.find("1123")?.status, Status.ACTIVE)
    }

    @Test
    fun find() {
        todo.add(ToDoItem("123", Status.DONE))
        assertEquals(todo.find("123")?.description, "123")
    }

}