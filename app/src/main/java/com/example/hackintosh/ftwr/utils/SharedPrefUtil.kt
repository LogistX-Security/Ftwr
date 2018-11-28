package com.example.hackintosh.ftwr.utils

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences

class SharedPrefUtil private constructor(protected var context: Context) {

    private val preferences: SharedPreferences
    private val editor: SharedPreferences.Editor

    init {
        preferences = context.getSharedPreferences(APP, Activity.MODE_PRIVATE)
        editor = preferences.edit()
    }

    fun putString(key: String, value: String) {
        editor.putString(key, value)
        editor.commit()
    }

    fun putBoolean(key: String, value: Boolean) {
        editor.putBoolean(key, value)
        editor.commit()
    }

    fun remove(key: String) {
        editor.remove(key)
        editor.commit()
    }

    fun getString(key: String, defaultValue: String): String? {
        return preferences.getString(key, defaultValue)
    }

    fun getBoolean(key: String, defaultValue: Boolean): Boolean {
        return preferences.getBoolean(key, defaultValue)
    }

    fun clearSharedPreferences(removeElements: Array<String>) {
        for (element in removeElements) {
            sharedPrefUtil!!.remove(element)
        }
    }

    companion object {

        private val APP = "com.example.hackintosh.ftwr"

        private var sharedPrefUtil: SharedPrefUtil? = null

        @Synchronized
        fun getInstance(context: Context): SharedPrefUtil {

            if (sharedPrefUtil == null) {
                sharedPrefUtil = SharedPrefUtil(context.applicationContext)
            }
            return sharedPrefUtil!!
        }
    }
}