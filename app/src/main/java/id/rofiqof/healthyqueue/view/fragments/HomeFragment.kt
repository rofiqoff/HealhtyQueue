package id.rofiqof.healthyqueue.view.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.smarteist.autoimageslider.SliderLayout
import com.smarteist.autoimageslider.SliderView
import id.rofiqof.healthyqueue.R
import id.rofiqof.healthyqueue.models.Feature
import id.rofiqof.healthyqueue.models.HomeMenu
import id.rofiqof.healthyqueue.utils.Adapter
import id.rofiqof.healthyqueue.view.viewholder.MenuViewHolder
import id.rofiqof.healthyqueue.utils.Utils
import id.rofiqof.healthyqueue.utils.SessionData
import kotlinx.android.synthetic.main.fragment_home.*


class HomeFragment : Fragment() {

    private val saldoUser = 100000

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        iniView()
    }

    private fun iniView() {
        initSlider()
        initMenu()

        SessionData(context!!).updateSaldo(saldoUser)
        saldo?.text = Utils().setFormatRupiahWithoutRp(saldoUser)
    }

    private fun initSlider() {
        image_slider?.setIndicatorAnimation(SliderLayout.Animations.SWAP)
        image_slider?.scrollTimeInSec = 3

        setSliderViews()
    }

    private fun setSliderViews() {
        for (i in 0..3) {

            val sliderView = SliderView(activity)

            when (i) {
                0 -> sliderView.imageUrl =
                        "https://images.pexels.com/photos/547114/pexels-photo-547114.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260"
                1 -> sliderView.imageUrl =
                        "https://images.pexels.com/photos/218983/pexels-photo-218983.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260"
                2 -> sliderView.imageUrl =
                        "https://images.pexels.com/photos/747964/pexels-photo-747964.jpeg?auto=compress&cs=tinysrgb&h=750&w=1260"
                3 -> sliderView.imageUrl =
                        "https://images.pexels.com/photos/929778/pexels-photo-929778.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260"
            }

            sliderView.setImageScaleType(ImageView.ScaleType.CENTER_CROP)
            sliderView.setOnSliderClickListener {}

            image_slider?.addSliderView(sliderView)
        }
    }

    private fun initMenu() {
        val menu = HomeMenu()
        list_menu?.setHasFixedSize(true)
        list_menu?.isNestedScrollingEnabled = false
        list_menu?.layoutManager = GridLayoutManager(activity, 3)
        list_menu?.adapter = object : Adapter<Feature, MenuViewHolder>(
            R.layout.item_menu, MenuViewHolder::class.java, Feature::class.java, menu
        ) {
            override fun bindView(holder: MenuViewHolder, model: Feature, position: Int) {
                holder.onBind(model)
            }
        }
    }

}
