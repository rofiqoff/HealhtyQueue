package id.rofiqof.healthyqueue.view.activities.barcode

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import id.rofiqof.healthyqueue.R
import kotlinx.android.synthetic.main.toolbar.*

class BarcodeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_barcode)
        initView()
    }

    private fun initView() {
        initToolbar()
    }

    private fun initToolbar() {
        setSupportActionBar(toolbar)
        supportActionBar?.title = "Barcode Antrian"
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        toolbar?.setNavigationOnClickListener { onBackPressed() }
    }
}
