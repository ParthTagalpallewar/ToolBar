package com.example.toolbar.floatingContextMenu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.example.toolbar.R

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        setToolBar()

        contextTualMenu()
    }

    private fun setToolBar() {
        setSupportActionBar(findViewById(R.id.toolbar))
        supportActionBar?.title = "Second Activity"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }


    private fun contextTualMenu() {
        val textViewLongClick:TextView = findViewById(R.id.tv_longPressContextual)
        registerForContextMenu(textViewLongClick)
    }

    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {
        super.onCreateContextMenu(menu, v, menuInfo)
       menu?.setHeaderTitle("Context Menu")
        menu?.add(0,v?.id!!,0,"Delete")

    }

    override fun onContextItemSelected(item: MenuItem): Boolean {


        return when(item.title){
           "Delete" -> {

               Toast.makeText(applicationContext, "deleted", Toast.LENGTH_LONG).show()
               true
           }
            else -> return false
        }



    }
}