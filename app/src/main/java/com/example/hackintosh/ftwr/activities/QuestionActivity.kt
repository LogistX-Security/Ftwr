package com.example.hackintosh.ftwr.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.hackintosh.ftwr.R
import com.example.hackintosh.ftwr.utils.Constants

class QuestionActivity : AppCompatActivity() {

    lateinit var usernameTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)

        usernameTextView = findViewById(R.id.userNameTextView)

        val userName = intent.getStringExtra(Constants.CACHED_USERNAME_KEY)
        usernameTextView.text = getString(R.string.ftwr, userName)
    }
}
