package com.insa.gamelist.utils

import android.content.Context
import com.insa.gamelist.Game
import com.insa.gamelist.R
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader

object DataManager {
    // TODO : Uncomment before implementing the readFile method

    // TODO : add the attribute games
    // Q5
    lateinit var games:List<Game>
    fun readFile(context : Context){


        val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
        val type = Types.newParameterizedType(List::class.java, Game::class.java)
        val jsonAdapter : JsonAdapter<List<Game>> = moshi.adapter(type)

        try {
            val inputStream = context.resources.openRawResource(R.raw.gamelist)
            val inputStreamReader = InputStreamReader(inputStream)
            val bufferedReader = BufferedReader(inputStreamReader)

            var line = bufferedReader.readLine()
            val stringBuilder = StringBuilder()

            while (line != null){
                stringBuilder.append(line)
                line = bufferedReader.readLine()
            }
            val jsonString = stringBuilder.toString()
            // TODO : initialize games from jsonString
            // Q6
            games = jsonAdapter.fromJson(jsonString) ?: emptyList()

        }
        catch (e : IOException){
            e.printStackTrace()
        }
    }

    //TODO : function getGame(pos:Int)
}