package id.rofiqof.healthyqueue.view.activities.setting

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.Editable
import android.text.TextWatcher
import id.rofiqof.healthyqueue.R
import id.rofiqof.healthyqueue.models.User
import id.rofiqof.healthyqueue.utils.SessionData
import id.rofiqof.healthyqueue.utils.gone
import id.rofiqof.healthyqueue.utils.visible
import kotlinx.android.synthetic.main.activity_setting.*
import kotlinx.android.synthetic.main.toolbar.*

class SettingActivity : AppCompatActivity() {

    private val email by lazy { intent?.getStringExtra("email") }
    private val phone by lazy { intent?.getStringExtra("phone") }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting)
        initView()
    }

    private fun initView() {
        initToolbar()
        btn_simpan?.setOnClickListener {
            val email = email_akun?.text.toString()
            val phone = no_hp_akun?.text.toString()

            SessionData(baseContext).saveUser(User(email, phone))

            finish()
        }
        clear_email?.setOnClickListener { email_akun?.setText("") }
        clear_hp?.setOnClickListener { no_hp_akun?.setText("") }
        clear_password?.setOnClickListener { password_akun?.setText("") }

        initActionEditText()
    }

    private fun initToolbar() {
        setSupportActionBar(toolbar)
        supportActionBar?.title = "Edit Profil"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        toolbar?.setNavigationOnClickListener { onBackPressed() }
    }

    private fun initActionEditText() {
        email_akun?.setText(email)
        no_hp_akun?.setText(phone)

        email_akun?.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {}
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (s?.length!! > 0) {
                    showClearEmail()
                } else {
                    hideClear()
                }
            }
        })

        no_hp_akun?.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {}
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (s?.length!! > 0) {
                    showClearHp()
                } else {
                    hideClear()
                }
            }
        })

        password_akun?.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {}
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (s?.length!! > 0) {
                    showClearPassword()
                } else {
                    hideClear()
                }
            }
        })

        when {
            email_akun.isCursorVisible -> showClearEmail()
            no_hp_akun.isCursorVisible -> showClearHp()
            password_akun.isCursorVisible -> showClearPassword()
        }
    }

    private fun showClearEmail() {
        clear_email?.visible()
        clear_hp?.gone()
        clear_password?.gone()
    }

    private fun showClearHp() {
        clear_email?.gone()
        clear_hp?.visible()
        clear_password?.gone()
    }

    private fun showClearPassword() {
        clear_email?.gone()
        clear_hp?.gone()
        clear_password?.visible()
    }

    private fun hideClear() {
        clear_email?.gone()
        clear_hp?.gone()
        clear_password?.gone()
    }
}
