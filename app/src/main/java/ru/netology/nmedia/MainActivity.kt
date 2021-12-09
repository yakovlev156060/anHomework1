package ru.netology.nmedia

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        println("zzz+ ${R.string.str_nmedia}")
        println("zzz+ ${getString(R.string.str_nmedia)}")
        Log.d("rntngranaenafe", "${R.string.str_nmedia}")
        setContentView(R.layout.activity_main)
    }
}