package labs.Lab7

import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
class Controller {

    val ctx: ApplicationContext =
        AnnotationConfigApplicationContext(ToDoConfig::class.java)

    var toDo: ToDo = ctx.getBean(ToDo::class.java)


    @RequestMapping("/showAll", method = [RequestMethod.GET])
    fun showAll(): String{
        return toDo.print(toDo.listToDo())
    }

    @RequestMapping("/addTaskTo/{todoItem}/{name}", method = [RequestMethod.GET])
    fun newTaskTo(@PathVariable("todoItem") toDoItem: String, @PathVariable("name") name: String): String?{
        toDo.find(toDoItem)?.subTasks?.add(ToDoItem(name))
        return "Подзадачи для $toDoItem:\n" + showAllFrom(toDoItem)
    }

    @RequestMapping("/addTask/{name}", method = [RequestMethod.GET])
    fun newTask(@PathVariable("name") name: String):String?{
        toDo.add(ToDoItem(name))
        return showAll()
    }

    @RequestMapping("/showAllFrom/{taskName}", method = [RequestMethod.GET])
    fun showAllFrom(@PathVariable("taskName") name: String): String?{
        return toDo.find(name)?.subTasks?.print()
    }
}