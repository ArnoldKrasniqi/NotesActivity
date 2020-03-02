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
import kotlinx.android.synthetic.main.activity_note_added.*

class NoteAdded : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note_added)

        val viewModel = ViewModelProvider(this, ViewModelFactory(application)).get(NotesViewModel::class.java)



        viewModel.completed.observe(this , Observer {
            if(it){
                idNumber++
                startActivity(Intent(this,NotesActivity::class.java))
            }
        })

        viewModel.errorMessage.observe(this, Observer {
            showError(it)
        })

        btn_save.setOnClickListener {
            viewModel.addNote(NotesEntity(idNumber,et_Note.text.toString()))
        }



    }

    private fun showError(error:String) {

    }
}
