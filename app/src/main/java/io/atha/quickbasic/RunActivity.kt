package io.atha.quickbasic

import android.graphics.Color
import android.graphics.Typeface
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.termux.shared.termux.terminal.TermuxTerminalSessionClientBase
import com.termux.terminal.TerminalSession
import com.termux.view.TerminalView
import io.atha.quickbasic.databinding.ActivityRunBinding
import java.io.Serializable

data class RunDatum(
    val src: String,
) : Serializable

class RunActivity : AppCompatActivity() {
    lateinit var binding: ActivityRunBinding
    lateinit var datum: RunDatum

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        datum = intent.getSerializableExtra("datum", RunDatum::class.java)!!
        binding = ActivityRunBinding.inflate(layoutInflater)

        binding.goBack.setOnClickListener {
            finish()
        }

        val client1 = object : TermuxTerminalSessionClientBase() {
            override fun onTextChanged(changedSession: TerminalSession) {
                super.onTextChanged(changedSession)
                binding.terminal.onScreenUpdated()
            }
        }
        val client2 = TermuxTerminalViewClient(this)

        val session = BabaTerminalSession(
            client1,
            this,
            datum,
        )

        binding.terminal.setBackgroundColor(Color.BLACK)
        binding.terminal.setTextSize(30)
        binding.terminal.setTypeface(Typeface.MONOSPACE)
        binding.terminal.attachSession(session)
        binding.terminal.setTerminalViewClient(client2)
        session.initializeEmulator(30, 10)
        setContentView(binding.root)
    }

    fun getTerminalView(): TerminalView = binding.terminal
    fun getCurrentSession(): TerminalSession? = binding.terminal.currentSession
    fun toggleTerminalToolbar() {
        TODO("Not yet implemented")
    }
}