import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import java.time.LocalDate

fun main() {
    val ctx: ApplicationContext =
        AnnotationConfigApplicationContext(ToDoConfig::class.java)

    var toDo: ToDo = ctx.getBean(ToDo::class.java)
    toDo.add(ToDoItem("Помыть посуду", Status.ACTIVE))
    toDo.add(ToDoItem("Убраться", Status.ACTIVE))
    toDo.add(ToDoItem("Погулять с собакой", Status.DONE))
    toDo.add(ToDoItem("Отдохнуть", Status.ACTIVE))

    toDo.print(toDo.listToDo())

    toDo.deleteDone()

    toDo.print(toDo.listToDo())


    //Menu ToDo
    while (true){
        println("1) add -> Добавить задачу\n2) print -> Вывести все\n3) find -> Найти задачу\n4) del -> удалить задачу")
        when(readLine()!!.toString()){
            "add" -> {
                println("Введите описание")
                toDo.add(ToDoItem(readLine()!!.toString()))
            }
            "print" -> {
                toDo.print(toDo.listToDo())
            }
            "find" -> {
                println("Введите описание")
                println(toDo.find(readLine()!!.toString()).toString())
            }
            "del" -> {
                println("Введите описание")
                toDo.delete(readLine()!!.toString())
            }
            else -> {
                println("Выйти? y/n")
                if (readLine()!!.toString().equals("y")) break
                else continue
            }
        }
    }

}