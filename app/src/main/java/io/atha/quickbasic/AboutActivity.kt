package io.atha.quickbasic

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import io.atha.quickbasic.databinding.ActivityAboutBinding

class AboutActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAboutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAboutBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.okButton.setOnClickListener {
            finish()
        }
    }
}