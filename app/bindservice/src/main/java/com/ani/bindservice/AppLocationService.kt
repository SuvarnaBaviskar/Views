package com.ani.bindservice

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.Service
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Binder
import android.os.Build
import android.os.IBinder
import android.util.Log

class AppLocationService : Service() {

    var cntval = 0
   private var mlistener :JustLocationChangedListener?= null

    override fun onBind(intent: Intent): IBinder? = null

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {


        Thread{
            for(i in 0..1000)
            {
                Thread.sleep(1000)
               // Log.i("@ani","$i")
                cntval=i
                mlistener?.justLocationChanged(cntval)
            }
        }.start()

        notification()
        return START_STICKY
    }

    inner class LocalBinder: Binder()
    {
        fun getService(): AppLocationService = this@AppLocationService
    }

    private fun notification()
    {
        // val intent = Intent(this, InfoActivity::class.java )
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {


            val channelId = createNotificationChannel("123",channelName = "Ani")
            val builder  = Notification.Builder(this, channelId)
                .setContentTitle("Location")
                .setContentText("Need your Location")
                .setSmallIcon(R.drawable.ic_baseline_gps_fixed_24)

                .setTicker("Ticker")

            startForeground(1346,builder.build())
        }
    }

    //  @RequiresApi(Build.VERSION_CODES.O)
    private  fun createNotificationChannel(channelId: String,channelName:String):String{
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val chan =
                NotificationChannel(channelId, channelName, NotificationManager.IMPORTANCE_NONE)
            chan.lightColor = Color.BLUE
            chan.lockscreenVisibility = Notification.VISIBILITY_PRIVATE
            val service = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            service.createNotificationChannel(chan)
            return channelId
        }else
        {
            return  ""
        }
    }

    fun setJustLocationChangedListener(listener: JustLocationChangedListener)
    {
        if(listener != null) mlistener=listener
    }





}
