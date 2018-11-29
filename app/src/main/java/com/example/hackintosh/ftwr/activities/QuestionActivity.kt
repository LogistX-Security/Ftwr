package com.example.hackintosh.ftwr.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.view.ViewPager
import android.telephony.SmsManager
import android.widget.TextView
import com.example.hackintosh.ftwr.R
import com.example.hackintosh.ftwr.adapters.QuestionsViewPagerAdapter
import com.example.hackintosh.ftwr.fragmnets.QuizFragment
import com.example.hackintosh.ftwr.utils.Constants
import com.example.hackintosh.ftwr.utils.SharedPrefUtil

class QuestionActivity : AppCompatActivity() {

    lateinit var usernameTextView: TextView
    lateinit var viewPager: ViewPager

    lateinit var userName: String
    lateinit var adapter: QuestionsViewPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)

        usernameTextView = findViewById(R.id.userNameTextView)
        viewPager = findViewById(R.id.questionsViewPager)

        userName = intent.getStringExtra(Constants.CACHED_USERNAME_KEY)
        usernameTextView.text = getString(R.string.ftwr, userName)

        val isResponseProvided = SharedPrefUtil.getInstance(this).getBoolean(Constants.PROVIDE_RESPONSE_KEY, false)

        adapter = QuestionsViewPagerAdapter(supportFragmentManager, isResponseProvided)
        viewPager.adapter = adapter
    }

    fun onAccept() {
        sendAcceptSmsResponse()
        adapter.pagerFragments.removeAt(0)
        adapter.notifyDataSetChanged()
    }

    fun sendAcceptSmsResponse() {
        val smsManager = SmsManager.getDefault()
        smsManager.sendTextMessage("068591082", null, getSmsMessageText(), null, null)
    }

    private fun getSmsMessageText(): String {
        val quizFragment = adapter.pagerFragments[0] as QuizFragment

        return getString(R.string.sms_text, userName,
                         quizFragment.birthdayResponse.text.toString(),
                         quizFragment.hobbyResponse.text.toString(),
                         quizFragment.musicResponse.text.toString(),
                         quizFragment.dreamResponse.text.toString(),
                         quizFragment.generalResponse.text.toString())
    }
}
