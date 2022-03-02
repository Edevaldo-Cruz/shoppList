package com.example.shoppinglist.datasource

import android.annotation.SuppressLint
import android.content.ContentValues
import com.example.shoppinglist.model.Shopp

fun ShoppDataSource.insertList(item: Shopp) : Long {

    //writableDatabase => escrever ou deletar algo no banco
    //readableDatabase => selecionar algo no banco

    val idShopp = writableDatabase.insert("TB_SHOPPING", null, ContentValues().apply {
       /*
            *****put******
        1º argumento key é o campo do banco de dados
        2º argumento é o local de onde vai sair a informação
       */
        put("PRODUCT", item.product)
        put("DESCRIPTION", item.description)
    })

    return idShopp
}

@SuppressLint("Range")
fun ShoppDataSource.shoppselect(): List<Shopp> {
    val sql = "SELECT * FROM TB_SHOPPING"

    val cursor = readableDatabase.rawQuery(sql, null)
    val shoppList = mutableListOf<Shopp>()

    if (cursor.count > 0) {
        while (cursor.moveToNext()) {
            val shopp = Shopp(
                id = cursor.getInt(cursor.getColumnIndex("ID")),
                product = cursor.getString(cursor.getColumnIndex("PRODUCT")),
                description = cursor.getString(cursor.getColumnIndex("DESCRIPTION"))
            )
            shoppList.add(shopp)
        }
        cursor.close()
    }
    return shoppList
}