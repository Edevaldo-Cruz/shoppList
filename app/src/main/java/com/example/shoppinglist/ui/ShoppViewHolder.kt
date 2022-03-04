package com.example.shoppinglist.ui

import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.shoppinglist.R
import com.example.shoppinglist.model.Shopp

class ShoppViewHolder(view: View): RecyclerView.ViewHolder(view) {


    private val product = itemView.findViewById<TextView>(R.id.card_title)
    private val description = itemView.findViewById<TextView>(R.id.card_description)

    fun bind(item: Shopp) {
        product.text = item.product
        description.text = item.description

        itemView.setOnClickListener {
            item.onClick?.invoke(item.id)
        }
    }




}