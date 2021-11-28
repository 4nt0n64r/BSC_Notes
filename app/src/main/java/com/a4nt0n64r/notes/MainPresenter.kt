package com.a4nt0n64r.notes

/**
 * Презентер
 * @param view  - Активити
 */
class MainPresenterImpl(private val view: ViewInterface) : MainPresenter {
    override fun saveClicked() {
        view.showSnackBar("Success")
    }

    override fun searchClicked(query: String) {
        view.trySendYoutubeIntent(query)
    }
}
