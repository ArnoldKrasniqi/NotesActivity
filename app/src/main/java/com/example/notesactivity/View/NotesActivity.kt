package com.example.notesactivity.View

import android.content.Intent
import android.os.Bundle
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.notesactivity.R
import com.example.notesactivity.ViewModel.NotesViewModel
import com.example.notesactivity.ViewModel.ViewModelFactory
import kotlinx.android.synthetic.main.activity_notes.*
import kotlinx.android.synthetic.main.error_layout.*

class NotesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notes)

        val viewModel = ViewModelProvider(this,ViewModelFactory(application)).get(NotesViewModel::class.java)
        viewModel.getNotes()

        viewModel.getNotesList.observe(this, Observer {
            errorLayout.visibility = GONE
            rv_notesRecyclerView.visibility = VISIBLE

            rv_notesRecyclerView.layoutManager = LinearLayoutManager(this@NotesActivity)
            rv_notesRecyclerView.adapter = NotesAdapter(it,object : RecyclerViewOnClick{
                override fun OnClickListener(id: Int) {
                    val intentToNoteUpdate = Intent(this@NotesActivity,NoteUpdated::class.java)
                    intentToNoteUpdate.putExtra(ID_KEY,id)
                    startActivity(intentToNoteUpdate)
                }
            })
        })

        viewModel.errorMessage.observe(this, Observer {
            rv_notesRecyclerView.visibility = GONE
            errorLayout.visibility = VISIBLE
            tv_errorMessage.append(it)
        })

        fab_addNote.setOnClickListener {
            startActivity(Intent(this@NotesActivity, NoteAdded::class.java))
        }

    }
}
