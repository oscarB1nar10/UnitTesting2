package com.example.unittesting2.unittesting2

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import com.example.unittesting2.unittesting2.models.Note
import com.example.unittesting2.unittesting2.persistence.NoteDao
import com.example.unittesting2.unittesting2.persistence.NoteDatabase
import com.example.unittesting2.unittesting2.util.TestUtil
import org.junit.After
import org.junit.Before

abstract class NoteDatabaseTest {

    //system under test
    lateinit var noteDatabase: NoteDatabase
    var note: Note = TestUtil.note

    fun getNoteDao(): NoteDao{
        return noteDatabase.getNoteDao()
    }

    //inMemoryDatabaseBuilder: A database only alive if app live
    @Before
    fun init(){
        noteDatabase = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            NoteDatabase::class.java
        ).build()
    }

    @After
    fun finish(){
        noteDatabase.close()
    }

}