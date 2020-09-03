package com.example.views.chat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.views.R
import com.example.views.StorageApp
import kotlinx.android.synthetic.main.activity_chat2.*
//import kotlinx.coroutines.experimental.GlobalScope
//import kotlinx.coroutines.experimental.launch

class ChatActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat2)

        val chatsData=(application as StorageApp).db.chatDao().chats()
        val chatRepo= ChatRepository((application as StorageApp).db.chatDao())

       // chatRc

        val adapter= ChatAdapter(this, chatsData.value ?: emptyList<Chat>())
        chatRc.adapter= adapter
        chatRc.layoutManager=LinearLayoutManager(this)

        chatsData.observe(this, Observer {
            adapter.update(it)

        })


        btn_ok.setOnClickListener {
           Thread{
                chatRepo.save(
                    Chat(
                        System.currentTimeMillis(),
                        "Ani",
                        et_chat.text.toString()
                    )

                )
            }.start()

        }
    }
}