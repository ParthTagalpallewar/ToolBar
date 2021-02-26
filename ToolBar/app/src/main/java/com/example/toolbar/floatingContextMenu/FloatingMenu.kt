package com.example.toolbar.floatingContextMenu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.example.toolbar.R
import com.example.toolbar.utils.toast

class FloatingMenu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)

        setSupportActionBar(findViewById(R.id.toolbar))
        supportActionBar?.title = "Third Activity"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        contextTualMenu()
    }

    private fun contextTualMenu() {
        val textViewLongClick: TextView = findViewById(R.id.third_longPressContextual)
        registerForContextMenu(textViewLongClick)
    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        menu?.setHeaderTitle("Context Menu")

        menuInflater.inflate(R.menu.appbar_contaxtmenu, menu)

    }

    override fun onContextItemSelected(item: MenuItem): Boolean {


        return when (item.itemId) {
            R.id.contextMenu_delete -> {
                toast("Menu Deleted")
                true
            }
            else -> return false
        }


    }
}