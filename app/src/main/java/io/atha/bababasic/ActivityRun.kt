package io.atha.bababasic

import android.graphics.Color
import android.graphics.Typeface
import android.os.Build
import android.os.Bundle
import android.view.KeyEvent
import androidx.appcompat.app.AppCompatActivity
import com.termux.terminal.TerminalSession
import com.termux.terminal.TerminalSessionClient
import com.termux.view.TerminalView
import io.atha.bababasic.databinding.ActivityRunBinding
import io.atha.bababasic.terminal.BabaTerminalSession
import io.atha.bababasic.terminal.TermuxTerminalViewClient
import java.io.Serializable

data class RunDatum(
    val src: String,
) : Serializable

class ActivityRun : BabaActivity() {
    private lateinit var viewClient: TermuxTerminalViewClient
    private lateinit var mPreferences: AppSharedPreferences
    lateinit var binding: ActivityRunBinding
    private lateinit var datum: RunDatum
    private lateinit var session: BabaTerminalSession

    fun getPreferences(): AppSharedPreferences {
        return mPreferences
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        super.onKeyDown(keyCode, event)
        return binding.terminal.onKeyDown(keyCode, event!!)
    }

    override fun onKeyUp(keyCode: Int, event: KeyEvent?): Boolean {
        super.onKeyUp(keyCode, event)
        return binding.terminal.onKeyUp(keyCode, event!!)
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
        mPreferences = AppSharedPreferences()
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

        binding.keyboard.setOnClickListener {
            viewClient.setSoftKeyboardState(true, false)
        }

        binding.stop.setOnClickListener {
            session.finishIfRunning()
        }

        val client1 = object : TerminalSessionClient {
            override fun onTextChanged(changedSession: TerminalSession) {
                binding.terminal.onScreenUpdated()
            }

            override fun onTitleChanged(changedSession: TerminalSession) {
            }

            override fun onSessionFinished(finishedSession: TerminalSession) {
            }

            override fun onCopyTextToClipboard(session: TerminalSession, text: String?) {
            }

            override fun onPasteTextFromClipboard(session: TerminalSession?) {
            }

            override fun onBell(session: TerminalSession) {
            }

            override fun onColorsChanged(session: TerminalSession) {
            }

            override fun onTerminalCursorStateChange(state: Boolean) {
            }

            override fun setTerminalShellPid(session: TerminalSession, pid: Int) {
            }

            override fun getTerminalCursorStyle(): Int {
                return 1
            }

            override fun logError(tag: String?, message: String?) {
            }

            override fun logWarn(tag: String?, message: String?) {
            }

            override fun logInfo(tag: String?, message: String?) {
            }

            override fun logDebug(tag: String?, message: String?) {
            }

            override fun logVerbose(tag: String?, message: String?) {
            }

            override fun logStackTraceWithMessage(tag: String?, message: String?, e: Exception?) {
            }

            override fun logStackTrace(tag: String?, e: Exception?) {
            }
        }
        viewClient = TermuxTerminalViewClient(this)

        session = BabaTerminalSession(
            client1,
            this,
            datum,
        )

        binding.terminal.setBackgroundColor(Color.BLACK)
        val typeface = Typeface.createFromAsset(assets, "JetBrainsMono-Regular.ttf")
        binding.terminal.setTextSize(16)
        binding.terminal.setTypeface(typeface)
        binding.terminal.attachSession(session)
        binding.terminal.setTerminalViewClient(viewClient)
        session.initializeEmulator(1, 1)
        setContentView(binding.root)
        viewClient.onCreate()
        initFirebase()
    }

    fun getTerminalView(): TerminalView = binding.terminal
    fun getCurrentSession(): TerminalSession? = binding.terminal.currentSession
    fun isActivityRecreated(): Boolean {
        return false
    }

    fun toggleTerminalToolbar() {
        TODO("Not yet implemented")
    }
}