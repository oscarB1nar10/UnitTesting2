package com.example.unittesting2.unittesting2.models

import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Entity(tableName = "notes")
@Parcelize
data class Note(
    @PrimaryKey(autoGenerate = true)
    val id: Int = -1,
    @NonNull
    @ColumnInfo(name = "title")
    val title: String = "",
    @ColumnInfo(name = "content")
    val content: String = "",
    @ColumnInfo(name = "timestamp")
    val timestamp: String = ""

) : Parcelable {

    override fun equals(other: Any?): Boolean {
        other?.let{
            if(javaClass != other.javaClass){
                return false
            }
            val note: Note = other as Note
            return note.id == id && note.title == title && note.content == content
        }
        return false
    }
}