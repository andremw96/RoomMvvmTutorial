package andreamw.com.myroomviewmodel.dao

import andreamw.com.myroomviewmodel.entity.Note
import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface NoteDao {

    @Insert
    fun insert(note: Note)

    @Query("DELETE FROM note_table")
    fun deleteAllNotes()

    @Query("SELECT * FROM note_table")
    fun getAllNotes() : LiveData<List<Note>>

}