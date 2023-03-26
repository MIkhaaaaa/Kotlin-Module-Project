import java.util.Scanner

fun main() {
    start()
}


fun start() {
    println("Добро пожаловать!")
    val archive = Archives()
    archive.step()
    archive.navigate(getCommandConsole())
}


fun stop() = println("Спасибо что воспользовались программой по хранению заметок")

fun getCommandConsole(): Int {
    val console = Scanner(System.`in`)
    while (true) {
        if (console.hasNextInt()) {
            val a = console.nextInt()
            when(a){
                1 -> return 1
                2 -> return 2
                3 -> return 3
                else -> println("Введите число от 1 до 3!!!!")
            }
        } else {
            println("Введите число от 1 до 3!!!!")
            console.next()
        }
    }
}

