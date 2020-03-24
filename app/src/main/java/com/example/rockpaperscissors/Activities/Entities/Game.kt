package com.example.rockpaperscissors.Activities.Entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "gameTable")
data class Game (

    @ColumnInfo(name = "date")
    var date: Date,

    @ColumnInfo(name = "outcome")
    var outcome: String,

    @ColumnInfo(name = "player set")
    var playerSet: Int,

    @ColumnInfo(name = "computer set")
    var computerSet: Int?,

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Long? = null
)
