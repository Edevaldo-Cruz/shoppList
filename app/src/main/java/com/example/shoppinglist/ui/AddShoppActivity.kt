package com.example.shoppinglist.ui


import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.shoppinglist.R
import com.example.shoppinglist.datasource.ShoppDataSource
import com.example.shoppinglist.datasource.insertList
import com.example.shoppinglist.model.Shopp


class AddShoppActivity : AppCompatActivity() {

    private lateinit var product: EditText
    private lateinit var  description: EditText
    private lateinit var  btn_new: Button

    private lateinit var dataSource: ShoppDataSource


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_shopp)

        // Referenciando as variaveis com o layout
        product = findViewById(R.id.product)
        description = findViewById(R.id.description)
        btn_new = findViewById(R.id.btn_new)

        dataSource = ShoppDataSource(this)

        btn_new.setOnClickListener {
            saveList()
        }
    }

    private fun saveList() {

        val shopp = Shopp(
            product = product.text.toString(),
            description = description.text.toString()
        )

        val idShopp = dataSource.insertList(shopp)

        if(idShopp == -1L) {
            Toast.makeText(this, "Erro ao inserir", Toast.LENGTH_SHORT).show()
        }else{
            Toast.makeText(this, "Produto inserido com sucesso id: $idShopp", Toast.LENGTH_SHORT).show()
        }

        //Ver a possibilidade de fazer validaç

    }
}



