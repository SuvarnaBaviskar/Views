package com.example.views.chat

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ChatDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun save(chat: Chat)

    @Query("select * from chat_data")
    fun chats():LiveData<List<Chat>>
}