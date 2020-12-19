package com.example.toolbar.searchView.simpleSearchView

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.toolbar.R
import kotlinx.android.synthetic.main.item_recyclerview.view.*


class SearchViewAdapter( private var stringList:ArrayList<String>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_recyclerview, null, false)
        return ViewHolder(view)
    }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        val currentString = stringList[position]
        holder.itemView.item_tv.text = currentString

    }

    override fun getItemCount() = stringList.size
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    fun filterList(list:ArrayList<String>){
        stringList = list
        notifyDataSetChanged()
    }

}