package id.rofiqof.healthyqueue.view.activities.detailantrian

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import id.rofiqof.healthyqueue.R
import id.rofiqof.healthyqueue.utils.AppWireframe
import kotlinx.android.synthetic.main.activity_detail_antrian.*

class DetailAntrianActivity : AppCompatActivity() {

    private val wireframe by lazy { AppWireframe() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_antrian)
        initView()
    }

    private fun initView() {
        val nomorAntrian = text_antrian?.text?.toString()

        btn_tutup?.setOnClickListener { finish() }
        btn_lihat_barcode?.setOnClickListener { wireframe.barcode.toView(this, nomorAntrian) }
    }
}
