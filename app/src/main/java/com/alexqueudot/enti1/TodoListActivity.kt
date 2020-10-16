package com.alexqueudot.enti1

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_todo_list.*

class TodoListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_todo_list)
        // Init Recyclerview
        initRecyclerView()
    }

    private fun initRecyclerView() {
        // 1: Layout Manager
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        // 2: Adapter
        recyclerView.adapter = TodoAdapter(TodoData.todoList, this)
    }

    // 3: Get Result
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if(requestCode == 100 && resultCode == Activity.RESULT_OK) {
            recyclerView.adapter?.notifyDataSetChanged()
        } else {
            super.onActivityResult(requestCode, resultCode, data)
        }
    }
}