




class MakeArchives() {
    private var notes = mutableMapOf<String,String>()
    private var archive = mutableMapOf<String,MutableMap<String,String>>()

    fun makeArchive(name: String){
        archive.put(name, notes)
    }

    fun getArchive(key: String) : MutableMap<String,String>{
        return archive.get(key)?: notes
    }

    fun putNoteInArchive(key: String,noteName: String, note: String){
        archive.get(key)?.put(noteName,note)
    }

    fun getNote(key:String,noteName: String) : String{
        return archive.get(key)?.get(noteName).toString()
    }

    fun showArchives() = println(archive.keys)
    fun getSize():Int = archive.size
    fun contains(key: String):Boolean = archive.containsKey(key)
    fun showNotes(key: String) = println(archive.get(key))


}

// разнести на 2 класса
//создать интерфейс который будет вход и выход
// и еще класс с переходами