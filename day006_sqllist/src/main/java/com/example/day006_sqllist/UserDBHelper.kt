package com.example.day006_sqllist

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class UserDBHelper(var context:Context,private var BD_VERSION:Int= CURRENT_VERSION):SQLiteOpenHelper(context,
    DB_NAME,null,BD_VERSION){

    companion object{
        var DB_NAME = "user.db" //数据库名
        var TABLE_NAME = "user_info" //表明
        var CURRENT_VERSION = 1  //当前按版本,如果如果表结构更改 版本号上

    }

    private var instabce:UserDBHelper? = null
    @Synchronized
    fun getInstance(ctx:Context,version:Int = 0):UserDBHelper{
        if (instabce == null){
            //如果没有传递版本号 就是用默认的最新版本
            instabce = if (version > 0){
                UserDBHelper(ctx.applicationContext)
            }else{
                UserDBHelper(ctx.applicationContext)
            }
        }
        return instabce!!
    }

    override fun onCreate(db: SQLiteDatabase?) {

        //如果存在 表 就删除
        val drop_sql = "DROP TABLE IF EXISTS $TABLE_NAME;"
        db?.execSQL(drop_sql)

        val create_sql = "CREATE TABLE IF NOT EXISTS $TABLE_NAME("+
                "_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,"+
                 "name VARCHAR NOT NULL,"+"age INTEGER NOT NULL"+");"

        db?.execSQL(create_sql)

    }


    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        if (newVersion > 1){
            var alter_sql = "ALTER TABLE $TABLE_NAME ADD COLUMN phone VARCHAR"
            db?.execSQL(alter_sql)

            alter_sql= "ALTER TABLE $TABLE_NAME ADD COLUMN password VARCHAR"
            db?.execSQL(alter_sql)
        }
    }

//    fun delete(condition:String):Int{
//        var count = 0
//
//        use {
//            count = delete(TABLE_NAME,condition,null)
//        }
//
//        return count
//    }

//    fun insert(info:UseInfo):Long{
//        val infoArray = mutableListOf(info)
//        return insert()
//    }

}