package com.example.shoppinglist.ui

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.shoppinglist.R
import com.example.shoppinglist.model.Shopp

class ShoppViewHolder(view: View): RecyclerView.ViewHolder(view) {

    private val product = itemView.findViewById<TextView>(R.id.product)
    private val description = itemView.findViewById<TextView>(R.id.description)

    fun bind(item: Shopp) {
        product.text = item.product
        description.text = item.description
    }

    // inserir click do menu aqui!!!

}