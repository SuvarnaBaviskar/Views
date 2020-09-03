package com.ani.login

import android.content.Intent
import android.util.Log
import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.security.AccessController.getContext

class LoginViewModel : ViewModel()
{
    //val _usNm:MutableLiveData<String> = MutableLiveData()
    //val _pass :MutableLiveData<String> = MutableLiveData()

    val usNm = MutableLiveData<String>()
    val pass = MutableLiveData<String>()
    val status = MutableLiveData<Boolean?>()
//In your network successfull response


    fun login() {
        if(usNm.value == "android" && pass.value =="an") {

          //val myToast = Toast.makeText(this,"toast message with gravity",Toast.LENGTH_SHORT)
           //myToast.setGravity(Gravity.LEFT,200,200)
           //myToast.show()
        }

        status.value = true

        Log.i("@ani", "User - ${usNm.value} Pass - ${pass.value}")
    }

    fun Intent()
    {

//        val myIntent =
//            Intent(View., SecondActivity::class.java)
//        getContext().getBaseContext().startActivity(myIntent)
//
//        val intent: Intent = Intent(getContext(),SecondActivity::class.java)
//        getApplication().startActivity(myIntent);
    }

}