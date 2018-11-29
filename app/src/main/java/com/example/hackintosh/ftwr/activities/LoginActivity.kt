package com.example.hackintosh.ftwr.activities

import android.Manifest
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.widget.Button
import android.widget.EditText
import com.example.hackintosh.ftwr.R
import com.example.hackintosh.ftwr.utils.Constants
import com.example.hackintosh.ftwr.utils.SharedPrefUtil

class LoginActivity : AppCompatActivity() {

    lateinit var loginEditText: EditText
    lateinit var loginButton: Button

    val PERMISSIONS = arrayOf(Manifest.permission.CALL_PHONE,
                              Manifest.permission.SEND_SMS)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        requestPermissions(PERMISSIONS)

        loginEditText = findViewById(R.id.loginEditText)
        loginButton = findViewById(R.id.loginButton)

        loginButton.setOnClickListener { login(loginEditText.text.toString()) }

        checkCachedUser()
    }

    fun checkCachedUser() {
        var cachedUser = SharedPrefUtil.getInstance(this)
                                       .getString(Constants.CACHED_USERNAME_KEY, "")
        login(cachedUser ?: "")
    }

    private fun login(userName: String) {
        if(!userName.isEmpty()) {
            SharedPrefUtil.getInstance(this)
                          .putString(Constants.CACHED_USERNAME_KEY, userName)
            onLogin(userName)
        }
    }

    fun onLogin(userName: String) {
        val intent = Intent(this, QuestionActivity::class.java)
        intent.putExtra(Constants.CACHED_USERNAME_KEY, userName)
        startActivity(intent)
    }

    private fun requestPermissions(permissions: Array<String>) {
        ActivityCompat.requestPermissions(this,
                                            permissions,
                                            1111)
    }
}
