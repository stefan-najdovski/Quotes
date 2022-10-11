package me.snajdovski.quotes.data

class FakeDatabase private constructor() {

    var quoteDao = FakeQuoteDao()
    private set

    companion object{
        @Volatile private var instance: FakeDatabase? = null // writes visible to other threads
        fun getInstance() = instance ?: synchronized(this){
            instance ?: FakeDatabase().also {
                instance = it
            }
        }
    }



}