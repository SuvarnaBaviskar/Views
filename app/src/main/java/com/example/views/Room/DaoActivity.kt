package com.example.views.Room

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.widget.Toast
import com.example.views.R
import com.example.views.StorageApp
import kotlinx.android.synthetic.main.activity_dao.*



class DaoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dao)
        Toast.makeText(this,"toast message with room library", Toast.LENGTH_SHORT).show()

        val app =  application as StorageApp
        btnwrite.setOnClickListener {
            Thread {
                app.db.dmgInfoDao().saveDmg(DmgInfo(10,"abc",10,"45555"))

                  //  myToast.setGravity(Gravity.LEFT,200,200)
                  //  myToast.show()
            }.start()

            Toast.makeText(this,"toast message with room library", Toast.LENGTH_SHORT).show()

        }

        btn_read.setOnClickListener {
          // Glo
           // Global
            Thread{
                app.db.dmgInfoDao().all().forEach {
                    Log.i("@ani", it.mobile)

                }
            }.start()

        }
    }
}