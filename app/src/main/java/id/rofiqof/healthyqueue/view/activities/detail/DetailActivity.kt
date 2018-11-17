package id.rofiqof.healthyqueue.view.activities.detail

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import id.rofiqof.healthyqueue.R
import id.rofiqof.healthyqueue.utils.AppWireframe
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.toolbar.*

class DetailActivity : AppCompatActivity() {

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

        btn_daftar?.setOnClickListener { wireframe.detailAntrin.toView(this); finish() }
    }

    private fun initToolbar() {
        setSupportActionBar(toolbar)
        supportActionBar?.title = title
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        toolbar?.setNavigationOnClickListener { onBackPressed() }
    }
}
