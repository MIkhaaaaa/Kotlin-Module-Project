import java.util.*

class Archives() : Navigation {
    private val console = Scanner(System.`in`)
    private var noteList = mutableListOf<Note>()
    private var archive: MutableMap<String, MutableList<Note>> = mutableMapOf()
    private var actualKey:String = ""
    private lateinit var actualNote:Note


    private fun makeArchive() {
        println("Введите имя архива")
        val nameA = console.nextLine()
        archive.put(nameA,noteList)
        println("Архив успешно создан")
        step()
        navigate(getCommandConsole())
    }

    private fun getArchive() {
        println("Введите имя архива")
        println("Введите 'Отмена' для выхода в меню")
        while (true) {
            val key = console.nextLine()
            if (key.equals("Отмена",true)) break
            if (archive.containsKey(key)) {
                actualKey = key
                break
            } else {
                println("Такого архива нет!")
            }
        }
        step(false)
        navigate(getCommandConsole(),false)
    }

    fun contains(key: String): Boolean = archive.containsKey(key)
    private fun showNotes() {
        val notes = archive.get(actualKey)
        notes?.forEach{ note -> println(note.name)}
        println("Введите имя заметки")
        println("Для выхода введите 'Отмена'")
        while (true){
           val a = console.nextLine()
           if(a.equals("Отмена",true)) break
           val note = getNoteFromList(notes!!,a)
           if (notes.contains(note)) {
              actualNote = note
              break
           } else {
               println("Вы ввели неверное имя")
           }
        }
        actualNote.step()
        actualNote.navigate(getCommandConsole())
    }
    private fun createNote() {
        println("Введите имя заметки")
        val nameNote = console.nextLine()
        println("Напишите то чего хотели")
        val noteBody = console.nextLine()
        noteList.add(Note(nameNote,noteBody))
        archive.put(actualKey,noteList)
        println("Заметка создана успешно")
        step(false)
        navigate(getCommandConsole(),false)

    }


    override fun navigate(num: Int, flag: Boolean) {
        if (flag) {
            when (num) {
                1 ->  makeArchive()
                2 -> getArchive()
                3 -> stop()
            }
        } else {
            when (num) {
                1 -> createNote()
                2 -> { showNotes() }
                3 -> {
                    step(true)
                    navigate(getCommandConsole(),true)
                }
            }
        }
    }

    override fun step(flag: Boolean) {
        if (flag) {
            println("Создать архив → 1")
            println("Выбрать архив → 2")
            println("Выход → 3")
        } else {
            println("Создать заметку → 1")
            println("Выбрать заметку → 2")
            println("Выход в Архивы → 3")
        }
    }

    private fun getNoteFromList(notes:List<Note>,name:String):Note{
        return notes.find {note: Note -> note.name.equals(name)}?:Note()
    }

}

