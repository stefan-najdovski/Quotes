package me.snajdovski.quotes.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

//database offline,backend, sqllite -cache (ex ROOM DB) layer of sqlite
//Data Access Object - Dao Interface all actions of the table of the database R/W queries.
//THIS ONE IS FAKE
//KISS

class FakeQuoteDao {
    //A fake database table
    private val quoteList = mutableListOf<Quote>() //list of quotes?

    //arch components observable
    private val quotes = MutableLiveData<List<Quote>>() //Quotes Live Data Observable?
    //2nd constructor init in kotlin ig

    init{
        quotes.value = quoteList // adding , getting quote
    }
    fun addQuote(quote: Quote){
        quoteList.add(quote) // add the quote
        quotes.value = quoteList //trigger observer
    }
    //ROOM SINGLETONS????? OBject in java way
    fun getQuotes() = quotes as LiveData<List<Quote>>


}