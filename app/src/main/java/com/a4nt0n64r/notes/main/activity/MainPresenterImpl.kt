package com.a4nt0n64r.notes.main.activity

import com.a4nt0n64r.notes.MainActivityInterface
import com.a4nt0n64r.notes.MainPresenter

/**
 * Презентер
 *
 * @param view Активити
 */
class MainPresenterImpl(private val view: MainActivityInterface) : MainPresenter {
    override fun saveClicked(message:String) {
        view.showSnackBar(message)
    }
}
