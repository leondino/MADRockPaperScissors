package com.example.rockpaperscissors.Activities.Database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.rockpaperscissors.Activities.Entities.Game

@Dao
interface GameDao {
    @Query("SELECT * FROM gameTable")
    suspend fun getAllGames(): List<Game>

    @Insert
    suspend fun insertGame(game: Game)

    @Query("DELETE FROM gameTable")
    suspend fun deleteAllGames()

    @Query("SELECT COUNT(*) FROM gameTable WHERE outcome='Win'")
    suspend fun getWins() : Int?

    @Query("SELECT COUNT(*) FROM gameTable WHERE outcome='Lose'")
    suspend fun getLoses(): Int?

    @Query("SELECT COUNT(*) FROM gameTable WHERE outcome='Draw'")
    suspend fun getDraws(): Int?
}