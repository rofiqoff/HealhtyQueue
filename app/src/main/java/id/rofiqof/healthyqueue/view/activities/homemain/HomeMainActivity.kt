package id.rofiqof.healthyqueue.view.activities.homemain

import android.graphics.Color
import android.graphics.PorterDuff
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import id.rofiqof.healthyqueue.R
import id.rofiqof.healthyqueue.utils.AppWireframe
import id.rofiqof.healthyqueue.utils.FragmentAdapter
import id.rofiqof.healthyqueue.view.fragments.AkunkuFragment
import id.rofiqof.healthyqueue.view.fragments.HistoryFragment
import id.rofiqof.healthyqueue.view.fragments.HomeFragment
import kotlinx.android.synthetic.main.activity_home_main.*
import kotlinx.android.synthetic.main.toolbar.*
import kotlinx.android.synthetic.main.view_custom_tab.view.*

class HomeMainActivity : AppCompatActivity() {

    val titleTabId = arrayOf("Home", "History", "Akunku")
    val iconTabId = intArrayOf(R.drawable.ic_home, R.drawable.ic_assessment, R.drawable.ic_person)

    var titleTab: TextView? = null
    var iconTab: ImageView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_main)
        initView()
    }

    private fun initView() {
        initToolbar()
        initAdapter()
    }

    private fun initToolbar() {
        setSupportActionBar(toolbar)
        supportActionBar?.title = getString(R.string.app_name)
        supportActionBar?.setIcon(R.drawable.ic_logo)
        supportActionBar?.setHomeButtonEnabled(false)
    }

    private fun initAdapter() {
        viewpager?.adapter = FragmentAdapter(supportFragmentManager, true).apply {
            addFragment(HomeFragment(), "Home")
            addFragment(HistoryFragment(), "History")
            addFragment(AkunkuFragment(), "Akunku")
        }

        tab_layout?.setupWithViewPager(viewpager)

        tab_layout?.apply {
            for (i in 0 until tabCount) getTabAt(i)?.customView = setTabIcon(i)

            setOnSelectedView(tab_layout, 0)

            addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
                override fun onTabReselected(tab: TabLayout.Tab?) {}

                override fun onTabUnselected(tabL: TabLayout.Tab) {
                    setOnUnSelectedView(tab_layout, tabL.position)
                }

                override fun onTabSelected(tabL: TabLayout.Tab) {
                    setOnSelectedView(tab_layout, tabL.position)
                }
            })
        }
    }

    private fun setTabIcon(position: Int): View {
        val view = LayoutInflater.from(this).inflate(R.layout.view_custom_tab, null)
        titleTab = view?.title_tab
        iconTab = view?.icon_tab

        titleTab?.text = titleTabId[position]
        iconTab?.setImageResource(iconTabId[position])

        return view
    }

    private fun setOnSelectedView(tabLayout: TabLayout, posisi: Int) {
        val tab = tabLayout.getTabAt(posisi)
        val view = tab?.customView

        titleTab = view?.title_tab
        iconTab = view?.icon_tab

        titleTab?.setTextColor(Color.WHITE)
        iconTab?.setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_ATOP)

    }

    private fun setOnUnSelectedView(tabLayout: TabLayout, posisi: Int) {
        val tab = tabLayout.getTabAt(posisi)
        val view = tab?.customView

        titleTab = view?.title_tab
        iconTab = view?.icon_tab

        titleTab?.setTextColor(Color.parseColor("#5affffff"))
        iconTab?.setColorFilter(Color.parseColor("#5affffff"), PorterDuff.Mode.SRC_ATOP)
    }
}
