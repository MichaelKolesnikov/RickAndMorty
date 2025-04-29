package ru.mephi.rickandmorty

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import ru.mephi.rickandmorty.presentation.ui.CharacterActivity

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            setContent {
                startActivity(Intent(this@MainActivity, CharacterActivity::class.java))
                finish()
            }
        }
    }
}