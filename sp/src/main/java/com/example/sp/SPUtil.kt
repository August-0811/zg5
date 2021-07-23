package com.example.sp

import android.content.Context
import android.content.SharedPreferences
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

class SPUtil<T>(val name: String, val default: T) : ReadWriteProperty<Any?, T> {

    //通过属性代理初始化共享数据
    val prefs: SharedPreferences by lazy {
        App.context.getSharedPreferences("default", Context.MODE_PRIVATE)
    }


    //接管属性获取行为
    override fun getValue(thisRef: Any?, property: KProperty<*>): T {
        return findPreference(name, default)
    }


    //接管属性值的修改行为
    override fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
        putPreference(name, value)
    }

    private fun putPreference(name: String = this.name, value: T = this.default) =
        with(prefs.edit()) {
            when (value) {
                is Int -> putInt(name, value)
                is Float -> putFloat(name, value)
                is Long -> putLong(name, value)
                is Boolean -> putBoolean(name, value)
                is String -> putString(name, value)
                else -> throw IllegalArgumentException("SharedPreference can't be save this type")
            }.apply()
        }

    private fun findPreference(name: String=this.name, default: T=this.default): T =
        with(prefs) {
        var res = when (default) {
            is Long -> getLong(name, default)
            is Int -> getInt(name, default)
            is Boolean -> getBoolean(name, default)
            is Float -> getFloat(name, default)
            is String -> getString(name, default)

            else -> throw IllegalArgumentException("SharedPreference can't be get this type")
        }
        return res as T
    }


    object SPDeleg {
        fun <T> preference(name: String, default: T) =
            SPUtil(name, default).putPreference()

        fun <T> findPreference(name: String, default: T) = SPUtil(name, default).findPreference()
    }

}