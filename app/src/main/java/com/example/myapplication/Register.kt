package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main2.*

class Register : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        register.setOnClickListener {
            var name:String = register_name.text.toString()
            var pwd:String = register_pwd.text.toString()

            val userEntery = UserEntery(name, pwd)

            var usermsg:ArrayList<String> = arrayListOf(name,pwd)




            var intent = Intent(this, Login::class.java)
            intent.putStringArrayListExtra("user",usermsg)
            startActivity(intent)
        }
    }
}
