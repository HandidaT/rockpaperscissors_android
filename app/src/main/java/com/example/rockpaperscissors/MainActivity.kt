package com.example.rockpaperscissors

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import io.realm.Realm

class MainActivity : AppCompatActivity() {
    private lateinit var namet: EditText
    private lateinit var nameb: Button
    private lateinit var backgroundThreadRealm: Realm

    override fun onCreate(savedInstanceState: Bundle?) {
        namet = findViewById(R.id.nameEt)
        nameb = findViewById(R.id.namebt)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        backgroundThreadRealm = Realm.getDefaultInstance()

        nameb.setOnClickListener {
            addName()
            startActivity(Intent(this,Play::class.java))
            finish()
        }
}

    private fun addName(){
        try{
            backgroundThreadRealm.beginTransaction()
            val data=DataModel()
            data._id="1"
            data.value=namet.text.toString()
            backgroundThreadRealm.copyToRealmOrUpdate(data)
            backgroundThreadRealm.commitTransaction()
            Toast.makeText(this,"Successfully Registered", Toast.LENGTH_SHORT).show()
        }catch(e: Exception){
            backgroundThreadRealm.commitTransaction()
            Toast.makeText(this,"Registration Failed", Toast.LENGTH_SHORT).show()
        }
    }


}