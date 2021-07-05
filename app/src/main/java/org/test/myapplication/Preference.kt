package org.test.myapplication

import android.content.Context
import android.content.SharedPreferences
import android.text.TextUtils
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Preferences @Inject constructor(@ApplicationContext applicationContext: Context) {

    private val preferenceFile = "healthsignzDoctor"

    private var mSharedPreferences: SharedPreferences? = null

    init {
        mSharedPreferences =
            applicationContext.getSharedPreferences(preferenceFile, Context.MODE_PRIVATE)
    }

    fun getPreference(): SharedPreferences? {
        return mSharedPreferences
    }

    fun <T : Any> get(key: String, default: T): T? {
        val type = default::class.java
        val preferences = mSharedPreferences
        if (preferences != null) {
            return when (default) {
                is String -> type.cast(preferences.getString(key, default))
                is Long -> type.cast(preferences.getLong(key, default))
                is Int -> type.cast(preferences.getInt(key, default))
                is Float -> type.cast(preferences.getFloat(key, default))
                is Boolean -> type.cast(preferences.getBoolean(key, default))
                else -> default
            }
        }
        return default
    }

    fun <T : Any> set(key: String, value: T?): Boolean {
        val preferences = mSharedPreferences
        if (preferences != null && !TextUtils.isEmpty(key)) {
            val editor = preferences.edit()
            when (value) {
                is String -> editor.putString(key, value)
                is Long -> editor.putLong(key, value)
                is Int -> editor.putInt(key, value)
                is Float -> editor.putFloat(key, value)
                is Boolean -> editor.putBoolean(key, value)
                else -> return false
            }
            return editor.commit()
        }
        return false
    }

    fun getStringPreference(key: String, defaultValue: String = ""): String? =
        get(key, defaultValue)

    fun getLongPreference(key: String, defaultValue: Long = 0L): Long? = get(key, defaultValue)
    fun getIntegerPreference(key: String, defaultValue: Int = 0): Int? = get(key, defaultValue)
    fun getBooleanPreference(key: String, defaultValue: Boolean = false): Boolean? = get(key, defaultValue)

    fun setStringPreference(key: String, value: String?): Boolean = set(key, value)
    fun setLongPreference(key: String, value: Long?): Boolean = set(key, value)
    fun setIntegerPreference(key: String, value: Int?): Boolean = set(key, value)
    fun setBooleanPreference(key: String, value: Boolean?): Boolean = set(key, value)


}
