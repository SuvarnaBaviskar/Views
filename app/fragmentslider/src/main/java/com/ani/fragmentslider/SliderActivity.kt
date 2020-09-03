package com.ani.fragmentslider

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.fragment.app.Fragment

class SliderActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_slider)

       loadFragment(ZoomFragment.getInstance())



        val list: MutableList<ImageData> = ArrayList()
        list.add(
            ImageData(
                   R.drawable.index
              )
        )

        list.add(
            ImageData(
                R.drawable.comp
            )
        )

        list.add(
            ImageData(
                R.drawable.index
            )
        )

        val mgr = LinearLayoutManager(this)
        mgr.orientation = LinearLayoutManager.HORIZONTAL
        val adapter = ImageAdapter(this, list)

        val recLst: RecyclerView = findViewById(R.id.ImageList)
        recLst.layoutManager = mgr
        recLst.adapter = adapter

    }



    private fun loadFragment(fragment: Fragment)
    {
        Log.i("ani","Load Fragment failed")


            val txn = supportFragmentManager.beginTransaction()
            txn.replace(R.id.FragContainer, ZoomFragment())
            txn.commit()


        Log.i("ani","Load Fragment successfully")
    }

}
