package com.example.hackintosh.ftwr.fragmnets

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import com.example.hackintosh.ftwr.R
import com.example.hackintosh.ftwr.activities.QuestionActivity
import com.example.hackintosh.ftwr.utils.Constants
import com.example.hackintosh.ftwr.utils.SharedPrefUtil


class QuizFragment: BaseFragment() {

    lateinit var followButton: Button
    lateinit var birthdayResponse: EditText
    lateinit var hobbyResponse: EditText
    lateinit var musicResponse: EditText
    lateinit var dreamResponse: EditText
    lateinit var generalResponse: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        super.setContentLayout(R.layout.fragment_quiz)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        followButton = view.findViewById(R.id.followButton)
        birthdayResponse = view.findViewById(R.id.birthdayResponseEditText)
        hobbyResponse = view.findViewById(R.id.hobbyResponseEditText)
        musicResponse = view.findViewById(R.id.musicResponseEditText)
        dreamResponse = view.findViewById(R.id.dreamResponseEditText)
        generalResponse = view.findViewById(R.id.generalResponseEditText)

        followButton.setOnClickListener {moveToInvitePage()}
    }

    private fun moveToInvitePage() {
        (activity as QuestionActivity).viewPager.currentItem = 1
    }

    fun persistToMemoryResponses() {
        SharedPrefUtil.getInstance(activity!!).putString(Constants.CACHED_BIRTHDAT_KEY, birthdayResponse.text.toString())
        SharedPrefUtil.getInstance(activity!!).putString(Constants.CACHED_HOBBY_KEY, hobbyResponse.text.toString())
        SharedPrefUtil.getInstance(activity!!).putString(Constants.CACHED_MUSIC_KEY, musicResponse.text.toString())
        SharedPrefUtil.getInstance(activity!!).putString(Constants.CACHED_DREAM_KEY, dreamResponse.text.toString())
        SharedPrefUtil.getInstance(activity!!).putString(Constants.CACHED_GENERAL_KEY, generalResponse.text.toString())
    }

}