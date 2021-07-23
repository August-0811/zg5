package com.example.day005_zhuoye

import android.Manifest
import android.content.pm.PackageManager
import android.database.Cursor
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

class Main2Activity : AppCompatActivity() {

    var adapter: ArrayAdapter<String>? = null
    var contactsList = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        var contactsView = findViewById<ListView>(R.id.contacts_view)
        adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,contactsList)
        contactsView.adapter = adapter

        if(ContextCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.READ_CONTACTS),1)
        } else {
            readContacts()
        }
    }


    fun readContacts() {
        var cursor: Cursor? = null
        try{
            cursor = contentResolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,null,null,null,null)
            if(cursor != null) {
                while(cursor.moveToNext()) {
                    var displayName = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME))
                    var number = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER))
                    contactsList.add(displayName+"\n"+number)
                }

                adapter?.notifyDataSetChanged()
            }
        }catch (e: Exception) {
            e.printStackTrace()
        }finally {
            if(cursor != null) {
                cursor.close()
            }
        }
    }


    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        when(requestCode) {
            1->{
                if(grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    readContacts()
                }else {
                    Toast.makeText(this,"You denied the permission!!",Toast.LENGTH_SHORT).show()
                }
            }
            else->{

            }
        }
    }
}
