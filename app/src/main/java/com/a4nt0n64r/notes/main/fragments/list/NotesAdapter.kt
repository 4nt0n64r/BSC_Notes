package com.a4nt0n64r.notes.main.fragments.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.a4nt0n64r.notes.R
import com.a4nt0n64r.notes.databinding.NoteItemBinding
import com.a4nt0n64r.notes.main.models.NoteUI

/**
 * Адаптер для списка заметок
 *
 * @param noteClick - функция действия по клику на карточку заметки
 */
class NotesAdapter(private val noteClick: (NoteUI) -> Unit) :
    ListAdapter<NoteUI, NotesAdapter.ItemViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.note_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = NoteItemBinding.bind(itemView)
        fun bind(item: NoteUI) = with(itemView) {
            binding.header.text = item.header

            setOnClickListener {
                noteClick.invoke(item)
            }
        }
    }
}

class DiffCallback : DiffUtil.ItemCallback<NoteUI>() {

    override fun areItemsTheSame(oldItem: NoteUI, newItem: NoteUI): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: NoteUI, newItem: NoteUI): Boolean {
        return oldItem == newItem
    }
}
