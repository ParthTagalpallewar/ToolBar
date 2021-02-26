package com.example.toolbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem

import androidx.appcompat.widget.Toolbar
import com.example.toolbar.contextualActionMode.ContextualMenu
import com.example.toolbar.multiselectInRecyclerView.MultiSelectExample
import com.example.toolbar.floatingContextMenu.FloatingMenu
import com.example.toolbar.utils.move

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
        menuInflater.inflate(R.menu.appbar_menu, menu)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        super.onOptionsItemSelected(item)

        when (item.itemId) {

            R.id.menu_thirdActivity -> {
                move(FloatingMenu::class.java)
            }
            R.id.menu_fourthActivity -> {

                move(ContextualMenu::class.java)
            }
            R.id.menu_fifthActivity -> {
                move(MultiSelectExample::class.java)

            }

        }
        return true
    }

}