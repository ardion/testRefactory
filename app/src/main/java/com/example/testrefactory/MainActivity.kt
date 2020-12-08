package com.example.testrefactory

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.ddd.androidutils.DoubleClick
//import com.ddd.androidutils.DoubleClick
import com.ddd.androidutils.DoubleClickListener
import com.example.testrefactory.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(
            this,
            R.layout.activity_main
        )

        val doubleClick = DoubleClick(object : DoubleClickListener {
            override fun onSingleClickEvent(view: View?) {

                val string=binding.et.text.toString()

                if(string.isNotEmpty()){
                    binding.et.setText("")
                    binding.et.append(string.substring(0,string.length-1))
                }
                else {
                binding.tv.text=""
                }

            }


            override fun onDoubleClickEvent(view: View?) {
                Toast.makeText(baseContext, "redo", Toast.LENGTH_SHORT).show()
            }
        })

        binding.btn.setOnClickListener(doubleClick)

        binding.btnreverese.setOnClickListener {
            val string=binding.et.text.toString()
            var balik:String=""
            var n=string.length-1

            for(i in 0..n){
                balik+=string[n-i]
            }

            binding.tv.text=balik

        }

    }
}