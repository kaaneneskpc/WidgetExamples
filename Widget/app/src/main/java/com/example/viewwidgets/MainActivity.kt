package com.example.viewwidgets

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.viewwidgets.databinding.ActivityMainBinding

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding= ActivityMainBinding.inflate(layoutInflater)
        val view=binding.root
        setContentView(view)

        binding.webView.settings.javaScriptEnabled=true
        webView.loadUrl("https://tr.motorsport.com/driver/sebastian-vettel/334571/")

        buttonGo.setOnClickListener{
            val intent= Intent(this,SecondActivity::class.java)
            startActivity(intent)
        }
    }
}