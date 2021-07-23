package com.example.day006_sqllist


import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class MySqlList (var context:Context,private var version:Int,private var name:String):SQLiteOpenHelper(context,name,null,version){



        override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

        }

        override fun onCreate(db: SQLiteDatabase?) {

        }


}