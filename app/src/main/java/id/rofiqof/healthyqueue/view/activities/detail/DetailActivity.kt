package id.rofiqof.healthyqueue.view.activities.detail

import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import id.rofiqof.healthyqueue.R
import id.rofiqof.healthyqueue.utils.AppWireframe
import id.rofiqof.healthyqueue.utils.SekizbitSwitch
import id.rofiqof.healthyqueue.utils.SessionData
import id.rofiqof.healthyqueue.utils.Utils
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.toolbar.*

class DetailActivity : AppCompatActivity() {

    private val saldo by lazy { SessionData(baseContext).getSaldo() }
    private val title by lazy { intent?.getStringExtra("title") }
    private val icon by lazy { intent?.getIntExtra("icon", R.mipmap.ic_launcher_round) }
    private val wireframe by lazy { AppWireframe() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        initView()
    }

    private fun initView() {
        initToolbar()

        saldo_price?.text = Utils().setFormatRupiah(saldo)

        btn_daftar?.setOnClickListener { wireframe.detailAntrin.toView(this); finish() }

        val mySwitch = SekizbitSwitch(sekizbit_switch)

        if (saldo < 100000) {
            mySwitch.setSelected(1)
            mySwitch.unSelected(0)
        } else {
            mySwitch.setSelected(0)
            mySwitch.unSelected(1)
        }

        mySwitch.setOnChangeListener { sender ->
            if (sender.getCheckedIndex() == 0) {
                if (saldo < 100000) {
                    showMessageSaldoNotEnaugh(sender)
                } else {
                    mySwitch.setSelected(0)
                    mySwitch.unSelected(1)
                }
            } else if (sender.getCheckedIndex() == 1) {

            }

        }
    }

    private fun showMessageSaldoNotEnaugh(sender: SekizbitSwitch) {
        AlertDialog.Builder(this@DetailActivity).apply {
            setMessage("Saldo Anda tidak cukup. \nSilahkan lakukan top up saldo Anda terlebih dahulu")
            setPositiveButton("Oke") { dialog, _ ->
                sender.setSelected(1)
                sender.unSelected(0)
                dialog.dismiss()
            }
            setNegativeButton("Tutup") { dialog, _ ->
                sender.setSelected(1)
                sender.unSelected(0)
                dialog.dismiss()
            }
            setOnCancelListener { dialog ->
                sender.setSelected(1)
                sender.unSelected(0)
                dialog.dismiss()
            }
        }.show()
    }

    private fun initToolbar() {
        setSupportActionBar(toolbar)
        supportActionBar?.title = title
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        toolbar?.setNavigationOnClickListener { onBackPressed() }
    }
}
