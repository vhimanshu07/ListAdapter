package com.example.listadapter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val recyclerView: RecyclerView = findViewById(R.id.listRecyclerView)
        val adapter = ItemAdapter()

        val listOfItem = mutableListOf<Item>()
        for (i in 1..10) {
            listOfItem.add(Item(i, "Content $i", "Trial Description $i"))
        }
        Log.e("list", "$listOfItem")
        adapter.submitList(listOfItem)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
        /**
         *
         * Now let's check the usage of diffutils
         *
         *
         */
        Handler(Looper.getMainLooper()).postDelayed({
            for (i in 1..10) {
                if (i % 2 == 0) {
                    listOfItem.add(Item(i, "Content changed $i", "Trial Description changed $i"))
                }
//                else
//                {
//                    listOfItem.add(Item(i,"Content $i","Trial Description $i"))
//                }

            }
            Log.e("list", "$listOfItem")
            adapter.submitList(listOfItem)
        }, 4000)


    }
}