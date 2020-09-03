package com.example.views.chat

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.views.R

class ChatAdapter(
    private val ctx: Context,
   // private  val adapter: ChatAdapter,
    private  var chats:List<Chat>
):RecyclerView.Adapter<ChatAdapter.ChatViewHolder> (){

    inner class ChatViewHolder(private val view: View):RecyclerView.ViewHolder(view)
    {
        val msg= view.findViewById<TextView>(R.id.txt_msg)
        val frm= view.findViewById<TextView>(R.id.txt_from)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatViewHolder {

        val inf=LayoutInflater.from(ctx)
        return  ChatViewHolder(inf.inflate(R.layout.chat_item,parent,false))
    }

    override fun getItemCount(): Int = chats.size


    override fun onBindViewHolder(holder: ChatViewHolder, position: Int) {


        holder.frm.text= chats[position].from
        holder.msg.text=chats[position].msg

    }

    fun update(chats: List<Chat>)
    {
        this.chats=chats
        notifyDataSetChanged()
    }

}