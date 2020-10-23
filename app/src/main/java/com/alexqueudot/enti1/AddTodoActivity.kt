package com.alexqueudot.enti1

import android.app.Activity
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_add_todo.*

class AddTodoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_todo)

        // 3: Set Text + Save Button
        addTodoButton.setOnClickListener {
            // Read note text
            val todoText = addTodoEditText.text.toString()
            val nextId = (TodoData.todoList.lastOrNull()?.id ?: 0) + 1
            // 4: Save to TodoData list
            TodoData.todoList.add(TodoModel(text = todoText, id = nextId))

            // Set Result
            setResult(Activity.RESULT_OK)
            finish()
        }
    }
}