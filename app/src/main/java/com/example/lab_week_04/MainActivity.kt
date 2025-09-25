package com.example.lab_week_04

import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val drawerLayout = findViewById<DrawerLayout>(R.id.drawer_layout)
        val navView = findViewById<NavigationView>(R.id.nav_view)
        val bottomNavView = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        val toolbar: androidx.appcompat.widget.Toolbar = findViewById(R.id.toolbar)

        setSupportActionBar(toolbar)

        val toggle = ActionBarDrawerToggle(
            this,
            drawerLayout,
            toolbar,
            R.string.app_name,
            R.string.app_name
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, ListFragment())
                .commit()
        }

        bottomNavView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.listFragment -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, ListFragment())
                        .commit()
                    true
                }
                R.id.cafeFragment -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, CafeFragment())
                        .commit()
                    true
                }
                else -> false
            }
        }
    }
}
