package com.ani.fragments

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment


class FragmentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)

        loadFragment(SecondFragment.getInstance("Exit"))

    }

    private fun loadFragment(fragment: Fragment)
    {
        val txn = supportFragmentManager.beginTransaction()
        txn.replace(R.id.FragContainer,SecondFragment())
        txn.commit()
    }

    fun generateColor(red :Int,green: Int ,blue:Int)
    {
       val color = Color.argb(255,red,green,blue)
        val firstFragment= supportFragmentManager.findFragmentById(R.id.fragment) as FirstFragment
        firstFragment.setBack(color)
    }
}
