package com.example.toolbar.simpleMenu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem

import androidx.appcompat.widget.Toolbar
import com.example.toolbar.R
import com.example.toolbar.contextualActionMode.forIndivisualViews.FourthActivity
import com.example.toolbar.contextualActionMode.forMultipleVisualViews.firstMethod.Fifth
import com.example.toolbar.floatingContextMenu.SecondActivity
import com.example.toolbar.floatingContextMenu.ThirdActivity
import com.example.toolbar.searchView.simpleSearchView.SearchViewExample

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.title = "Main Activity"


    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
         super.onCreateOptionsMenu(menu)
        menuInflater.inflate(R.menu.appbar_menu,menu)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
         super.onOptionsItemSelected(item)



        if (item.itemId == R.id.menu_secondActivity){
            startActivity(Intent(this, SecondActivity::class.java))

        }

        if (item.itemId == R.id.menu_thirdActivity){
            startActivity(Intent(this, ThirdActivity::class.java))

        }

        if (item.itemId == R.id.menu_fourthActivity){
            startActivity(Intent(this, FourthActivity::class.java))

        }

        if (item.itemId == R.id.menu_fifthActivity){
            startActivity(Intent(this, Fifth::class.java))

        }

        if (item.itemId == R.id.menu_searchViewActivity){
            startActivity(Intent(this, SearchViewExample::class.java))

        }
        return true
    }

}