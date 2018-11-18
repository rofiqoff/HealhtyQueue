package id.rofiqof.healthyqueue.view.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import id.rofiqof.healthyqueue.R
import id.rofiqof.healthyqueue.utils.AppWireframe
import id.rofiqof.healthyqueue.utils.SessionData
import kotlinx.android.synthetic.main.fragment_akunku.*

class AkunkuFragment : Fragment() {

    private val wireframe by lazy { AppWireframe() }
    private val session by lazy { SessionData(context!!) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_akunku, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    override fun onResume() {
        super.onResume()
        if (SessionData(context!!).getUser().email != "") {
            email_akun?.text = session.getUser().email
            no_hp_akun?.text = session.getUser().phone
        }
    }

    private fun initView() {
        parent_setting?.setOnClickListener {
            val email = email_akun?.text.toString()
            val phone = no_hp_akun?.text.toString()

            wireframe.setting.toView(context!!, email, phone)
        }
        btn_logout?.setOnClickListener {
            SessionData(context!!).clearSession()
            wireframe.login.toView(context!!)
            activity?.finish()
        }
    }

}