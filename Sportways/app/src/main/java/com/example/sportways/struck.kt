package com.example.sportways

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBar
import kotlinx.android.synthetic.main.activity_data_pembeli.*
import kotlinx.android.synthetic.main.activity_struck.*

class struck : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_struck)

        val actionBar: ActionBar? = supportActionBar
        actionBar!!.setDisplayHomeAsUpEnabled(true)
        actionBar!!.setDisplayShowHomeEnabled(true)

        var intent = intent

        val aPembeli        = intent.getStringExtra("pembeli")
        val aNoHp           = intent.getStringExtra("noHp")
        val aAlamat         = intent.getStringExtra("alamat")
        val aProduct        = intent.getStringExtra("name")
        val aPrice          = intent.getIntExtra("price",0)
        val aqty            = intent.getIntExtra("qty",0)
        val aTotal          = intent.getIntExtra("tot",0)

        actionBar.setTitle("struck " +aPembeli)

        editNama1.text      = aPembeli
        editno2.text        = aNoHp
        editalamat3.text    = aAlamat
        coba1.text          = aProduct
        coba2.text          = aPrice.toString()
        coba3.text          = aqty.toString()
        coba4.text          = aTotal.toString()

    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
