package com.a4nt0n64r.notes

// Интерфейс для вью
interface ViewInterface {
    /**
     *  Показ Snackbar-а
     *
     *  @param message - сообщение
     */
    fun showSnackBar(message: String)

    /**
     *  Пробуем поискать заметку на YouTube, если не выходит - показываем Snackbar с сообщением
     *  ошибки
     *
     *  @param query - Текст для поиска
     */
    fun trySendYoutubeIntent(query: String)
}

// Интерфейс для презентера
interface MainPresenter {
    /**
     *  Обработка клика на кнопку "Save"
     *
     *  @param message - сообщение
     */
    fun saveClicked(message:String)

    /**
     *  Обработка клика на кнопку "Search"
     *
     *  @param query - сообщение
     */
    fun searchClicked(query: String)
}
