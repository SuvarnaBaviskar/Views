package com.ani.fragmentslider

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_zoom.*
import kotlinx.android.synthetic.main.recycle_item.view.*
import kotlin.math.max
import kotlin.math.min


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class ZoomFragment : Fragment() {

    private var param1: String? = null
    private var param2: String? = null
    private lateinit var scaleGestureDetector: ScaleGestureDetector
    private var scaleFactor = 1.0f



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_zoom, container, false)

    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val zoom_image = view.findViewById<ImageView>(R.id.zoom_imageview)
        // zoom_image.setImageResource(R.drawable.comp)
        arguments?.let {


                zoom_image.setImageResource(it.getInt(KEY_BTN))
        }
           // Log.i("Ani Image",arguments?.getInt(KEY_BTN) ?: R.drawable.comp)

       // Toast.makeText(activity as Context,arguments?.getInt(KEY_BTN),LE)
        //zoom_image.setImageResource((Integer.parseInt(arguments?.getInt(KEY_BTN).toString()))
        //val btn= view.findViewById<Button>(R.id.bt_k)
        //btn.text=arguments?.getString(KEY_BTN) ?: "Android"


        //scaleGestureDetector = ScaleGestureDetector(activity as Context, ScaleListener())


//        view!!.setOnTouchListener { v, event ->
//            if (event.action == MotionEvent.ACTION_MOVE) {
//                scaleGestureDetector.onTouchEvent(event)
//            }
//            true
//        }


    }

        private inner class ScaleListener : ScaleGestureDetector.SimpleOnScaleGestureListener() {

        override fun onScale(scaleGestureDetector: ScaleGestureDetector): Boolean {
            scaleFactor *= scaleGestureDetector.scaleFactor
           scaleFactor = max(10.0f,(min(0.1f,10.0f)))
            zoom_image.scaleX = scaleFactor
            zoom_image.scaleY = scaleFactor
            return true
        }
        }

    companion object{
        const val KEY_BTN = "key_btn"
        fun getInstance() :ZoomFragment
        {
            val frag= ZoomFragment()
            val bnd=Bundle()
            bnd.putInt(KEY_BTN,R.drawable.index)
            frag.arguments = bnd

            Log.i("Companion image",frag.arguments.toString())
            return  frag
        }
    }

}