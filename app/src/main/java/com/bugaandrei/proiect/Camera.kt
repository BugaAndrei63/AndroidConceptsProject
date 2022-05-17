package com.bugaandrei.proiect

import android.app.Activity.RESULT_OK
import android.content.ActivityNotFoundException
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_camera.*


class Camera : Fragment() {

    lateinit var imageView: ImageView
    lateinit var button: Button
    val REQUEST_IMAGE = 100
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_camera, container, false)
    }

    override fun onViewCreated(itemView: View, savedInstanceState: Bundle?) {
        super.onViewCreated(itemView, savedInstanceState)

        imageView = requireView().findViewById(R.id.imageView)
        button = requireView().findViewById<Button>(R.id.take_pic)

        button.setOnClickListener()
        {
            val picIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)

            try {
                startActivityForResult(picIntent,REQUEST_IMAGE)
            }catch (e: ActivityNotFoundException)
            {
                //Toast.makeText(this,"Error: " + e.localizedMessage,Toast.LENGTH_SHORT).show()
            }
        }


    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if(requestCode == REQUEST_IMAGE && resultCode == RESULT_OK)
        {
            val imageBitmap = data?.extras?.get("data") as Bitmap
            imageView.setImageBitmap(imageBitmap)

        }else
        {
            super.onActivityResult(requestCode,resultCode, data)
        }
    }
}