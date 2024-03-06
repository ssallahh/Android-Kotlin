package com.insa.gamelist.extensions

import android.widget.ImageView
import androidx.core.net.toUri
import com.bumptech.glide.Glide

fun ImageView.load(url: String){

    val uri = url.toUri().buildUpon().scheme("https").build()
    Glide.with(context).load(uri).into(this)
}

// TODO : here implement the loadConsoleLogo function