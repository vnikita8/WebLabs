import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.boot.CommandLineRunner


@SpringBootApplication
class ToDoApplication:CommandLineRunner{
    var logger: Logger = LoggerFactory.getLogger(ToDoApplication::class.java)

    override fun run(vararg args: String?) {
        logger.info("EXECUTING: cmd runner")
        val toDo: ToDo = ToDo()

        while (true) {
            println("1) add -> Добавить задачу\n2) print -> Вывести все\n3) find -> Найти задачу\n4) del -> удалить задачу")
            when (readLine()!!.toString()) {
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
}



fun main(args: Array<String>){
    runApplication<ToDoApplication>(*args)

}