package com.a4nt0n64r.notes

import android.app.Activity
import android.content.Context
import android.content.Intent
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

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        presenter = MainPresenterImpl(this)
    }

    override fun showSnackBar(message: String) {
        this.hideKeyboard()
        Snackbar.make(binding.constraint, message, Snackbar.LENGTH_LONG).show()
    }

    override fun trySendYoutubeIntent(query: String) {
        try {
            val intent = Intent(Intent.ACTION_SEARCH)
            intent.setPackage("com.google.android.youtube")
            intent.putExtra("query", query)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
        } catch (e: Exception) {
            showSnackBar(e.message ?: getString(R.string.error))
        }
    }

    private fun openAboutActivity() {
        startActivity(Intent(this, AboutActivity::class.java))
    }

    override fun onResume() {
        super.onResume()
        binding.save.setOnClickListener {
            if (binding.header.text.toString().trim().isNotEmpty() && binding.body.text.toString()
                    .trim().isNotEmpty()
            ) {
                presenter.saveClicked(getString(R.string.success))
            }
        }
        binding.about.setOnClickListener {
            openAboutActivity()
        }
        binding.share.setOnClickListener {
            presenter.searchClicked(
                binding.header.text.toString() +
                        " " +
                        binding.body.text.toString()
            )
        }
    }

    private fun Activity.hideKeyboard() {
        hideKeyboard(currentFocus ?: View(this))
    }

    private fun Context.hideKeyboard(view: View) {
        val inputMethodManager =
            getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }
}
