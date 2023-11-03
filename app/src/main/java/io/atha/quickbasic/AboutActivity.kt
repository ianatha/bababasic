package io.atha.quickbasic

import android.content.pm.PackageInfo
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import io.atha.quickbasic.databinding.ActivityAboutBinding

class AboutActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAboutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAboutBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val pInfo: PackageInfo = this.packageManager.getPackageInfo(this.packageName, 0)

        binding.version.text = "v${pInfo.versionName} (${pInfo.versionCode})"

        binding.logo2.setOnClickListener {
            throw RuntimeException("Crash by clicking on logo!")
        }

        binding.okButton.setOnClickListener {
            finish()
        }
    }
}