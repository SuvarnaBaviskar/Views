package com.ani.login

import android.util.Log
import android.view.Gravity
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

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
            status.value = true
//            val myToast = Toast.makeText(this,"toast message with gravity",Toast.LENGTH_SHORT)
//            myToast.setGravity(Gravity.LEFT,200,200)
//            myToast.show()
        }

        Log.i("@ani", "User - ${usNm.value} Pass - ${pass.value}")
    }

}