package com.example.recdelete

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ItemAdapter(private val items: List<model>) : RecyclerView.Adapter<ItemAdapter.ViewHolder>() {

    var isEditing: Boolean = false

    fun toggleEditing() {
        isEditing = !isEditing
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.itemrec, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.nameTextView.text = item.username
        holder.deleteTextView.visibility = if (isEditing) View.VISIBLE else View.GONE
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nameTextView: TextView = view.findViewById(R.id.name)
        val deleteTextView: TextView = view.findViewById(R.id.delete)
    }
}

