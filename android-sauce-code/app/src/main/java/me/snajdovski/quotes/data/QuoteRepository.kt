package me.snajdovski.quotes.data
//DB viewmodel
class QuoteRepository private constructor(private val quoteDao: FakeQuoteDao){

    fun addQuote(quote: Quote){
        quoteDao.addQuote(quote)
    }

    fun getQuotes() = quoteDao.getQuotes() //return livedata

    companion object{
        @Volatile private var instance: QuoteRepository? = null // writes visible to other threads
        fun getInstance(quoteDao: FakeQuoteDao) =
            instance ?: synchronized(this){
            instance ?: QuoteRepository(quoteDao).also {
                instance = it
            }
        }
    }
}