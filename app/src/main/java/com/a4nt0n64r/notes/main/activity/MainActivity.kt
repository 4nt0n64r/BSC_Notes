package com.a4nt0n64r.notes.main.activity

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import com.a4nt0n64r.notes.*
import com.a4nt0n64r.notes.about.AboutActivity
import com.a4nt0n64r.notes.databinding.ActivityMainBinding
import com.a4nt0n64r.notes.extentions.hideKeyboard
import com.a4nt0n64r.notes.main.fragments.list.ListFragment
import com.a4nt0n64r.notes.main.fragments.note.NoteFragment
import com.google.android.material.snackbar.Snackbar

/**
 *  Активити с простой реализацией сценария создания заметки, имеющую заголовок и обычный текст в качестве контента
 */
class MainActivity : AppCompatActivity(), MainActivityInterface {

    private lateinit var presenter: MainPresenter

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        presenter = MainPresenterImpl(this)

        showListFragment(null)
    }

    override fun showSnackBar(message: String) {
        this.hideKeyboard()
        Snackbar.make(binding.constraint, message, Snackbar.LENGTH_LONG).show()
    }



    /**
     * Функция для навигации между фрагментами
     *
     * @param destination строковая константа для фрагмента-назначения
     * @param bundle Бандл
     */
    fun navigate(destination: String, bundle: Bundle?) {
        when (destination) {
            LIST_FRAGMENT -> {
                showListFragment(bundle)
            }
            NOTE_FRAGMENT -> {
                showNoteFragment(bundle)
            }
        }
    }

    private fun showListFragment(bundle: Bundle?) {
        val listFragment = ListFragment()
        listFragment.arguments = bundle
        supportFragmentManager
            .beginTransaction()
            .replace(
                R.id.fragment_container,
                listFragment, LIST_FRAGMENT
            )
            .addToBackStack(BACKSTACK)
            .commit()
    }

    private fun showNoteFragment(bundle: Bundle?) {
        val listFragment = NoteFragment()
        listFragment.arguments = bundle
        supportFragmentManager
            .beginTransaction()
            .replace(
                R.id.fragment_container,
                listFragment, LIST_FRAGMENT
            )
            .addToBackStack(BACKSTACK)
            .commit()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        if (supportFragmentManager.backStackEntryCount == 0) {
            finish()
        }
    }

    override fun backClick() {
        supportFragmentManager.popBackStack()
    }
}
