package com.example.dateandtimepicker

import android.app.AlertDialog
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.DialogInterface
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    private val countries =ArrayList<String>()
    private lateinit var adapter: ArrayAdapter<String>

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        countries.add("UK")
        countries.add("USA")
        countries.add("Italy")
        countries.add("Japan")
        countries.add("Turkey")
        countries.add("BAE")

        adapter=ArrayAdapter(this,android.R.layout.simple_list_item_1,android.R.id.text1,countries)
        spinner.adapter = adapter

        editTextClock.setOnClickListener {
            val calendar = Calendar.getInstance()
            val hour = calendar.get(Calendar.HOUR_OF_DAY)
            val minute = calendar.get(Calendar.MINUTE)
            val timePicker = TimePickerDialog(this@MainActivity,TimePickerDialog.OnTimeSetListener{timePicker,h,m->
                editTextClock.setText("$h:$m")
            },hour,minute,true)
            timePicker.setTitle("Choose Clock :")
            timePicker.setButton(DialogInterface.BUTTON_POSITIVE,"set",timePicker)
            timePicker.setButton(DialogInterface.BUTTON_NEGATIVE,"cancel",timePicker)
            timePicker.show()
        }
        editTextDate.setOnClickListener {
           val calendar = Calendar.getInstance()
            val year=calendar.get(Calendar.YEAR)
            val month=calendar.get(Calendar.MONTH)
            val day=calendar.get(Calendar.DAY_OF_MONTH)
            val datePicker=DatePickerDialog(this@MainActivity,DatePickerDialog.OnDateSetListener{datePicker,y,m,d->
                editTextDate.setText("$d/${m+1}/$y")
            },year,month,day)
            datePicker.setTitle("Choose Date :")
            datePicker.setButton(DialogInterface.BUTTON_POSITIVE,"set",datePicker)
            datePicker.setButton(DialogInterface.BUTTON_NEGATIVE,"cancel",datePicker)
            datePicker.show()
        }
             spinner.onItemSelectedListener =object : AdapterView.OnItemSelectedListener{
                 override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                     Toast.makeText(this@MainActivity,"Selected Country : ${countries[position]}",Toast.LENGTH_SHORT).show()
                 }

                 override fun onNothingSelected(parent: AdapterView<*>?) {
                     TODO("Not yet implemented")
                 }

             }
        buttonSave.setOnClickListener {
            val alert= AlertDialog.Builder(this)
            alert.setTitle("Save")
            alert.setMessage("Do you wanna save?")
            alert.setPositiveButton("Yes"){dialog,which ->
                Toast.makeText(applicationContext,"Saved",Toast.LENGTH_SHORT).show()
            }
            alert.setNegativeButton("No"){dialog,which ->
                Toast.makeText(applicationContext,"Not Saved",Toast.LENGTH_SHORT).show()
            }
            alert.show()
            //Toast.makeText(this@MainActivity,"Selected Country : ${countries[spinner.selectedItemPosition]}",Toast.LENGTH_SHORT).show()
        }
    }
}