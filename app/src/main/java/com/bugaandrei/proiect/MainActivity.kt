package com.bugaandrei.proiect

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        //Drawer support
        val toggle = ActionBarDrawerToggle(this, drawerLayout, toolbar,R.string.open,R.string.close)
        toggle.isDrawerIndicatorEnabled = true
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        nav_menu.setNavigationItemSelectedListener(this)
        //Replacing to fragment
        changeFrag(Home())
        setToolTitle("Agenda")
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        drawerLayout.closeDrawer(GravityCompat.START)


        when(item.itemId)
        {
            R.id.home ->
            {
                changeFrag(Home())
                setToolTitle("Agenda")
            }
            R.id.about ->
            {
                changeFrag(About())
                setToolTitle("About")
            }
            R.id.contact ->
            {
                changeFrag(Contact())
                setToolTitle("Contact")
            }
            R.id.camera ->
            {
                changeFrag(Camera())
                setToolTitle("Camera")
            }
        }

        return true
    }

    fun setToolTitle(title:String)
    {
        supportActionBar?.title = title
    }

    fun changeFrag(frag: Fragment)
    {
        val fragment = supportFragmentManager.beginTransaction()
        fragment.replace(R.id.fragment_container,frag).commit()
    }
}