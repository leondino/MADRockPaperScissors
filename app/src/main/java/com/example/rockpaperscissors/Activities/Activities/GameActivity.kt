package com.example.rockpaperscissors.Activities.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.example.rockpaperscissors.R
import kotlinx.android.synthetic.main.activity_game.*

class GameActivity : AppCompatActivity() {

    var gameOutcome: String = "No game played yet..."
    var  computerSet: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        initViews()
    }

    private fun initViews(){
        btnRock.setOnClickListener { onRockClick() }
        btnPaper.setOnClickListener { onPaperClick() }
        btnScissors.setOnClickListener { onScissorClick() }
    }

    private fun onRockClick() =
        onGamePlay(ROCK)

    private fun onPaperClick() =
        onGamePlay(PAPER)

    private fun onScissorClick() =
        onGamePlay(SCISSORS)

    private fun updateUI(playerSet: Int){
        when(gameOutcome){
            "Win" -> tvResult.text = getString(R.string.win_text)
            "Lose" -> tvResult.text = getString(R.string.lose_text)
            "Draw" -> tvResult.text = getString(R.string.draw_text)
            else -> print("Error, invalid outcome")
        }
        when(playerSet){
            ROCK -> ivPlayer.setImageResource(
                R.drawable.rock
            )
            PAPER -> ivPlayer.setImageResource(
                R.drawable.paper
            )
            SCISSORS -> ivPlayer.setImageResource(
                R.drawable.scissors
            )
        }
        when(computerSet){
            ROCK -> ivComputer.setImageResource(
                R.drawable.rock
            )
            PAPER -> ivComputer.setImageResource(
                R.drawable.paper
            )
            SCISSORS -> ivComputer.setImageResource(
                R.drawable.scissors
            )
        }
    }

    private fun onGamePlay(playerSet: Int){
        calculateGame(playerSet)
        updateUI(playerSet)
        // Create a game object and insert it into database
    }

    private fun calculateGame(playerSet: Int){
        computerSet = (0..2).random()
        when(playerSet){
            ROCK ->
                when(computerSet){
                    ROCK -> gameOutcome = "Draw"
                    PAPER -> gameOutcome = "Lose"
                    SCISSORS -> gameOutcome = "Win"
                    else -> print("Error, invalid computer set")
                }
            PAPER ->
                when(computerSet){
                    ROCK -> gameOutcome = "Win"
                    PAPER -> gameOutcome = "Draw"
                    SCISSORS -> gameOutcome = "Lose"
                    else -> print("Error, invalid computer set")
                }
            SCISSORS ->
                when(computerSet){
                    ROCK -> gameOutcome = "Lose"
                    PAPER -> gameOutcome = "Win"
                    SCISSORS -> gameOutcome = "Draw"
                    else -> print("Error, invalid computer set")
                }
            else -> print("Error, invalid player set")
        }
    }

    private fun startHistoryActivity(){
        val intent = Intent(this, HistoryActivity::class.java)
        startActivity(intent)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_game, menu)
        return true
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_check_history -> {
                startHistoryActivity()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    companion object{
        const val ROCK = 0
        const val PAPER = 1
        const val SCISSORS = 2
    }

}
