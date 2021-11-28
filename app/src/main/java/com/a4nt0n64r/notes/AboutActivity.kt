package com.a4nt0n64r.notes

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.a4nt0n64r.notes.databinding.ActivityAboutBinding

/**
 * Активити с информацией о приложении
 */
class AboutActivity : AppCompatActivity() {

    private var _binding: ActivityAboutBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityAboutBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()
        binding.version.text = BuildConfig.VERSION_NAME
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}