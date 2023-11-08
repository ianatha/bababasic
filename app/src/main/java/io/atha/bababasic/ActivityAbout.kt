package io.atha.bababasic

import android.content.Intent
import android.content.pm.PackageInfo
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import io.atha.bababasic.databinding.ActivityAboutBinding

class ActivityAbout : AppCompatActivity() {
    private lateinit var binding: ActivityAboutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAboutBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val pInfo: PackageInfo = this.packageManager.getPackageInfo(this.packageName, 0)

        binding.version.text = "v${pInfo.versionName} (${pInfo.versionCode})"

        binding.okButton.setOnClickListener {
            finish()
        }

        binding.githubLink.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("https://github.com/ianatha/bababasic")
            startActivity(intent)
        }
    }
}