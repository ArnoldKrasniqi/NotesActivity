package com.example.notesactivity

import com.example.notesactivity.Repository.NotesEntity
import com.example.notesactivity.Repository.Repository
import com.example.notesactivity.ViewModel.NotesViewModel
import io.reactivex.Completable
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */

@RunWith(MockitoJUnitRunner::class)
class ExampleUnitTest {

    @Mock
    private lateinit var repository: Repository

    @Mock
    private lateinit var model: NotesViewModel

    private val notesEntity = NotesEntity(1,"MyMannn")


    @Before
    fun setup(){

        model = NotesViewModel(repository)

    }


    @Test
    fun`when getNotes is called all the notes are returned as a list`(){
        //Given
        Mockito.`when`(model.)
        //When

        //Then
    }

    @Test
    fun `when get note is called, you get the note of the specific id`(){
        //Given

        //When

        //Then
    }

}
