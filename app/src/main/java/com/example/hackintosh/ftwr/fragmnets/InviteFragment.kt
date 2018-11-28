package com.example.hackintosh.ftwr.fragmnets

import android.os.Bundle
import android.view.View
import com.example.hackintosh.ftwr.R
import android.text.Spannable
import android.text.SpannableString
import android.text.style.TypefaceSpan
import android.graphics.Typeface
import android.text.style.RelativeSizeSpan
import android.widget.Button
import android.widget.TextView


class InviteFragment: BaseFragment() {

    lateinit var inviteMessage: TextView
    lateinit var callButton: Button
    lateinit var acceptButton: Button
    lateinit var rejectButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        super.setContentLayout(R.layout.fragment_invite)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        inviteMessage = view.findViewById(R.id.inviteMessageTextView)
        callButton = view.findViewById(R.id.callButton)
        acceptButton = view.findViewById(R.id.acceptButton)
        rejectButton = view.findViewById(R.id.rejectButton)

        initDetails()
    }

    fun initDetails() {
        val actonia = Typeface.createFromAsset(activity?.assets, "fonts/actonia.ttf")
        val actoniaSpan = TypefaceSpan(actonia)

        val normalBefore = "Would you like to go to a "
        val custom = "rendezvous"
        val normalAfter = " with me, and spend a great evening together?"
        val finalString = normalBefore + custom + normalAfter
        val sb = SpannableString(finalString)
        sb.setSpan(actoniaSpan, finalString.indexOf(custom), finalString.indexOf(normalAfter), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        sb.setSpan(RelativeSizeSpan(1.5f), finalString.indexOf(custom), finalString.indexOf(normalAfter), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        inviteMessage.text = sb
    }

}