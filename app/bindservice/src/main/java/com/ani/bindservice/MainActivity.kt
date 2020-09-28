package com.ani.bindservice

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import android.util.Log
import android.view.Gravity
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val appLcInt=Intent(this, AppLocationService::class.java)



        startService(appLcInt)
        btnst.setOnClickListener {

                Bind(appLcInt)

        }

        Log.i("@ani","cntval")

    }


    private fun Bind (appLcInt:Intent)
    {
        bindService(
            appLcInt,
           object:ServiceConnection{
                override fun onServiceDisconnected(p0: ComponentName?) {
                    Log.i("@ani","Disconnected to AppLocationService")
                  //  Context.BIND_DEBUG_UNBIND


                }

                override fun onServiceConnected(p0: ComponentName?, service: IBinder?) {
                    Log.i("@ani","Connected to AppLocationService")
                    val lb = service as AppLocationService.LocalBinder
                    val appLocationService= lb.getService()
                    appLocationService.setJustLocationChangedListener(object  :JustLocationChangedListener{
                        override fun justLocationChanged(cv: Int) {
                            Log.i("@ani","cnt val ${cv}")
                           // Toast.makeText(this@MainActivity)
                        }

                    })

                    Log.i("@ani","Count it ${appLocationService.cntval}")

                    val myToast = Toast.makeText(this@MainActivity,"toast message with gravity",Toast.LENGTH_SHORT)
                    myToast.setGravity(Gravity.LEFT,200,200)
                    myToast.show()
                }

            },
            BIND_AUTO_CREATE

        )
    }

//    override fun onStop() {
//        super.onStop()
//        unbindService(mConnection)
//    }
}
