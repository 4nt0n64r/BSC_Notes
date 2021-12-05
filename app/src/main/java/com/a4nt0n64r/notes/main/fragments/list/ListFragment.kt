package com.a4nt0n64r.notes.main.fragments.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.a4nt0n64r.notes.*
import com.a4nt0n64r.notes.databinding.FragmentListBinding
import com.a4nt0n64r.notes.main.MainActivity
import com.a4nt0n64r.notes.main.models.NoteUI

/**
 * Экран со списком заметок
 */
class ListFragment : Fragment(), ListView {

    lateinit var binding: FragmentListBinding

    private lateinit var presenter: ListPresenter

    lateinit var adapter: NotesAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentListBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        presenter = ListPresenterImpl(this)

        setupRecyclerView()
        presenter.getNotes()

        binding.noteList.addItemDecoration(
            MarginItemDecoration(resources.getDimensionPixelSize(R.dimen.app_margin_8dp))
        )
    }

    private fun setupRecyclerView() {
        adapter = NotesAdapter { note -> noteClick(note) }
        binding.noteList.layoutManager = LinearLayoutManager(context)
        binding.noteList.adapter = adapter
    }

    override fun setupNotesList(listOfNotes: List<NoteUI>) {
        adapter.submitList(listOfNotes)
    }

    private fun noteClick(note: NoteUI) {
        presenter.noteClicked(note)
    }

    override fun navigateToNoteInfo(note: NoteUI) {
        (activity as MainActivity).navigate(
            NOTE_FRAGMENT,
            Bundle().apply { this.putSerializable(NOTE_ITEM_BUNDLE, note) })
    }
}
