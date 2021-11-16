package com.a4nt0n64r.notes

class MainPresenterImpl(private val view: ViewInterface): MainPresenter {
    override fun saveClicked() {
        view.showSnackBar()
    }
}

interface ViewInterface {
    fun showSnackBar()
}

interface MainPresenter {
    fun saveClicked()
}
