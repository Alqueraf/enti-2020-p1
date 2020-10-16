package com.alexqueudot.enti1

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_todo_detail.*

class TodoDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_todo_detail)

        // Get noteText from Intent
        val notePosition: Int = intent.getIntExtra("position", 0)
        // Get from TodoData. Set Note Text
        noteEditText.setText(TodoData.todoList[notePosition])

        saveNoteButton.setOnClickListener {
            // 0: Set new text to TodoData
            TodoData.todoList[notePosition] = noteEditText.text.toString()
            // 1: Set new note text to ListActivity
            setResult(Activity.RESULT_OK)
            // 2: Close
            finish()
        }
    }

}