package com.example.tradeapp



import android.content.Context
import android.content.SharedPreferences

class SessionManager(context: Context) {

    private val prefs: SharedPreferences =
        context.getSharedPreferences("user_session", Context.MODE_PRIVATE)

    companion object {
        private const val KEY_IS_LOGGED_IN = "is_logged_in"
        private const val KEY_USERNAME = "username"
        private const val KEY_TOKEN = "token"
        private const val KEY_PASSWORD = "password"
        private const val KEY_IS_UNLOCKED = "is_unlocked"
        private const val KEY_LAST_UNLOCK_TIME = "last_unlock_time"
    }

    // ✅ Save login info
    fun saveLogin(username: String, token: String, password: String) {
        prefs.edit().apply {
            putBoolean(KEY_IS_LOGGED_IN, true)
            putString(KEY_USERNAME, username)
            putString(KEY_TOKEN, token)
            putString(KEY_PASSWORD, password)
            putBoolean(KEY_IS_UNLOCKED, false)
            putLong(KEY_LAST_UNLOCK_TIME, 0L)
            apply()
        }
    }
    fun isUnlocked(): Boolean {
        return prefs.getBoolean("unlocked", false)
    }

    fun setUnlocked(unlocked: Boolean) {
        prefs.edit().putBoolean("unlocked", unlocked).apply()
    }

    // ✅ Check if logged in
    fun isLoggedIn(): Boolean = prefs.getBoolean(KEY_IS_LOGGED_IN, false)

    // ✅ Unlock state

    fun setDialogShown(shown: Boolean) {
        prefs.edit().putBoolean("dialog_shown", shown).apply()
    }

    fun isDialogShown(): Boolean = prefs.getBoolean("dialog_shown", false)




    fun getPassword(): String? = prefs.getString(KEY_PASSWORD, null)

    fun logout() {
        prefs.edit().clear().apply()
    }
}

/*
import android.content.Context
import android.content.SharedPreferences

class SessionManager(context: Context) {

    private val prefs: SharedPreferences =
        context.getSharedPreferences("user_session", Context.MODE_PRIVATE)

    companion object {
        private const val KEY_IS_LOGGED_IN = "is_logged_in"
        private const val KEY_USERNAME = "username"
        private const val KEY_TOKEN = "token"
        private const val KEY_PASSWORD = "password"   // ✅ new
        private const val KEY_FIRST_LOGIN = "first_login" // ✅ new
        private const val KEY_IS_UNLOCKED = "is_unlocked"  // ✅ add this

    }

    // ✅ Save login info
    /*
    fun saveLogin(username: String, token: String) {
        prefs.edit().apply {
            putBoolean(KEY_IS_LOGGED_IN, true)
            putString(KEY_USERNAME, username)
            putString(KEY_TOKEN, token)
            apply()
        }
    }

     */
    // ✅ Save login info new one
    fun saveLogin(username: String, token: String, password: String) {
        prefs.edit().apply {
            putBoolean(KEY_IS_LOGGED_IN, true)
            putString(KEY_USERNAME, username)
            putString(KEY_TOKEN, token)
            putString(KEY_PASSWORD, password)   // ✅ save password
            putBoolean(KEY_FIRST_LOGIN, true)  // ✅ mark first login
            putBoolean(KEY_IS_UNLOCKED, false) // reset unlock on login
            apply()
        }
    }



    // ✅ Unlock state

    fun setUnlocked(unlocked: Boolean) {
        prefs.edit().putBoolean(KEY_IS_UNLOCKED, unlocked).apply()
    }

    fun isUnlocked(): Boolean {
        return prefs.getBoolean(KEY_IS_UNLOCKED, false)
    }
/*
    fun clearUnlocked() {
        prefs.edit().putBoolean(KEY_IS_UNLOCKED, false).apply()
    }

 */



    // ✅ Set unlock state

    fun isFirstLogin(): Boolean = prefs.getBoolean(KEY_FIRST_LOGIN, false)

    fun clearFirstLogin() {
        prefs.edit().putBoolean(KEY_FIRST_LOGIN, false).apply()
    }

    // ✅ Check if logged in
    fun isLoggedIn(): Boolean {
        return prefs.getBoolean(KEY_IS_LOGGED_IN, false)
    }

    // ✅ Get username
    fun getUsername(): String? {
        return prefs.getString(KEY_USERNAME, null)
    }

    // ✅ Get token (if API provides)
    fun getToken(): String? {
        return prefs.getString(KEY_TOKEN, null)
    }

    // ✅ Get password
    fun getPassword(): String? = prefs.getString(KEY_PASSWORD, null)
    // ✅ Logout user (clear session)
    fun logout() {
        prefs.edit().clear().apply()
    }
}


 */