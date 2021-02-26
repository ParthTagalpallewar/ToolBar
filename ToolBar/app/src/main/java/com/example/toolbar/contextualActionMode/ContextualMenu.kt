package com.example.toolbar.contextualActionMode
//https://medium.com/over-engineering/using-androids-actionmode-e903181f2ee3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.ProxyFileDescriptorCallback
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.view.ActionMode
import com.example.toolbar.R

class `ContextualMenu` : AppCompatActivity() {

    var actionMode: ActionMode? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fourth)



        val  actionModeCallback:ActionMode.Callback = object : ActionMode.Callback{
            override fun onCreateActionMode(mode: ActionMode?, menu: Menu?): Boolean {

                menuInflater.inflate(R.menu.appbar_individual_actionmode,menu)

                return true
            }

            override fun onPrepareActionMode(mode: ActionMode?, menu: Menu?): Boolean {
                return false
            }

            override fun onActionItemClicked(mode: ActionMode?, item: MenuItem?): Boolean {
                when(item?.itemId){
//                    R.id.fourthMenuDelete -> Toast.makeText(applicationContext,"Fourth Delete",Toast.LENGTH_LONG).show()

                    R.id.fourthMenuSearch -> Toast.makeText(applicationContext,"Fourth Search",Toast.LENGTH_LONG).show()

                }

                return true
            }

            override fun onDestroyActionMode(mode: ActionMode?) {
                actionMode = null
            }
        }

        val fourthTextView:TextView = findViewById(R.id.fourthTv_longPressActionMode)
        fourthTextView.setOnLongClickListener{
            when (actionMode) {
                null -> {
                    actionMode = startSupportActionMode(actionModeCallback)
                    it.isSelected = true
                    true
                }else-> false
            }
        }


    }
}