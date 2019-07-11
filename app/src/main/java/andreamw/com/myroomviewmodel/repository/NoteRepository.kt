package andreamw.com.myroomviewmodel.repository

import andreamw.com.myroomviewmodel.dao.NoteDao
import andreamw.com.myroomviewmodel.database.NoteDatabase
import andreamw.com.myroomviewmodel.entity.Note
import android.app.Application
import android.os.AsyncTask
import androidx.lifecycle.LiveData

class NoteRepository(application: Application) : NoteDao {

    private var noteDao : NoteDao
    private var allNotes : LiveData<List<Note>>

    init {
        val database: NoteDatabase = NoteDatabase.getInstance(
            application.applicationContext
        )!!

        noteDao = database.noteDao()
        allNotes = noteDao.getAllNotes()
    }

    override fun insert(note: Note) {
        InsertNoteAsyncTask(noteDao).execute(note)
    }

    override fun deleteAllNotes() {
        DeleteNoteAsyncTask(noteDao).execute()
    }

    override fun getAllNotes() : LiveData<List<Note>> {
        return allNotes
    }

    private class InsertNoteAsyncTask(val noteDao: NoteDao) : AsyncTask<Note, Unit, Unit>() {
        override fun doInBackground(vararg params: Note?) {
            noteDao.insert(params[0]!!)
        }
    }

    private class DeleteNoteAsyncTask(val noteDao: NoteDao) : AsyncTask<Unit, Unit, Unit>() {
        override fun doInBackground(vararg params: Unit?) {
            noteDao.deleteAllNotes()
        }

    }

}