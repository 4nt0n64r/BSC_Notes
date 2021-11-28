package com.a4nt0n64r.notes

// Интерфейс для вью
interface ViewInterface {
    fun showSnackBar(message: String)
    fun trySendYoutubeIntent(query: String)
}

// Интерфейс для презентера
interface MainPresenter {
    fun saveClicked()
    fun searchClicked(query: String)
}
