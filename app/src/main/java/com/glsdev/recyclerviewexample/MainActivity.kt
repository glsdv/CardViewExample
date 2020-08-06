package com.glsdev.recyclerviewexample

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity(), MyAdapter.ItemClickListener {
    lateinit var adapter: MyAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val persons: ArrayList<String> = ArrayList()
        persons.add("Horse")
        persons.add("Cow")
        persons.add("Camel")
        persons.add("Sheep")
        persons.add("Goat")

        val recyclerView: RecyclerView = findViewById(R.id.list)
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = MyAdapter(this, persons)
        adapter.setClickListener(this)
        recyclerView.adapter = adapter
    }

    override fun onItemClick(view: View?, position: Int) {
        Toast.makeText(
            this,
            "You clicked " + adapter.getItem(position).toString() + " on row number " + position,
            Toast.LENGTH_SHORT
        ).show()
    }


}