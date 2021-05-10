package com.example.sportways

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.ActionBar
import kotlinx.android.synthetic.main.activity_data_pembeli.*
import kotlinx.android.synthetic.main.activity_struck.*

class data_pembeli : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data_pembeli)

        val actionBar: ActionBar? = supportActionBar
        actionBar!!.setDisplayHomeAsUpEnabled(true)
        actionBar!!.setDisplayShowHomeEnabled(true)

        //Pembuatan variabel intent pemanggilan ke class order
        val intent   = intent

        val aProduct = intent.getStringExtra("name")
        val aPrice   = intent.getIntExtra("price", 0)
        val ajumlah  = intent.getIntExtra("qty", 0)
        val atot     = intent.getIntExtra("tot", 0)

        actionBar.setTitle("Pembelian" + aProduct)

        trxproductname.text = aProduct
        trxprice.text = aPrice.toString()
        trxqty.text = ajumlah.toString()
        trxtot.text = atot.toString()

        btnproses.setOnClickListener{
            val intent = Intent(this, struck:: class.java)

            intent.putExtra("pembeli", nmpembeli.text.toString())
            intent.putExtra("noHp", nopembeli.text.toString())
            intent.putExtra("alamat", alamatpembeli.text.toString())
            intent.putExtra("name", aProduct)
            intent.putExtra("price", aPrice.toString().toInt())
            intent.putExtra("qty", trxqty.text.toString().toInt())
            intent.putExtra("tot", trxtot.text.toString().toInt())

            startActivity(intent)
            true
        }
    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}