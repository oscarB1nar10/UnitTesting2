package com.example.unittesting2.unittesting2.persistence

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.unittesting2.unittesting2.models.Note
import io.reactivex.Single

@Dao
interface NoteDao{

    @Insert
    @Throws(Exception::class)
    fun insertNote(note: Note): Single<Long>

    @Query("SELECT * FROM notes")
    fun getNotes(): LiveData<List<Note>>

    @Delete
    @Throws(Exception::class)
    fun deleteNote(note: Note): Single<Int>

    @Update
    @Throws(Exception::class)
    fun updateNote(note: Note): Single<Int>
}