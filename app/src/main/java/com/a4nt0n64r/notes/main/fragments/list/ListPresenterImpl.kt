package com.a4nt0n64r.notes.main.fragments.list

import com.a4nt0n64r.notes.ListPresenter
import com.a4nt0n64r.notes.ListView
import com.a4nt0n64r.notes.main.models.NoteUI

/**
 * Презентер для экрана списка заметок
 *
 * @param view  - Экран списка заметок
 */
class ListPresenterImpl(private val view: ListView) : ListPresenter {

    private val notesList = listOf<NoteUI>(
        NoteUI("Header 1", "Text text text 1", "23.11.12"),
        NoteUI("Header 2", "Text text text 2", "12.11.12"),
        NoteUI("Header 3", "Text text text 3", "22.11.12"),
        NoteUI("Header 4", "Text text text 4", "31.12.14"),
        NoteUI("Header 5", "Text text text 5", "11.11.11"),
        NoteUI("Header 6", "Text text text 6", "5.4.04"),
        NoteUI("Header 7", "Text text text 7", "7.7.19"),
        NoteUI("Header 8", "Text text text 8", "9.9.09"),
        NoteUI("Header 9", "Text text text 9", "8.8.08"),
        NoteUI("Header 10", "Text text text 10", "21.12.12")
    )

    override fun noteClicked(note: NoteUI) {
        view.navigateToNoteInfo(note)
    }

    override fun getNotes() {
        view.setupNotesList(notesList)
    }
}