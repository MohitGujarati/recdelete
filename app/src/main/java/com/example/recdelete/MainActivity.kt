package com.example.recdelete

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var adapter: ItemAdapter

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView=findViewById<RecyclerView>(R.id.review)
        val btninsert=findViewById<Button>(R.id.btninsert)
        recyclerView.layoutManager = LinearLayoutManager(this)
        loadreciew(recyclerView)
    }

    private fun loadreciew(recyclerView: RecyclerView) {
        val items = listOf(
           model("hellow"),
           model("hellow"),
           model("hellow")
        )
        adapter = ItemAdapter(items)
        recyclerView.adapter = adapter

        val btnInsert: Button = findViewById(R.id.btninsert)
        btnInsert.setOnClickListener {
            if (adapter.isEditing) {
                btnInsert.text = "Edit"
                adapter.toggleEditing()
            } else {
                btnInsert.text = "Done"
                adapter.toggleEditing()
            }
        }
        checkListEmpty(btnInsert)
    }

    private fun checkListEmpty(btnInsert: Button) {
        if (adapter.itemCount == 0) {
            btnInsert.visibility = View.GONE
        } else {
            btnInsert.visibility = View.VISIBLE
        }
    }
}