package com.example.notesactivity.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.notesactivity.Repository.NotesEntity
import com.example.notesactivity.Repository.Repository
import com.example.notesactivity.Repository.RepositoryInterface
import io.reactivex.Completable
import io.reactivex.disposables.CompositeDisposable

class NotesViewModel(application: Application) : AndroidViewModel(application) {


    private val compositeDisposable = CompositeDisposable()

    private val repository : RepositoryInterface = Repository(application)

    val completed = MutableLiveData<Boolean>()
    val getNotesList = MutableLiveData<List<NotesEntity>>()
    val errorMessage = MutableLiveData<String>()
    val note = MutableLiveData<NotesEntity>()


    fun addNote(notesEntity: NotesEntity) {
        compositeDisposable.add(repository.addNote(notesEntity)
            .subscribe({
                completed.value = true
            }, {
                completed.value = false
                errorMessage.value = it.message
            })
        )
    }

    fun getNotes() {
        compositeDisposable.add(
            repository.getAllNotes()
                .subscribe({
                    getNotesList.value = it
                },{
                    errorMessage.value = it.message
                })
        )
    }

    fun getNote(id:Int) {
        compositeDisposable.add(
            repository.getNote(id)
                .subscribe({
                   note.value = it
                },{
                    errorMessage.value = it.message
                })
        )
    }

    override fun onCleared() {
        compositeDisposable.clear()
        super.onCleared()
    }
}