package com.example.myapplication

import android.content.Intent
import android.nfc.tech.NfcA
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*

class Login : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val usermsg = intent.getStringArrayListExtra("user")
        var name = usermsg?.get(0)
        var pwd = usermsg?.get(1)
        val userEntery = UserEntery(name, pwd)

        var user:MutableList<UserEntery> = mutableListOf()

        user.add(userEntery)


        println(user)


        login.setOnClickListener {
            var login_name = login_name.text.toString()
            var login_pwd = login_pwd.text.toString()

            var logins:Boolean = false

            user.forEach { userEntery: UserEntery ->
               if ( userEntery.name.contains(login_name)&&userEntery.pwd.contains(login_pwd)){
                  logins = true
                   return@forEach
               }
            }

            if (logins){
                Toast.makeText(this,"登录成功",Toast.LENGTH_SHORT).show()
                var intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }else{
                Toast.makeText(this,"登录失败",Toast.LENGTH_SHORT).show()
            }

//            if (name == login_name) {
//                if (pwd == login_pwd) {
//                    Toast.makeText(this,"登录成功",Toast.LENGTH_SHORT).show()
//                } else {
//                    Toast.makeText(this,"登录失败",Toast.LENGTH_SHORT).show()
//                }
//            }else{
//                Toast.makeText(this,"登录失败",Toast.LENGTH_SHORT).show()
//            }


        }

        }
    }

