package com.example.todoapp.utils

import android.content.Context
import android.content.SharedPreferences
import com.example.todoapp.models.MyTodo
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

object MySharedPreference {
    private const val NAME = "catch_file_name"
    private const val MODE = Context.MODE_PRIVATE

    private lateinit var preferences: SharedPreferences

    fun init(context: Context) {
        preferences = context.getSharedPreferences(NAME, MODE)
    }

    private inline fun SharedPreferences.edit(operation: (SharedPreferences.Editor) -> Unit) {
        val editor = edit()
        operation(editor)
        editor.apply()
    }

    var list: ArrayList<MyTodo>
        get() = gsonToList(preferences.getString("keyList", "[]")!!)
        set(value) = preferences.edit {
            it.putString("keyList", listToGson(value))
        }

    private fun gsonToList(gsonString: String): ArrayList<MyTodo> {
        val list = ArrayList<MyTodo>()
        val type = object : TypeToken<ArrayList<MyTodo>>() {}.type
        list.addAll(Gson().fromJson(gsonString, type))
        return list
    }

    private fun listToGson(list: ArrayList<MyTodo>): String {
        return Gson().toJson(list)
    }
}