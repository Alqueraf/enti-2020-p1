package com.alexqueudot.enti1

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_todo.view.*

/**
 * Created by alex on 16/10/2020.
 */

class TodoAdapter(var todoItems: List<TodoModel>, private val activity: Activity) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    // Max notes: 100
    override fun getItemCount(): Int {
        return todoItems.size
    }

    // Max screen: 10
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_todo, parent, false)
        return TodoViewHolder(itemView)
    }

    // Update
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = todoItems[position]
        // Set Text
        holder.itemView.noteTextView.text = item.text
        // Set Completed
        holder.itemView.completedCheckBox.isChecked = item.isCompleted
        // Set Click Listener
        holder.itemView.noteCardView.setOnClickListener { view ->
            // Open Note1 Detail
            val intent = Intent(view.context, TodoDetailActivity::class.java)
            intent.putExtra("id", item.id)
            // 1: Open for Result
            activity.startActivityForResult(intent, 100)
        }
    }

    // View
    inner class TodoViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    }

}