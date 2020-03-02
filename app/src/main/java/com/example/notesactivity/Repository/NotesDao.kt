package com.example.notesactivity.Repository

import androidx.room.*
import io.reactivex.Completable
import io.reactivex.Observable


@Dao
interface NotesDao {

    @Insert(
        onConflict = OnConflictStrategy.REPLACE
    )
    fun addNote(notesEntity: NotesEntity): Completable

    @Query(
        "SELECT * FROM notes_table"
    )
    fun getNotes():Observable<List<NotesEntity>>

    @Query(
        "SELECT * FROM notes_table WHERE id = :id"
    )
    fun getNote(id:Int): Observable<NotesEntity>

}