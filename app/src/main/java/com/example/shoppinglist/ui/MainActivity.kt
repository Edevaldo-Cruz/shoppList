package com.example.shoppinglist.ui

import android.content.Intent
import com.example.shoppinglist.R
import android.os.Bundle
import android.view.*
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.motion.widget.Key.VISIBILITY
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.shoppinglist.databinding.ActivityMainBinding
import com.example.shoppinglist.datasource.ShoppDataSource
import com.example.shoppinglist.datasource.shoppSelect
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var recyclerView: RecyclerView
    private var shoppAdapter = ShoppAdapter()
    private lateinit var dataSource: ShoppDataSource
    private lateinit var includeEmpty: ConstraintLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        recyclerView = findViewById(R.id.list)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = shoppAdapter
        dataSource = ShoppDataSource(this)
        dataSource.COLUMNS_ID
        btn_add.setOnClickListener {
            insertListeners()
        }

        includeEmpty = findViewById(R.id.include_empty)

        if (dataSource.COLUMNS_ID != null) {
            includeEmpty.visibility = View.GONE
        } else {
            includeEmpty.visibility = View.VISIBLE
        }


    }

    private fun insertListeners() {
        val about = Intent( this,
            AddShoppActivity::class.java)
        startActivity(about)
    }

    override fun onResume() {
        super.onResume()
        val shoop = dataSource.shoppSelect().map {
            it.copy(onClick = ::openDetail)
        }
        shoppAdapter.updateItems(shoop)
    }

    private fun openDetail(idShopp: Int?) {
        val intent = Intent(this, AddShoppActivity::class.java)
        intent.putExtra("ID_SHOPP", idShopp)
        startActivity(intent)
    }


}












