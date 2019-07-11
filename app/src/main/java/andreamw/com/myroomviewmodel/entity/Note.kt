package andreamw.com.myroomviewmodel.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "note_table")
data class Note (
    var title : String,
    var description : String
) {
    @PrimaryKey(autoGenerate = true)
    var id : Int = 0
}