package com.alexqueudot.enti1

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_todo_detail.*

class TodoDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_todo_detail)

        // Get noteText from Intent
        val noteId: Int = intent.getIntExtra("id", 0)
        val noteList = TodoService(this).getTodos()
        val note: TodoModel? = noteList.firstOrNull { todoModel ->
            todoModel.id == noteId
        }
        // Get from TodoData. Set Note Text
        noteEditText.setText(note?.text)

        saveNoteButton.setOnClickListener { view: View ->
            note?.let { note ->
                // 0: Set new text to TodoModel
                val updatedNote = note.copy(text = noteEditText.text.toString())
                TodoService(this).saveTodo(updatedNote)
                // 1: Set new note text to ListActivity
                setResult(Activity.RESULT_OK)
                // 2: Close
                finish()
            }
        }
    }

}