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
            val nextId = getNextTodoId()
            // 4: Save to TodoData list
            TodoService(this).saveTodo(TodoModel(text = todoText, id = nextId))
            // Set Result
            setResult(Activity.RESULT_OK)
            finish()
        }
    }

    private fun getNextTodoId(): Int {
        val notes = TodoService(this).getTodos()
        return (notes.lastOrNull()?.id ?: 0) + 1
    }

}