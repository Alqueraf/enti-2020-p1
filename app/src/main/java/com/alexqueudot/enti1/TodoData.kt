package com.alexqueudot.enti1

/**
 * Created by alex on 16/10/2020.
 */

object TodoData {
    val todoList: MutableList<TodoModel> = mutableListOf(
        TodoModel(id = 10, text = "Lavar la ropa", isCompleted = false),
        TodoModel(id = 11, text = "Hacer la compra", isCompleted = true),
        TodoModel(id = 12, text = "Fregar platos", isCompleted = false),
    )
}