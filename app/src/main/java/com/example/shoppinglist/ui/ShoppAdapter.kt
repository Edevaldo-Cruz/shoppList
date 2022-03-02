package com.example.shoppinglist.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.shoppinglist.R
import com.example.shoppinglist.model.Shopp

class ShoppAdapter: RecyclerView.Adapter<ShoppViewHolder>() {

    private var items = listOf<Shopp>()

    fun updateItems(newItems: List<Shopp>) {
        items = newItems

        // Avisa a UI que houve mudança
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_shopp, parent, false)

        return ShoppViewHolder(view)
    }

    // Retorna quantos itens tem na lista
    override fun getItemCount(): Int = items.size


    override fun onBindViewHolder(holder: ShoppViewHolder, position: Int) {
        holder.bind(items[position])
    }

}

