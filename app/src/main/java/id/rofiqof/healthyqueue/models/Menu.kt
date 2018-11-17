package id.rofiqof.healthyqueue.models

import android.graphics.Color
import id.rofiqof.healthyqueue.R

data class Feature(var title: String, var icon: Int)

fun HomeMenu(): ArrayList<Feature> {
    return ArrayList<Feature>().apply {
        add(Feature("Poly Umum", R.drawable.ic_umum))
        add(Feature("Poly Gigi", R.drawable.ic_tooth))
        add(Feature("Poly Mata", R.drawable.ic_mata))
        add(Feature("Poly THT", R.drawable.ic_tht))
        add(Feature("Poly Jantung", R.drawable.ic_hati))
        add(Feature("Poly Syaraf", R.drawable.ic_saraf))
    }

}