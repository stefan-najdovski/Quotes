package me.snajdovski.quotes.ui.quotes

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import me.snajdovski.quotes.R
import me.snajdovski.quotes.data.Quote
import me.snajdovski.quotes.util.InjectorUtils

//View

class QuotesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quote)

        initUI()
    }
    private fun initUI(){
        val textViewQuotes = findViewById<TextView>(R.id.textView_quotes)
        val buttonAddQuote = findViewById<Button>(R.id.button_add_quote)
        val editTextQuote = findViewById<EditText>(R.id.editText_quote)
        val editTextAuthor = findViewById<EditText>(R.id.editText_author)


        val factory = InjectorUtils.provideQuotesViewModelDirectory()
        val viewModel = ViewModelProvider(this, factory)[QuotesViewModel::class.java]
        viewModel.getQuotes().observe(this) { quotes ->
            val stringBuilder = StringBuilder()
            quotes.forEach { quote ->
                stringBuilder.append("$quote\n\n")
            }
            textViewQuotes.text = stringBuilder.toString()
        }

        buttonAddQuote.setOnClickListener{
            val quote = Quote(editTextQuote.text.toString(),editTextAuthor.text.toString())
            viewModel.addQuote(quote)
            editTextQuote.setText("")
            editTextAuthor.setText("")

        }
    }
}