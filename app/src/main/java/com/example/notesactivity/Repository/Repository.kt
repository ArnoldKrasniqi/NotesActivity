package com.example.notesactivity.Repository

import android.app.Application
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import io.reactivex.android.schedulers.AndroidSchedulers

class Repository(application : Application) : RepositoryInterface {

    private val notesDao = NotesDatabase.getInstance(application.applicationContext).notesDao()

    override fun addNote(notesEntity: NotesEntity) : Completable {
            return notesDao.addNote(notesEntity)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
    }

    override fun getAllNotes():Observable<List<NotesEntity>> {
        return notesDao.getNotes()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    override fun getNote(id:Int): Observable<NotesEntity>{
        return notesDao.getNote(id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}