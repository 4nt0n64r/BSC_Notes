package com.a4nt0n64r.notes.main.fragments.note

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.a4nt0n64r.notes.MainActivityInterface
import com.a4nt0n64r.notes.NOTE_ITEM_BUNDLE
import com.a4nt0n64r.notes.NotePresenter
import com.a4nt0n64r.notes.NoteView
import com.a4nt0n64r.notes.databinding.FragmentNoteBinding
import com.a4nt0n64r.notes.main.models.NoteUI

/**
 * Экран с информацией о заметке
 */
class NoteFragment : Fragment(), NoteView {

    lateinit var binding: FragmentNoteBinding

    private lateinit var presenter: NotePresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNoteBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        presenter = NotePresenterImpl(this)

        if (this.arguments != null) {
            presenter.setNote(this.requireArguments().getSerializable(NOTE_ITEM_BUNDLE) as NoteUI)
        }

        binding.back.setOnClickListener {
            presenter.backClicked()
        }
    }

    override fun backClicked() {
        (activity as MainActivityInterface).backClick()
    }

    override fun showNote(note: NoteUI) {
        binding.noteHeader.text = note.header
        binding.noteText.text = note.text
        binding.noteDate.text = note.date
    }
}
