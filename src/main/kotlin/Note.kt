data class Note(val name: String = "Заметка№1", val noteBody: String = "Тест") : Navigation {
    override fun navigate(num:Int,flag:Boolean) {
        when (num) {
            1 -> { openNote() }
            2 -> {
                Archives().step(false)
                Archives().navigate(getCommandConsole(),false)
            }
            else -> println("Не верная команда")
        }
    }

    override fun step(flag: Boolean) {
        println("Открыть заметку → 1")
        println("Вернуться в меню Заметок → 2")
    }

    private fun openNote(){
      println(this.noteBody)
      step()
      navigate(getCommandConsole())
    }



}