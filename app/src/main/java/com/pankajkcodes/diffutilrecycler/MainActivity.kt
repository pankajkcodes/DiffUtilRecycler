package com.pankajkcodes.diffutilrecycler

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val adapter = MyItemAdapter()

        val item1 = ModelItem(1,"item1")
        val item2 = ModelItem(1,"item2")
        val item3 = ModelItem(1,"item3")


        adapter.submitList(listOf( item1,item2,item3))


        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)

        recyclerView.adapter = adapter


        Handler(Looper.getMainLooper()).postDelayed(Runnable {

            val item3 = ModelItem(1,"item3")
            val item4 = ModelItem(1,"item4")
            val item5 = ModelItem(1,"item5")
            Toast.makeText(this,"ListUpdated",Toast.LENGTH_LONG).show()
            adapter.submitList(listOf( item3,item4,item5))
        },5000)
    }
}