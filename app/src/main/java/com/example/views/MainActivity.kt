package com.example.views

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val list: MutableList<WaData> = ArrayList()
        list.add(
            WaData(
                R.drawable.ic_launcher_foreground,
                "Android",
                "Hey Hi",
                "7.45 Am",
                3,
                true
            )
        )

        list.add(
            WaData(
                R.drawable.ic_launcher_background,
                "Volume",
                "its okay",
                "8.00 Pm",
                45,
                false
            )
        )


        val mgr = LinearLayoutManager(this)
        val adapter = WaAdapter(this, list)

        val recLst: RecyclerView = findViewById(R.id.waList)
        recLst.layoutManager = mgr
        recLst.adapter = adapter
    }
}