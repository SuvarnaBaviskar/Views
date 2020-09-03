package com.example.views.chat

import android.util.Log
import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData

class ChatRepository(
    private  val dao: ChatDao
) {
    val chats:LiveData<List<Chat>> = dao.chats()

    @WorkerThread
    fun save(chat: Chat){
     val row =   dao.save(chat)

        Log.i("chatrepository","row")
    }
}