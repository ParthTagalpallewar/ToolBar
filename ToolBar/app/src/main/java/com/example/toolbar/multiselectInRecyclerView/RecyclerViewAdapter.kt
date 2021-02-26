package com.example.toolbar.multiselectInRecyclerView


import android.annotation.SuppressLint
import android.view.*
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.view.ActionMode
import androidx.recyclerview.widget.RecyclerView
import com.example.toolbar.R
import com.example.toolbar.multiselectInRecyclerView.MultiSelectExample.Companion.staticStringList
import kotlinx.android.synthetic.main.item_recyclerview.view.*

class RecyclerViewAdapter(private val mActivity: AppCompatActivity, private var stringList:ArrayList<String>):RecyclerView.Adapter<RecyclerView.ViewHolder>(),ActionMode.Callback {

    private var multiSelect = false
    private val selectedItems = arrayListOf<String>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_recyclerview,null,false)
        return ViewHolder(view)
    }

    @SuppressLint("ResourceAsColor")
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        val currentString = stringList[position]
        holder.itemView.item_tv.text = currentString

        //for every item, check to see if it exists in selected item array
        if (selectedItems.contains(currentString)){
            holder.itemView.setBackgroundColor(R.color.colorPrimary)
        }else{
            holder.itemView.setBackgroundColor(android.R.color.white)
        }

        //set Long click
        holder.itemView.itemRelativeLayout.setOnLongClickListener {
            if (!multiSelect){
                multiSelect = true

                mActivity.startSupportActionMode(this)
                selectedItems(holder,currentString)
            }

            true
        }

        //set single click
        //if user is in multiselect mode then add data to selecteditem
        holder.itemView.setOnClickListener {
            if (multiSelect){
                selectedItems(holder,currentString)
            }
            else{
                Toast.makeText(holder.itemView.context,currentString,Toast.LENGTH_SHORT).show()
            }
        }

    }

    override fun getItemCount()= stringList.size
    class ViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView)


    @SuppressLint("ResourceAsColor")
    private fun selectedItems(holder: RecyclerView.ViewHolder, currentString: String) {
            /*
            * if selectedItems list contains currentString
            * remove it
            * then set it to normal
            * */

        if (selectedItems.contains(currentString)){
            selectedItems.remove(currentString)
            holder.itemView.setBackgroundColor(android.R.color.white)
        }


        /*
        * if selected items list don't contain selected string
        *
        * 1. add it to selected item list
        * 2. change color of it
        *
        * */
        else{
            selectedItems.add(currentString)
            holder.itemView.setBackgroundColor(R.color.colorPrimary)
        }

    }

    override fun onCreateActionMode(mode: ActionMode?, menu: Menu?): Boolean {
        val inflater:MenuInflater = mode!!.menuInflater
        inflater.inflate(R.menu.appbar_contaxtmenu,menu)
        return true
    }

    override fun onPrepareActionMode(mode: ActionMode?, menu: Menu?): Boolean {
      return false
    }

    override fun onActionItemClicked(mode: ActionMode?, item: MenuItem?): Boolean {
       if (item!!.itemId == R.id.contextMenu_delete){
           deleteSelectedItems()
           Toast.makeText(mActivity,"selected String Deleted",Toast.LENGTH_SHORT).show()
           mode!!.finish()
       }

        return true
    }

    private fun deleteSelectedItems() {
        for (i in selectedItems){
            if (staticStringList.contains(i)){
                staticStringList.remove(i)
            }
        }
        notifyDataSetChanged()
    }

    override fun onDestroyActionMode(mode: ActionMode?) {
        multiSelect = false
        selectedItems.clear()
        notifyDataSetChanged()
    }

    fun filterList(list:ArrayList<String> ){
        stringList = list
        notifyDataSetChanged()
    }
}
