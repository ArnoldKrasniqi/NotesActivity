package com.example.notesactivity.View

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.notesactivity.R
import com.example.notesactivity.Repository.NotesEntity
import kotlinx.android.synthetic.main.card_notes.view.*

class NotesAdapter(
    private val notesList: List<NotesEntity>,
    private val recyclerViewOnClick: RecyclerViewOnClick
): RecyclerView.Adapter<NotesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_notes,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
       return notesList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.tv_note.text = notesList[position].note
        holder.itemView.setOnClickListener {
            recyclerViewOnClick.OnClickListener(notesList[position].id)
        }

    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }
}