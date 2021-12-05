package com.a4nt0n64r.notes.about

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.a4nt0n64r.notes.BuildConfig
import com.a4nt0n64r.notes.databinding.ActivityAboutBinding

/**
 * Активити с информацией о приложении
 */
class AboutActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAboutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAboutBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()
        binding.version.text = BuildConfig.VERSION_NAME
    }
}
