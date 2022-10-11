package me.snajdovski.quotes.ui.quotes

import android.view.View
import androidx.lifecycle.ViewModel
import me.snajdovski.quotes.data.Quote
import me.snajdovski.quotes.data.QuoteRepository

class QuotesViewModel(private val quoteRepository: QuoteRepository) : ViewModel() {

    fun getQuotes() = quoteRepository.getQuotes()

    fun addQuote(quote: Quote) = quoteRepository.addQuote(quote)


}