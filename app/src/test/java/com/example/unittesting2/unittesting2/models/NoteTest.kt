package com.example.unittesting2.unittesting2.models

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class NoteTest {

    private val TIMESTAMP1 = "05-2019"
    private val TIMESTAMP2 = "04-2019"
    /*
    Compare two equals Notes
     */
    @Test
     fun isNotesEqualsIdenticalProperties() {
        val note1 = Note(1,"Note #1", "this is note #1", TIMESTAMP1)
        val note2 = Note(1,"Note #1", "this is note #1", TIMESTAMP1 )

        assertEquals(note1,note2)
        println("The notes are equals")
    }
    /*
    Compare notes with 2 different ids
     */
    @Test
     fun isNotesEqualDifferentIds() {
        val note1 = Note(1,"Note #1", "this is note #1", TIMESTAMP1)
        val note2 = Note(2,"Note #1", "this is note #1", TIMESTAMP1 )

        assertNotEquals(note1, note2)
        println("The notes are not equals different id")
    }

    /*
    Compare two notes with different timestamps
     */
    @Test
    fun isNotesEqualsWithDifferentTimeStamps(){
        val note1 = Note(1,"Note #1", "this is note #1", TIMESTAMP1)
        val note2 = Note(1,"Note #1", "this is note #1", TIMESTAMP2)

        assertEquals(note1,note2)
        println("The notes are equals with different timestamp")
    }

    /*
    Compare two notes with different titles
     */
    @Test
    fun isNotesEqualsWithDifferentTitle(){
        val note1 = Note(1,"Note #1", "this is note #1", TIMESTAMP1)
        val note2 = Note(1,"Note #2", "this is note #1", TIMESTAMP1)

        assertNotEquals(note1,note2)
        println("The notes are not equals they have different titles")
    }

    /*
    Compare two notes with different content
     */
    @Test
    fun isNotesEqualsWithDifferentContent(){
        val note1 = Note(1,"Note #1", "this is note #1", TIMESTAMP1)
        val note2 = Note(1,"Note #2", "this is note #1", TIMESTAMP2)

        assertNotEquals(note1,note2)
        println("The notes are not equals they have different content")
    }

}
