package com.a4nt0n64r.notes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.a4nt0n64r.notes.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

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
        Snackbar.make(binding.constraint, "Success", Snackbar.LENGTH_LONG).show()
    }

    override fun onResume() {
        super.onResume()
        binding.save.setOnClickListener {
            presenter.saveClicked()
        }
    }
}
