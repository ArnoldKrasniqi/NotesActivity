package com.example.notesactivity.Repository

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notes_table")

data class NotesEntity(

    @PrimaryKey
    var id:Int,
    var note:String
)