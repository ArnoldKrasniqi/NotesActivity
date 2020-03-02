package com.example.notesactivity.View

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.notesactivity.R
import com.example.notesactivity.Repository.NotesEntity
import com.example.notesactivity.ViewModel.NotesViewModel
import com.example.notesactivity.ViewModel.ViewModelFactory
import kotlinx.android.synthetic.main.activity_note_updated.*

class NoteUpdated : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note_updated)

        val id = intent.getIntExtra(ID_KEY,0)

        val viewModel = ViewModelProvider(this,ViewModelFactory(this@NoteUpdated.application)).get(NotesViewModel::class.java)

        viewModel.getNote(id)

        viewModel.note.observe(this, Observer {
            et_NoteUpdated.setText(it.note)
        })

        btn_update.setOnClickListener {
            viewModel.addNote(NotesEntity(id,et_NoteUpdated.text.toString()))
            startActivity(Intent(this@NoteUpdated,NotesActivity::class.java))
        }


    }
}
