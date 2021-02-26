package com.example.toolbar.multiselectInRecyclerView

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.appcompat.widget.Toolbar
import androidx.core.view.MenuItemCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.toolbar.R


/*http://findnerd.com/list/view/How-to-create-Contextual-action-mode-over-toolbar-using-recycler-view-in-android/26628/ */
/*https://heartbeat.fritz.ai/implementing-a-multi-select-recylerview-with-a-dynamic-actionbar-in-android-e36f16a47a1b */


class MultiSelectExample : AppCompatActivity() ,SearchView.OnQueryTextListener{


    lateinit var mToolbar: Toolbar

    companion object { lateinit var staticStringList: ArrayList<String> }

    lateinit var mRecyclerView:RecyclerView
    lateinit var mAdapter: RecyclerViewAdapter

  

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fifth)

        setToolbar()
        initView()
        showRecyclerView()
    }

    private fun setToolbar() {

        mToolbar = findViewById(R.id.toolbar)
        setSupportActionBar(mToolbar)
    }

    private fun showRecyclerView() {
        staticStringList = data()
        mAdapter = RecyclerViewAdapter(this, staticStringList)
        mRecyclerView.adapter = mAdapter
        mAdapter.notifyDataSetChanged()
    }

    private fun initView() {
        mRecyclerView =  findViewById(R.id.fifth_recyclerView)
        mRecyclerView.apply {
            mRecyclerView.hasFixedSize()
            mRecyclerView.layoutManager = LinearLayoutManager(applicationContext)
        }

    }

    private fun data():ArrayList<String>{
        val stringList = ArrayList<String>()
        for (i in 0..101){
            stringList.add("item no $i")
        }

        return stringList
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        super.onCreateOptionsMenu(menu)
        menuInflater.inflate(R.menu.appbar_individual_actionmode, menu)

        val searchViewItem: MenuItem = menu!!.findItem(R.id.fourthMenuSearch)
        val searchView: SearchView = MenuItemCompat.getActionView(searchViewItem) as SearchView

        searchView.setOnQueryTextListener(this)
        return true
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        return false
    }

    override fun onQueryTextChange(newText: String?): Boolean {
       filter(newText!!)
        return true
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