package com.example.shoppinglist.datasource

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import androidx.core.content.ContextCompat
import com.example.shoppinglist.model.Shopp

class ShoppDataSource(context: Context): SQLiteOpenHelper(context, "TB_SHOPPING.db", null, 1) {

    //Criando bando de dado
    override fun onCreate(db: SQLiteDatabase?) {

       val sql = """
           CREATE TABLE TB_SHOPPING(
           ID INTEGER PRIMARY KEY AUTOINCREMENT,
           PRODUCT TEXT,
           DESCRIPTION TEXT
           );
       """.trimIndent()

        db?.execSQL(sql)

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS TB_SHOPPING")
        onCreate(db)
    }



}



