package com.example.hackintosh.ftwr.fragmnets

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.example.hackintosh.ftwr.R
import android.text.Spannable
import android.text.SpannableString
import android.text.style.TypefaceSpan
import android.graphics.Typeface
import android.net.Uri
import android.support.constraint.ConstraintLayout
import android.text.style.RelativeSizeSpan
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.example.hackintosh.ftwr.activities.QuestionActivity
import com.example.hackintosh.ftwr.utils.Constants
import com.example.hackintosh.ftwr.utils.SharedPrefUtil


class InviteFragment: BaseFragment() {

    lateinit var inviteMessage: TextView
    lateinit var callButton: Button
    lateinit var acceptButton: Button
    lateinit var rejectButton: Button
    lateinit var rabbitImage: ImageView
    lateinit var decisionButtonLayout: ConstraintLayout

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
        rabbitImage = view.findViewById(R.id.rabbitImage)
        decisionButtonLayout = view.findViewById(R.id.buttonDecisionLayout)

        acceptButton.setOnClickListener { onAccept() }
        callButton.setOnClickListener { performCall() }
        rejectButton.setOnClickListener { performCall() }

        val isResponseProvided = SharedPrefUtil.getInstance(activity!!).getBoolean(Constants.PROVIDE_RESPONSE_KEY, false)

        if (isResponseProvided) {
            hideDecisionLayout()
        } else {
            initDetails()
        }
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

    private fun hideDecisionLayout() {
        decisionButtonLayout.visibility = View.INVISIBLE
        inviteMessage.visibility = View.INVISIBLE
        rabbitImage.visibility = View.VISIBLE
    }

    private fun onAccept() {
        hideDecisionLayout()
        (activity as QuestionActivity).onAccept()
        SharedPrefUtil.getInstance(activity!!).putBoolean(Constants.PROVIDE_RESPONSE_KEY, true)
    }

    fun performCall() {
        val intent = Intent(Intent.ACTION_CALL)
        intent.data = Uri.parse("tel:068591082")
        startActivity(intent)
    }

}