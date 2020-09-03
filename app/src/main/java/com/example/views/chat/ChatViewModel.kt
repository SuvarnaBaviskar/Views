package com.example.views.chat

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.views.StorageApp

class ChatViewModel(
    private val app:StorageApp,
    private val repo:ChatRepository
):ViewModel() {
    val chats :LiveData<List<Chat>> = repo.chats
}