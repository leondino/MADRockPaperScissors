package com.example.rockpaperscissors.Activities.Database

import android.content.Context
import com.example.rockpaperscissors.Activities.Entities.Game

class GameRepository(context: Context) {
    private val gameDao: GameDao

    init {
        val database = GamesRoomDatabase.getDatabase(context)
        gameDao = database!!.gameDao()
    }

    suspend fun getAllGames(): List<Game> = gameDao.getAllGames()

    suspend fun insertGame(game: Game) = gameDao.insertGame(game)

    suspend fun deleteAllGames() = gameDao.deleteAllGames()

    suspend fun getWins() : Int? = gameDao.getWins()

    suspend fun getLoses(): Int? = gameDao.getLoses()

    suspend fun getDraws(): Int? = gameDao.getDraws()

}