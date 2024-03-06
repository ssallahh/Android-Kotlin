package com.insa.gamelist

import android.content.SharedPreferences.Editor
import java.lang.invoke.TypeDescriptor
import java.sql.Timestamp

class Game (var id: Int,
            var title:String,
            var type: String,
            var console: List<String>,
            var editor: String,
            var developer: String,
            var timestamp: Long,
            var image: String,
            var description: String) {

}