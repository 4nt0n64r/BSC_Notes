package com.a4nt0n64r.notes.main.fragments.note

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.a4nt0n64r.notes.*
import com.a4nt0n64r.notes.databinding.FragmentNoteBinding
import com.a4nt0n64r.notes.main.models.NoteUI

/**
 * Экран с информацией о заметке
 */
class NoteFragment : Fragment(), NoteView {

    private var binding: FragmentNoteBinding? = null

    private var presenter: NotePresenter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNoteBinding.inflate(layoutInflater)
        return binding.let { it?.root }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        presenter = NotePresenterImpl(this)

        if (this.arguments != null) {
            presenter?.setNote(this.requireArguments().getSerializable(NOTE_ITEM_BUNDLE) as NoteUI)
        }

        binding.let {
            it?.back?.setOnClickListener {
                presenter?.backClicked()
            }
        }

        binding.let {
            it?.save?.setOnClickListener {
                presenter?.saveClicked(
                    NoteUI(
                        binding?.noteHeader?.text.toString(),
                        binding?.noteText?.text.toString(),
                        binding?.noteDate?.text.toString()
                    )
                )
            }
        }

        binding.let {
            it?.search?.setOnClickListener {
                presenter?.searchClicked(
                    NoteUI(
                        binding?.noteHeader?.text.toString(),
                        binding?.noteText?.text.toString(),
                        binding?.noteDate?.text.toString()
                    )
                )
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
        presenter = null
    }

    override fun saveNote(note: NoteUI) {
        Log.d(NOTE_SAVING, note.toString())
        (activity as MainActivityInterface).showSnackBar(getString(R.string.success))
    }

    override fun trySendYoutubeIntent(query: String) {
        try {
            val intent = Intent(Intent.ACTION_SEARCH)
            intent.setPackage("com.google.android.youtube")
            intent.putExtra("query", query)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
        } catch (e: Exception) {
            (activity as MainActivityInterface).showSnackBar(e.message ?: getString(R.string.error))
        }
    }

    override fun backClicked() {
        (activity as MainActivityInterface).backClick()
    }

    override fun showNote(note: NoteUI) {
        binding.let {
            it?.noteHeader?.setText(note.header)
            it?.noteText?.setText(note.text)
            it?.noteDate?.setText(note.date)
        }
    }
}
