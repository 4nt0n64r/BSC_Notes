package com.a4nt0n64r.notes.main.fragments.list

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.a4nt0n64r.notes.*
import com.a4nt0n64r.notes.about.AboutActivity
import com.a4nt0n64r.notes.databinding.FragmentListBinding
import com.a4nt0n64r.notes.main.activity.MainActivity
import com.a4nt0n64r.notes.main.models.NoteUI

/**
 * Экран со списком заметок
 */
class ListFragment : Fragment(), ListView {

    private var _binding: FragmentListBinding? = null
    private val binding get() = _binding!!

    private var presenter: ListPresenter? = null

    lateinit var adapter: NotesAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentListBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        presenter = ListPresenterImpl(this)

        setupRecyclerView()
        presenter?.getNotes()

        binding.noteList.addItemDecoration(
            MarginItemDecoration(resources.getDimensionPixelSize(R.dimen.app_margin_8dp))
        )

        binding.about.setOnClickListener {
            openAboutActivity()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
        presenter = null
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
        presenter?.noteClicked(note)
    }

    private fun openAboutActivity() {
        startActivity(Intent(requireContext(), AboutActivity::class.java))
    }

    override fun navigateToNoteInfo(note: NoteUI) {
        (activity as MainActivity).navigate(
            NOTE_FRAGMENT,
            Bundle().apply { this.putSerializable(NOTE_ITEM_BUNDLE, note) })
    }
}
