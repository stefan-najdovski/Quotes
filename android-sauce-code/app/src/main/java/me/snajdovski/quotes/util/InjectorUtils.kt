package me.snajdovski.quotes.util

import me.snajdovski.quotes.data.FakeDatabase
import me.snajdovski.quotes.data.Quote
import me.snajdovski.quotes.data.QuoteRepository
import me.snajdovski.quotes.ui.quotes.QuotesViewModel
import me.snajdovski.quotes.ui.quotes.QuotesViewModelFactory

object InjectorUtils {

    fun provideQuotesViewModelDirectory(): QuotesViewModelFactory{
        val quoteRepository = QuoteRepository.getInstance(FakeDatabase.getInstance().quoteDao) //change implementation this single fun
        return QuotesViewModelFactory(quoteRepository)
    }
}