package io.atha.quickbasic

import android.graphics.Color
import android.graphics.Typeface
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.termux.shared.termux.terminal.TermuxTerminalSessionClientBase
import com.termux.terminal.TerminalSession
import com.termux.view.TerminalView
import io.atha.quickbasic.databinding.ActivityRunBinding
import io.atha.quickbasic.terminal.BabaTerminalSession
import io.atha.quickbasic.terminal.TermuxTerminalViewClient
import java.io.Serializable

data class RunDatum(
    val src: String,
) : Serializable

class RunActivity : AppCompatActivity() {
    private lateinit var viewClient: TermuxTerminalViewClient
    private lateinit var mPreferences: AppSharedPreferences
    lateinit var binding: ActivityRunBinding
    private lateinit var datum: RunDatum
    private lateinit var session: BabaTerminalSession

    fun getPreferences(): AppSharedPreferences {
        return mPreferences
    }

    override fun onResume() {
        super.onResume()
        viewClient.onResume()
    }

    override fun onStart() {
        super.onStart()
        viewClient.onStart()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mPreferences = AppSharedPreferences.build(this, true)
        datum = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getSerializableExtra("datum", RunDatum::class.java)!!
        } else {
            @Suppress("DEPRECATION")
            intent.getSerializableExtra("datum") as RunDatum
        }
        binding = ActivityRunBinding.inflate(layoutInflater)

        binding.goBack.setOnClickListener {
            session.finishIfRunning()
            finish()
        }

        binding.stop.setOnClickListener {
            session.finishIfRunning()
        }

        val client1 = object : TermuxTerminalSessionClientBase() {
            override fun onTextChanged(changedSession: TerminalSession) {
                super.onTextChanged(changedSession)
                binding.terminal.onScreenUpdated()
            }

            override fun onSessionFinished(finishedSession: TerminalSession) {
                super.onSessionFinished(finishedSession)
                binding.stop.isEnabled = false
            }
        }
        viewClient = TermuxTerminalViewClient(this)

        session = BabaTerminalSession(
            client1,
            this,
            datum,
        )

        binding.terminal.setBackgroundColor(Color.BLACK)
        binding.terminal.setTextSize(30)
        binding.terminal.setTypeface(Typeface.MONOSPACE)
        binding.terminal.attachSession(session)
        binding.terminal.setTerminalViewClient(viewClient)
        session.initializeEmulator(30, 10)
        setContentView(binding.root)
        viewClient.onCreate()
    }

    fun getTerminalView(): TerminalView = binding.terminal
    fun getCurrentSession(): TerminalSession? = binding.terminal.currentSession
    fun toggleTerminalToolbar() {
        TODO("Not yet implemented")
    }

    fun isActivityRecreated(): Boolean {
        // TODO
        return false
    }
}