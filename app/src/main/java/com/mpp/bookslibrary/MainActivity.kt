package com.mpp.bookslibrary

import BooksApi
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        search_btn.setOnClickListener {
            GlobalScope.launch {
                BooksApi().getBookByISBN(book_isbn.editText?.text.toString(), { volumeInfo ->
                    Log.d("Book Name:", volumeInfo.title)
                    book_info.text = "Title: ${volumeInfo.title}\nAuthors:${volumeInfo.authors}"
                }, { failure ->
                    Log.d("Error", failure?.message.toString())
                })
            }
        }
    }
}
