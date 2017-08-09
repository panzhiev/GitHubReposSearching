package com.example.tim.githubrepossearching.databases

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences

/**
 * Created by Tim on 09.08.2017.
 */

class SharedPrefsHelper {

    val PREFS_NAME = "com.example.panzhiev.a111minutessimplefilemanager"
    var prefs: SharedPreferences? = null

    fun putStringValue(context: Context, key: String, value: String) {
        prefs = context.getSharedPreferences(PREFS_NAME, MODE_PRIVATE)
        val editor = prefs!!.edit().putString(key, value)
        editor.apply()
    }

    fun getStringValue(context: Context, key: String): String {
        val prefs = context.getSharedPreferences(PREFS_NAME, MODE_PRIVATE)
        return prefs.getString(key, "")
    }
}
