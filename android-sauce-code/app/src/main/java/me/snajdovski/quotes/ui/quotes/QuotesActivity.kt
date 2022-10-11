package me.snajdovski.quotes.ui.quotes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import me.snajdovski.quotes.R

//View

class QuotesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quote)
    }
}