package com.example.sp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        login.setOnClickListener {
            var name = username.text.toString()
            val pwd = password.text.toString()

            if (!name.isEmpty() && !pwd.isEmpty()) {
                SPUtil.SPDeleg.preference("name", name)
                SPUtil.SPDeleg.preference("pwd", pwd)
                Toast.makeText(
                    this,
                    "name=${SPUtil.SPDeleg.findPreference("name", "null")}" +
                            "password=${SPUtil.SPDeleg.findPreference("pwd", "null")}",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}