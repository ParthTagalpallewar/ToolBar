package com.example.toolbar.searchView.simpleSearchView

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.toolbar.R
import com.example.toolbar.contextualActionMode.forMultipleVisualViews.firstMethod.RecyclerViewAdapter

class SearchViewExample : AppCompatActivity(),SearchView.OnQueryTextListener {
    lateinit var mToolbar: Toolbar
    lateinit var mSearchView:SearchView

    companion object { lateinit var staticStringList: ArrayList<String> }

    lateinit var mRecyclerView: RecyclerView
    lateinit var mAdapter: SearchViewAdapter



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_view_example)
        mToolbar = findViewById(R.id.toolbar)
        setToolbar()
        initView()
        showRecyclerView()
        setUpSearchView()


    }

    private fun setUpSearchView() {
        mSearchView = findViewById(R.id.searchView)
        mSearchView.setOnQueryTextListener(this)
    }

    private fun setToolbar() {

        setSupportActionBar(mToolbar)
    }

    private fun showRecyclerView() {
        staticStringList = data()
        mAdapter = SearchViewAdapter( staticStringList)
        mRecyclerView.adapter = mAdapter
        mAdapter.notifyDataSetChanged()
    }

    private fun initView() {
        mRecyclerView = findViewById(R.id.fifth_recyclerView)
        mRecyclerView.hasFixedSize()
        mRecyclerView.layoutManager = LinearLayoutManager(applicationContext)
    }

    private fun data():ArrayList<String>{
        val stringList = ArrayList<String>()
        for (i in 0..101){
            stringList.add("item no $i")
        }

        return stringList
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        if (staticStringList.contains(query)){
            filter(query!!)
        }else{
            Toast.makeText(applicationContext,"$query not found",Toast.LENGTH_SHORT).show()
        }

        return false
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        val query = newText
        if (staticStringList.contains(query)){
            filter(query!!)
        }else{
            Toast.makeText(applicationContext,"$query not found",Toast.LENGTH_SHORT).show()
        }
        return false
    }

    private fun filter(text: String) {
        val filteredList: ArrayList<String> = ArrayList()
        for (item in staticStringList) {
            if (item.toLowerCase().contains(text.toLowerCase())) {
                filteredList.add(item)
            }
        }
        mAdapter.filterList(filteredList)
    }
}