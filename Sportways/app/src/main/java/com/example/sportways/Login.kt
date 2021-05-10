package com.example.sportways

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*

class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }

    fun LoginMasuk(view: View) {
        val Uname = username.text.toString()
        val Upass = pass123.text.toString()

        if ((Uname == "") || (Upass == "")) {
            Toast.makeText(this, "Isikan Username atau Password dulu !", Toast.LENGTH_SHORT).show()
        } else if (Uname.toLowerCase() == "otniel" && Upass.toLowerCase()== "123456") {
            Toast.makeText(this, "Login Berhasil", Toast.LENGTH_SHORT).show()

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            true
        } else {
            Toast.makeText(this, "Username atau Password salah", Toast.LENGTH_SHORT).show()
        }
    }

        override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

}