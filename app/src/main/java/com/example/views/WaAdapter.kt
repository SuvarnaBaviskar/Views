package com.example.views

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class WaAdapter(
    private val ctx : Context,
    private val list : List<WaData>
) : RecyclerView.Adapter<WaAdapter.WaViewHolder>()
   {
      class WaViewHolder(
        private val view: View

      ): RecyclerView.ViewHolder(view)
      {
          fun dp() = view.findViewById<ImageView>(R.id.view_dp)

          fun name() = view.findViewById<TextView>(R.id.txt_nm)

          fun msg() = view.findViewById<TextView>(R.id.txt_msg)

          fun tm() = view.findViewById<TextView>(R.id.txt_time)

          fun cnt() = view.findViewById<TextView>(R.id.txt_count)

          fun mute() = view.findViewById<ImageView>(R.id.img_mute)
      }

      override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WaViewHolder {
        val view = LayoutInflater.from(ctx).inflate(R.layout.wa_listitem, parent, false)
        return WaViewHolder(view)

      }

       override fun getItemCount(): Int = list.size

       override fun onBindViewHolder(holder: WaViewHolder, pos: Int) {

           holder.dp().setImageResource(list[pos].dp)
           holder.name().text = list[pos].nm
           holder.msg().text = list[pos].msg
           holder.tm().text = list[pos].tm
           holder.cnt().text = "${list[pos].cnt}"
           if(list[pos].ismute)
               holder.mute().setImageResource(R.drawable.ic_baseline_volume_off_24)
           else holder.mute().visibility = View.GONE
       }

   }