package com.a4nt0n64r.notes.main.fragments.note

import com.a4nt0n64r.notes.NotePresenter
import com.a4nt0n64r.notes.NoteView
import com.a4nt0n64r.notes.main.models.NoteUI

/**
 * Презентер для экрана с информацией о заметке
 *
 * @param view - Экран с информацией о заметке
 */
class NotePresenterImpl(private val view: NoteView) : NotePresenter {

    override fun backClicked() {
        view.backClicked()
    }

    override fun setNote(note: NoteUI) {
        view.showNote(note)
    }
}