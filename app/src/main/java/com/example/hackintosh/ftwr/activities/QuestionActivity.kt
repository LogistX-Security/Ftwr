package com.example.hackintosh.ftwr.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.view.ViewPager
import android.widget.TextView
import com.example.hackintosh.ftwr.R
import com.example.hackintosh.ftwr.adapters.QuestionsViewPagerAdapter
import com.example.hackintosh.ftwr.utils.Constants

class QuestionActivity : AppCompatActivity() {

    lateinit var usernameTextView: TextView
    lateinit var viewPager: ViewPager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)

        usernameTextView = findViewById(R.id.userNameTextView)
        viewPager = findViewById(R.id.questionsViewPager)

        val userName = intent.getStringExtra(Constants.CACHED_USERNAME_KEY)
        usernameTextView.text = getString(R.string.ftwr, userName)

        val adapter = QuestionsViewPagerAdapter(supportFragmentManager)
        viewPager.adapter = adapter
    }
}
