package com.a4nt0n64r.notes

// Имплементация презентера
class MainPresenterImpl(private val view: ViewInterface): MainPresenter {
    override fun saveClicked() {
        view.showSnackBar()
    }
}

// Интерфейс для вью
interface ViewInterface {
    fun showSnackBar()
}

// Интерфейс для презентера
interface MainPresenter {
    fun saveClicked()
}
