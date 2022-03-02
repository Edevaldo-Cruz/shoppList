package com.example.shoppinglist.ui

import android.app.Activity
import android.content.Intent
import com.example.shoppinglist.R
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isEmpty
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.shoppinglist.databinding.ActivityAddShoppBinding
import com.example.shoppinglist.databinding.ActivityMainBinding
import com.example.shoppinglist.datasource.ShoppDataSource
import com.example.shoppinglist.datasource.shoppselect
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var recyclerView: RecyclerView
    private var shoppAdapter = ShoppAdapter()

    private lateinit var dataSource: ShoppDataSource


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        recyclerView = findViewById(R.id.list)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = shoppAdapter

        dataSource = ShoppDataSource(this)



        btn_add.setOnClickListener {
            insertListeners()
        }


    }

    private fun insertListeners() {
        val about = Intent( this,
            AddShoppActivity::class.java)
        startActivity(about)

    }

    override fun onResume() {
        super.onResume()

        val shoop = dataSource.shoppselect()

        shoppAdapter.updateItems(shoop)
    }


}






//    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
//        menuInflater.inflate(R.menu.main_menu, menu)
//        return true
//    }
//
//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        return when(item.itemId) {
//            R.id.menu_new -> {
//                val intent = Intent(this, AddShoppActivity::class.java)
//                startActivity(intent)
//                true
//            }
//            else -> {
//                false
//            }
//        }





