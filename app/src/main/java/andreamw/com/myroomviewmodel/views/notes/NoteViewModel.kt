package andreamw.com.myroomviewmodel.views.notes

import andreamw.com.myroomviewmodel.entity.Note
import andreamw.com.myroomviewmodel.repository.NoteRepository
import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel

class NoteViewModel(application: Application) : AndroidViewModel(application) {

    private var repository: NoteRepository = NoteRepository(application)
    private var allNotes: LiveData<List<Note>> = repository.getAllNotes()

    fun insert(note: Note) {
        repository.insert(note)
    }

    fun deleteAllNotes() {
        repository.deleteAllNotes()
    }

    fun getAllNotes() : LiveData<List<Note>> {
        return allNotes
    }

}