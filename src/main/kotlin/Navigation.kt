import java.util.*

class Navigation {
    private val archive = MakeArchives()
    private var console = Scanner(System.`in`)
    private var Note: String = ""
    private var Archive: String = ""
    fun snowFirstScreen(){
        println("Добро пожаловать!")
        println("Выберите необходимое действие")
        println("Создать архив → 1")
        println("Выбрать архив → 2")
        println("Выход → 3")
    }

    fun snowSecondScreen(name: String){
        println("Вы находитесь в $name")
        println("Выбрать заметку → 1")
        println("Создать заметку → 2")
        println("Вернуться в меню Архивов → 3")
    }

    fun snowThirdScreen(){
        println("Посмотреть заметку → 1")
        println("Вернуться в меню Заметок → 2")
    }

    fun chooseStep(){
        while (true){
            if (console.hasNextInt()){
                val a = console.nextInt()
                when(a){
                    1 -> {
                        makeArchive()
                        break
                    }
                    2 ->{
                        chooseArchieve()
                        break
                    }
                    3-> return
                }

            } else{
                println("Введите число от 1 до 3")
            }
        }


    }

    fun chooseStepTwo(name: String){
        while (true){
            snowSecondScreen(name)
            archive.showNotes(name)
            if (console.hasNextInt()){
                val a = console.nextInt()
                when(a){
                    1 -> {
                        chooseNote()
                        break
                    }
                    2 ->{
                        makeNote()
                        snowSecondScreen(name)
                    }
                    3-> snowFirstScreen()
                }

            } else{
                println("Введите число от 1 до 3")
            }
        }
    }

    fun chooseStepThree(){
        while (true){
            snowThirdScreen()
//            archive.showNotes(name)
            if (console.hasNextInt()){
                val a = console.nextInt()
                when(a){
                    1 -> {
                        chooseNote()
                        break
                    }
                    2 ->{
                        makeNote()

                    }
                    3-> snowFirstScreen()
                }

            } else{
                println("Введите число от 1 до 3")
            }
        }
    }


    fun makeArchive(){
        println("Введите имя архива")
        val nameA = Scanner(System.`in`).nextLine()
        archive.makeArchive(nameA)
        println("Архив $nameA успешно создан!")
        snowFirstScreen()
        chooseStep()
    }


    fun makeNote(){
        println("Введите имя заметки")
        val nameNote = Scanner(System.`in`).nextLine()
        println("Введите текст заметки")
        val noteBody = Scanner(System.`in`).nextLine()
        archive.getArchive(Archive).put(nameNote,noteBody)
        println("Заметка успешно создана")

    }

    fun chooseNote(){
        archive.showNotes(Archive)
        println("Введите имя заметки")
        while (true) {
            val a = Scanner(System.`in`).nextLine()
            if (archive.getArchive(Archive).containsKey(a)) {
                Note = a
                break
            } else {
                println("Неправильно указано имя Заметки")
                archive.showNotes(Archive)
                println("Веедите имя заметки заново")
            }
        }
        println(archive.getNote(Archive,Note))


    }



    fun chooseArchieve() {
       if (archive.getSize() > 0){
           println("Укажите архив который хотите открыть")
           println("Или введите 'Отмена' для возврата в меню  ")
           archive.showArchives()
           while (true) {
               val a = Scanner(System.`in`).nextLine()
               if (archive.contains(a)) {
                   Archive = a
                   break
               } else {
                   println("Неправильно узказан архив")
                   archive.showArchives()
                   println("Веедите имя архива")
               }
           }
        chooseStepTwo(Archive)
       } else {
           println("Хранилие архивов пустое!")
           chooseStep()
       }
    }





}