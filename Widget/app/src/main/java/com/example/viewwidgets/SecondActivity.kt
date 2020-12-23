package com.example.viewwidgets

import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        buttonNext.setOnClickListener {
            //imageView.setImageResource(R.drawable.image2)
            imageView.setImageResource(resources.getIdentifier("image1","drawable",packageName))
        }
        buttonPrevious.setOnClickListener {
            //imageView.setImageResource(R.drawable.image1)
            imageView.setImageResource(resources.getIdentifier("image2","drawable",packageName))
        }

        buttonStart.setOnClickListener {
            val adress = Uri.parse("android.resource://"+packageName+"/"+R.raw.sebastian)
            videoView.setVideoURI(adress)
            videoView.start()
        }
        buttonStop.setOnClickListener {
            videoView.stopPlayback()
        }
    }
}