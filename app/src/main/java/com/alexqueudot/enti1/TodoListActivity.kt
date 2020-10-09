package com.alexqueudot.enti1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_todo_list.*

class TodoListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_todo_list)




        note1CardView.setOnClickListener {
            // Open Note1 Detail
            val intent = Intent(this, TodoDetailActivity::class.java)
            intent.putExtra("noteText", note1TextView.text)
            startActivity(intent)
        }


        note2CardView.setOnClickListener {
            // Open Note2 Detail
            val intent = Intent(this, TodoDetailActivity::class.java)
            intent.putExtra("noteText", note2TextView.text)
            startActivity(intent)
        }
    }
}