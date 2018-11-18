package id.rofiqof.healthyqueue.view.activities.login

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import id.rofiqof.healthyqueue.R
import id.rofiqof.healthyqueue.utils.AppWireframe
import id.rofiqof.healthyqueue.utils.SessionData
import id.rofiqof.healthyqueue.utils.disable
import id.rofiqof.healthyqueue.utils.enable
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    val wireframe by lazy { AppWireframe() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        initView()
    }

    private fun initView() {
        actionEditText(edt_password)
        actionEditText(edt_username)

        if (SessionData(baseContext).isLogin()) {
            wireframe.home.toView(baseContext)
        }

        btn_login?.setOnClickListener {
            SessionData(baseContext).setLogin(true)
            wireframe.home.toView(this); finish()
        }
    }

    private fun actionEditText(view: EditText?) {
        view?.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {}
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (edt_username?.text.toString().isEmpty() && edt_password?.text.toString().isEmpty()) {
                    btn_login?.disable()
                } else {
                    btn_login?.enable()
                }
            }

        })
    }
}
