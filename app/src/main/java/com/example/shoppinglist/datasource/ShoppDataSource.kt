package com.example.shoppinglist.datasource

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import androidx.core.content.ContextCompat
import com.example.shoppinglist.model.Shopp

class ShoppDataSource(context: Context): SQLiteOpenHelper(context, BANK_NAME, null, CURRENT_VERSION) {

    //Criando bando de dado

    companion object {
        val BANK_NAME = "TB_SHOPPING.db"
        val CURRENT_VERSION = 1
    }
    val TABLE_NAME = "TB_SHOPPING"
    val COLUMNS_ID = "ID"
    val COLUMNS_PRODUCT = "PRODUCT"
    val COLUMNS_DESCRIPTION = "DESCRIPTION"
    val COLUMNS_CONCLUDED = "CONCLUDED"
    val DROP_TABLE = "DROP TABLE IF EXISTS $TABLE_NAME"
    val CREATE_TABLE =
        "CREATE TABLE $TABLE_NAME (" +
                "$COLUMNS_ID INTEGER," +
                "$COLUMNS_PRODUCT TEXT," +
                "$COLUMNS_DESCRIPTION TEXT," +
                "$COLUMNS_CONCLUDED BIT," +
                "" +
                "PRIMARY KEY($COLUMNS_ID AUTOINCREMENT)" +
                ")"

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(CREATE_TABLE)
    /*
     Outra forma de criar banco de dados
       val sql = """
           CREATE TABLE TB_SHOPPING(
           ID INTEGER PRIMARY KEY AUTOINCREMENT,
           PRODUCT TEXT,
           DESCRIPTION TEXT
           );
       """.trimIndent()
        db?.execSQL(sql)
     */
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL(DROP_TABLE)
        onCreate(db)
    }



}



