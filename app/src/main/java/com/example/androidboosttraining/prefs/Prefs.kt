package com.example.androidboosttraining.prefs

import android.content.Context

class Prefs(val context: Context) {
    val STATUS_FAV = "status"
    val storage = context.getSharedPreferences(STATUS_FAV, 0)
    fun setFav(status: Boolean) {
        storage.edit().putBoolean(STATUS_FAV, status).apply()
    }

    fun getStatus(): Boolean {
        return storage.getBoolean(STATUS_FAV, false)
    }
}