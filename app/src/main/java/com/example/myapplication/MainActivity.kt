package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.text)

        button.setOnClickListener {
            button.setText("点击")
        }

        val arrayOf = arrayOf("Who", "are", "you")
        text.setOnClickListener {
        var str:String =  ""
        var  i:Int = 1
          while (i<arrayOf.size){
              str += arrayOf[i]+"."
              i++
          }
            text.text = str
        }

        val goodsList:List<String> = listOf("iPhone8", "Mate10", " 魅族6", "OPPO R11", "vivo X9S", "魅族Pro6S")


        text_fenge.setOnClickListener {
            
        }


        var  i:Int = 1
        when(i){
            0  -> Toast.makeText(this,"1",Toast.LENGTH_SHORT).show()

            else -> Toast.makeText(this,"其他的",Toast.LENGTH_SHORT).show()
        }

    }
}
