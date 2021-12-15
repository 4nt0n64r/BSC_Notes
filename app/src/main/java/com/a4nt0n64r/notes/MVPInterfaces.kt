package com.a4nt0n64r.notes

import com.a4nt0n64r.notes.main.models.NoteUI

/**
 *  Интерфейс для MainActivity
 */
interface MainActivityInterface {
    /**
     *  Показ Snackbar
     *
     *  @param message сообщение
     */
    fun showSnackBar(message: String)

    /**
     *  Обработка клика назад
     */
    fun backClick()
}

/**
 * Интерфейс для презентера MainActivity
 */
interface MainPresenter {
    /**
     *  Обработка клика на кнопку "Save"
     *
     *  @param message сообщение
     */
    fun saveClicked(message: String)
}

/**
 * Интерфейс для презентера ListFragment
 */
interface ListPresenter {
    /**
     *  Обработка клика на заметку
     *
     *  @param note заметка
     */
    fun noteClicked(note: NoteUI)

    /**
     *  Получить список заметок
     */
    fun getNotes()
}

/**
 * Интерфейс для фрагмента ListFragment
 */
interface ListView {
    /**
     *  Показать экран с информацией о заметке
     *
     *  @param note заметка
     */
    fun navigateToNoteInfo(note: NoteUI)

    /**
     *  Заполнение RecyclerView списком заметок
     *
     *  @param listOfNotes список заметок
     */
    fun setupNotesList(listOfNotes: List<NoteUI>)
}

/**
 * Интерфейс для презентера NoteFragment
 */
interface NotePresenter {
    /**
     *  Обработка клика назад
     */
    fun backClicked()

    /**
     *  Установка заметки в презентер
     *
     *  @param note заметка
     */
    fun setNote(note: NoteUI)

    /**
     *  Обработка клика на кнопку "Search"
     *
     *  @param note заметка
     */
    fun searchClicked(note: NoteUI)

    /**
     *  Обработка клика на кнопку "Save"
     *
     *  @param note заметка
     */
    fun saveClicked(note: NoteUI)
}

/**
 * Интерфейс для NoteFragment
 */
interface NoteView {
    /**
     *  Обработка клика назад
     */
    fun backClicked()

    /**
     *  Отображение заметки
     *
     *  @param note заметка
     */
    fun showNote(note: NoteUI)

    /**
     *  Сохранение заметки
     *
     *  @param note заметка
     */
    fun saveNote(note: NoteUI)

    /**
     *  Пробуем поискать заметку на YouTube, если не выходит показываем Snackbar с сообщением
     *  ошибки
     *
     *  @param query текст для поиска
     */
    fun trySendYoutubeIntent(query: String)
}
