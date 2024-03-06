package com.insa.gamelist

import ConsoleAdapter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.insa.gamelist.databinding.ActivityMainBinding
import com.insa.gamelist.extensions.load
import com.insa.gamelist.utils.DataManager
import java.text.SimpleDateFormat
import java.util.Date

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


        // pour le TP 5
        //binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root


        setContentView(view)

        val selectedGame = gamesList.firstOrNull()
        if (selectedGame != null) {
            // Set the game details to the layout
            val date = SimpleDateFormat("dd/MM/yyyy").format(Date(selectedGame.timestamp))
            val consoleAdapter = ConsoleAdapter(selectedGame.console)
            binding.includeGameDetails.recyclerViewConsole.adapter = consoleAdapter
            binding.includeGameDetails.nameGame.text = getString(R.string.game_details_title, selectedGame.title)
            binding.includeGameDetails.dateGame.text = getString(R.string.game_details_date, date)
            binding.includeGameDetails.genreGame.text = "Genre: ${selectedGame.type}"
            binding.includeGameDetails.devGame.text = "Développeur: ${selectedGame.developer}"
            binding.includeGameDetails.editorGame.text = "Editeur: ${selectedGame.editor}"
            binding.includeGameDetails.descriptionGame.text = selectedGame.description
            binding.includeGameDetails.imageView.load(selectedGame.image)
        }


        // pour le TP 7
        /*
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        val  adapter = GameAdapter(gamesList)
        binding.recyclerView.adapter = adapter
        //binding.recyclerView.layoutManager = LinearLayoutManager(this)
        */
    }
}