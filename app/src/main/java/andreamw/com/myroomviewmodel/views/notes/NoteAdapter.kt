package andreamw.com.myroomviewmodel.views.notes

import andreamw.com.myroomviewmodel.R
import andreamw.com.myroomviewmodel.entity.Note
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NoteAdapter : RecyclerView.Adapter<NoteHolder>() {

    private var notes : List<Note> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.note_item, parent, false)
        return NoteHolder(view)
    }

    override fun getItemCount(): Int = notes.size

    override fun onBindViewHolder(holder: NoteHolder, position: Int) {
        holder.textViewTitle.text = notes.get(position).title
        holder.textViewDescription.text = notes.get(position).description
    }

    fun setNotes(notes: List<Note>) {
        this.notes = notes
        notifyDataSetChanged()
    }
}

class NoteHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var textViewTitle: TextView = itemView.findViewById(R.id.text_view_title)
    var textViewDescription: TextView = itemView.findViewById(R.id.text_view_description)
}
