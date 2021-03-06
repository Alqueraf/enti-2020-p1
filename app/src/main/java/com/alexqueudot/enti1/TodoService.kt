package com.alexqueudot.enti1

import android.content.Context
import android.content.SharedPreferences
import com.beust.klaxon.Klaxon

/**
 * Created by alex on 16/10/2020.
 */

class TodoService(private val context: Context) {

    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences("localData", Context.MODE_PRIVATE)

    fun getTodos(): List<TodoModel> {
        // 1 - Get JSON
        val json: String = sharedPreferences.getString("todoList", null) ?: "[]"
        // 2 - Parse to TodoModel
        val todoList = Klaxon().parseArray<TodoModel>(json).orEmpty()
        return todoList.sortedBy { it.id }
    }

    fun saveTodos(list: List<TodoModel>) {
        // 1 - Convert to JSON
        val listJson = Klaxon().toJsonString(list)
        // 2 - Save JSON
        val editor = sharedPreferences.edit()
        editor.putString("todoList", listJson)
        editor.apply()
    }

    fun saveTodo(item: TodoModel) {
        val todoList = getTodos().toMutableList()
        // Check if id exists
        todoList.firstOrNull { it.id == item.id }?.let {
            todoList.remove(it)
        }
        // Add new item
        todoList.add(item)
        saveTodos(todoList)
    }
}

//object TodoData {
//
//    val todoList: MutableList<TodoModel> = mutableListOf(
//        TodoModel(id = 10, text = "Lavar la ropa", isCompleted = false),
//        TodoModel(id = 11, text = "Hacer la compra", isCompleted = true),
//        TodoModel(id = 12, text = "Fregar platos", isCompleted = false),
//    )

    /**
     * JSON Version
     *
    [
    {
    "id": 10,
    "text": "Lavar la ropa",
    "isCompleted": false
    },
    {
    "id": 11,
    "text": "Hacer la compra",
    "isCompleted": true
    },
    {
    "id": 12,
    "text": "Fregar",
    "isCompleted": false
    }
    ]
     */
//}
