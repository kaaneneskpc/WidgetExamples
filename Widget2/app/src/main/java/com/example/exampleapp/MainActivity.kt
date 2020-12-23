package com.example.exampleapp

import android.app.AlertDialog
import android.content.DialogInterface
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.SeekBar
import android.widget.Toast
import com.example.exampleapp.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding= ActivityMainBinding.inflate(layoutInflater)
        val view=binding.root
        setContentView(view)

      binding.buttonSave.setOnClickListener{
          val kotlinState = binding.checkBoxKotlin.isChecked
          val flutterState = binding.checkBoxFlutter.isChecked
          val javaState = binding.checkBoxJava.isChecked
          val yesState=binding.radioButtonYes.isChecked
          val noState=binding.radioButtonNo.isChecked

          Log.e("kotlinState",kotlinState.toString())
          Log.e("flutterState",flutterState.toString())
          Log.e("javaState",javaState.toString())
          Log.e("yesState",yesState.toString())
          Log.e("noState",noState.toString())

      val alert = AlertDialog.Builder(this)
          alert.setTitle("Save")
          alert.setMessage("Confirm?")
          alert.setPositiveButton("Yes"){dialog,which ->
              //onClickListener
              Toast.makeText(applicationContext,"Saved", Toast.LENGTH_SHORT).show()
          }
          alert.setNegativeButton("No"){dialog,which ->
              //onClickListener
              Toast.makeText(applicationContext,"Not Saved", Toast.LENGTH_SHORT).show()
          }
          alert.show()

            binding.progressBar.visibility = View.VISIBLE
          val ratingSize = ratingBar.rating
          Log.e("Result",ratingSize.toString())
      }

        binding.buttonCancel.setOnClickListener{
            binding.progressBar.visibility = View.INVISIBLE
        }


        seekBar.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
            textViewSeekBar.text="Result : $progress"
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }
        })






      }
    }
