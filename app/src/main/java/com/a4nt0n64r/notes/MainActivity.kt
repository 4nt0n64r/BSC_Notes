package com.a4nt0n64r.notes

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import com.a4nt0n64r.notes.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

/**
 *  Активити с простой реализацией сценария создания заметки, имеющую заголовок и обычный текст в качестве контента
 */
class MainActivity : AppCompatActivity(), ViewInterface {

    private lateinit var presenter: MainPresenter

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        presenter = MainPresenterImpl(this)
    }

    override fun showSnackBar() {
        this.hideKeyboard()
        Snackbar.make(binding.constraint, getString(R.string.success), Snackbar.LENGTH_LONG).show()
    }

    override fun onResume() {
        super.onResume()
        binding.save.setOnClickListener {
            if (binding.header.text.toString().trim() != "" && binding.body.text.toString().trim() != ""){
                presenter.saveClicked()
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun Activity.hideKeyboard() {
        hideKeyboard(currentFocus ?: View(this))
    }

    private fun Context.hideKeyboard(view: View) {
        val inputMethodManager = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }
}
