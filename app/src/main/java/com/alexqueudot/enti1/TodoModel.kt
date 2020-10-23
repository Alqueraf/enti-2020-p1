package com.alexqueudot.enti1

/**
 * Created by alex on 23/10/2020.
 */

data class TodoModel(
    val id: Int,
    val text: String,
    val isCompleted: Boolean = false,
)