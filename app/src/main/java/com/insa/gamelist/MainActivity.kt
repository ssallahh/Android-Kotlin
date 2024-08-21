package com.insa.gamelist

import ConsoleAdapter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import com.insa.gamelist.databinding.ActivityMainBinding
import com.insa.gamelist.extensions.load
import com.insa.gamelist.utils.DataManager
import java.text.SimpleDateFormat
import java.util.Date

class MainActivity : AppCompatActivity(){
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        // val navController = navHostFragment.navController
    }
}

/*
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // create a game and write its title in logs
        // build the list of games
        // Lire le fichier JSON et initialiser la liste de jeux
        DataManager.readFile(applicationContext)

        // Accéder à la liste de jeux depuis DataManager
        var gamesList = DataManager.games

        // display the number of games
        val numberOfGames = gamesList.size
        Log.d("MainActivity", "Nombre de jeux : $numberOfGames")

        // display the fisrt game
        Log.d("MainActivity", "Premier jeu : ${gamesList.first().title}")

        // display the last game
        Log.d("MainActivity", "Premier jeu : ${gamesList.last().title}")

        // display the game list in alphabetic order
        gamesList = gamesList.sortedBy { it.title }
        Log.d("MainActivity", "Liste de jeux en ordre alphabétique : ${gamesList.map { it.title }}")

        // find and display all "Action-Aventure" game
        DataManager.games.filter { it.type=="Action-Aventure" }.forEach { Log.d("Game", "Action-Aventure : ${it.title}") }

        // find and display the games launched the 14/05/2021 and the 26/10/2021
        DataManager.games.filter { it.type=="Action-Aventure" }.forEach { Log.d("Game", "Action-Aventure : ${it.title}") }

        // display the oldest game launched in the list
        Log.d("Game", "oldest game : ${DataManager.games.minByOrNull { it.timestamp }}")

        // display the list of editor
        DataManager.games.distinct().forEach { game -> Log.d("EditorList", "Editeur : ${game.editor}") }

        // display the last game launched in 2020
        Log.d("Game", "last game launched in 2020 : ${DataManager.games.filter { it.timestamp >= 1577836800000L && it.timestamp < 1609459200000L }.maxByOrNull { it.timestamp }}")

        // display the average year launch for the game list
        Log.d("Game", "average year launch : ${DataManager.games.map { it.timestamp }.average()}")

        // display the number of game launch on all platforms
        DataManager.games.flatMap{ it.console }.distinct().forEach { console ->
            Log.d("Game", "number of game launch on $console : ${DataManager.games.filter { it.console.contains(console) }.size}")
        }
    }
}
*/
