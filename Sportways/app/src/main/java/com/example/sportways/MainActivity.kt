package com.example.sportways

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.SearchView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var actionBarToggle: ActionBarDrawerToggle
    private lateinit var navDrawerView: NavigationView

    private lateinit var bottomNavigation : BottomNavigationView

    var myAdapter : ProductAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val arrayItem = ArrayList<product_model>()
        arrayItem.add(product_model("Sepatu Futsal Jogosala Theorem","Ortus Eight Jagosala Theorem sepatu futsal yang menggunakan teknologi Quick-Fit dengan material pelapis dalam upper sepatu yang menyesuaikan dengan bentuk kaki dan memberikan kenyamanan bagi pemakainya.",R.drawable.ortus1, 500000))
        arrayItem.add(product_model("Sepatu Futsal Jogosala Volta","Ortus Eight Jagosala Volta sepatu futsal yang menggunakan teknologi Quick-Fit dengan material pelapis dalam upper sepatu yang menyesuaikan dengan bentuk kaki dan memberikan kenyamanan bagi pemakainya.",R.drawable.ortus3, 430000))
        arrayItem.add(product_model("Sepatu Futsal Jogosala Maverick","Jogosala Maverick yang menggunakan teknologi Quick-Fit dengan material pelapis dalam upper sepatu yang menyesuaikan dengan bentuk kaki dan memberikan kenyamanan bagi pemakainya",R.drawable.ortus2, 280000))
        arrayItem.add(product_model("Sepatu Futsal Mirage IN","Ortus Eight Mirage In merupakan sepatu futsal yang menggunakan teknologi Quick-Fit dengan material pelapis dalam upper sepatu yang menyesuaikan dengan bentuk kaki dan memberikan kenyamanan bagi pemakainya,",R.drawable.ortus6, 230000))
        arrayItem.add(product_model("Sepatu Futsal Forte Savage IN","Ortus Eight Forte Savage In merupakan sepatu futsal yang menggunakan teknologi Ort-Tube dengan material rajutan dengan bahan polyester membuat kaki seolah menyatu dengan sepatu dan membuat gerakan kaki semakin cepat.",R.drawable.ortus7, 400000))
        arrayItem.add(product_model("Sepatu Futsal Forte Vantage IN","Ortus Eight Forte Vantage In merupakan sepatu futsal yang menggunakan teknologi Quick-Fit dengan material pelapis dalam upper sepatu yang menyesuaikan dengan bentuk kaki dan memberikan kenyamanan bagi pemakainya",R.drawable.ortus8, 385000))
        arrayItem.add(product_model("Sepatu Futsal Forte Instinct IN","Forte Instinct merupakan sepatu sepak bola lanjutan dari silo Power, yang sebelumnya hadir melalui Forte Helios. Sebagai produk hasil gagasan dan inovasi baru.",R.drawable.ortus9, 380000))
        arrayItem.add(product_model("Sepatu Futsal Cygnus IN","Ortus Eight Cygnus In merupakan  sepatu futsal dengan menggunakan teknologi Quick-Fit dengan material pelapis dalam upper sepatu yang menyesuaikan dengan bentuk kaki dan memberikan kenyamanan bagi pemakainya.",R.drawable.ortus10, 215000))
        arrayItem.add(product_model("Sepatu Futsal Catalyst Therion IN","Catalyst Legion sendiri merupakan sepatu yang sangat ringan dan nyaman dikenakan, serta sangat baik ketika digunakan untuk melakukan akselerasi dalam waktu cepat. Seperti mengejar lawan atau mengejar bola.",R.drawable.ortus11, 425000))
        arrayItem.add(product_model("Sepatu Futsal Glacier IN","Ortus Eight Glacier In merupakan sepatu futsal yang menggunakan teknologi Quick-Fit dengan material pelapis dalam upper sepatu yang menyesuaikan dengan bentuk kaki dan memberikan kenyamanan bagi pemakainya",R.drawable.ortus12, 300000))
        arrayItem.add(product_model("Sepatu Futsal OrtusEight Blizzard IN Original","OrtusEight Blizzard IN merupakan sepatu futsal yang menggunakan teknologi Quick-Fit dengan material pelapis dalam upper sepatu yang menyesuaikan dengan bentuk kaki dan memberikan kenyamanan bagi pemakainya.",R.drawable.ortus13, 200000))

        myAdapter = ProductAdapter(this)
        myAdapter!!.setData(arrayItem)

        //Product_RecyclerView berasal dari id recyclerView pada activity_main.xml
        Product_ReycleView.layoutManager = LinearLayoutManager(this)
        Product_ReycleView.adapter = myAdapter

        bottomNavigation = findViewById(R.id.navBotton)
        bottomNavigation.setOnNavigationItemReselectedListener {
            when (it.itemId) {
                R.id.navigation_home -> {
                    val intent = Intent(applicationContext, MainActivity::class.java)
                    startActivity(intent)
                    true
                }
                R.id.history -> {
                    Toast.makeText(this, "Go to history transaction", Toast.LENGTH_SHORT).show()
                    true
                }
                else -> {
                    false
                }
            }
        }

        drawerLayout = findViewById(R.id.drawer)
        actionBarToggle = ActionBarDrawerToggle(this, drawerLayout, 0, 0)
        drawerLayout.addDrawerListener(actionBarToggle)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        actionBarToggle.syncState()

        navDrawerView = findViewById(R.id.navDrawer)
        navDrawerView.setNavigationItemSelectedListener { MenuItem ->
            when (MenuItem.itemId) {
                R.id.myProfile -> {
                    val intent = Intent(application, Profile::class.java)
                    startActivity(intent)
                    true
                }
                R.id.myContack -> {
                    Toast.makeText(this, "Go to My Contack", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.myHelp -> {
                    Toast.makeText(this, "Go to My Help", Toast.LENGTH_SHORT).show()
                    true
                }
                else -> {
                    false
                }
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        if (this.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            this.drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            this.drawerLayout.openDrawer(GravityCompat.START)
        }
        return true
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu, menu)

        val searchItem = menu?.findItem(R.id.search)
        if(searchItem != null){
            val searchView = searchItem.actionView as SearchView
            searchView.maxWidth = Int.MAX_VALUE
            searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {

                override fun onQueryTextSubmit(p0: String?): Boolean {
                return true
                }

                override fun onQueryTextChange(filterString: String?): Boolean {
                myAdapter!!.filter.filter(filterString)
                return true
                }
            })
        }
            return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        if (id == R.id.shooping) {
            Toast.makeText(this, "View Shooping Chart", Toast.LENGTH_SHORT).show()
            return true
        } else if (id == R.id.account) {
            Toast.makeText(this, "Account Clicked", Toast.LENGTH_SHORT).show()
            return true
        } else if (id == R.id.logout) {
            Toast.makeText(this, "Logout berhasil", Toast.LENGTH_SHORT).show()

            val i = Intent(this, Login::class.java)
            startActivity(i)
        }

        return super.onOptionsItemSelected(item)
    }
}
