package com.example.quizapp

import android.content.DialogInterface.OnClickListener
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.quizapp.databinding.QuizitemsBinding


class Adapter(private val clickListener: (Quiz) -> Unit)  : ListAdapter<Quiz, Adapter.ViewHolder>(
    QuizDiffCallback()
) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val binding=QuizitemsBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val quiz = getItem(position)
        holder.bind(quiz)
    }

    inner class ViewHolder(private val binding:QuizitemsBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(quiz: Quiz) {
            binding.textview.text=quiz.name
            binding.imageview.setImageResource(quiz.id)
            binding.cardview.setOnClickListener{
                clickListener(quiz)
            }
        }
    }
}

class QuizDiffCallback : DiffUtil.ItemCallback<Quiz>() {
    override fun areItemsTheSame(oldItem: Quiz, newItem: Quiz): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Quiz, newItem: Quiz): Boolean {
        return oldItem == newItem
    }
}


