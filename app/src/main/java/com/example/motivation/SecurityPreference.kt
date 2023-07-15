package com.example.motivation

import android.content.Context
import android.content.SharedPreferences

class SecurityPreference(context: Context) {
    private val security: SharedPreferences =
        context.getSharedPreferences("Motivation", Context.MODE_PRIVATE)

    fun storeString(key: String, name: String) {
        security.edit().putString(key, name).apply()
    }

    fun getString(key: String): String {
        return security.getString(key, "") ?: ""
    }
}