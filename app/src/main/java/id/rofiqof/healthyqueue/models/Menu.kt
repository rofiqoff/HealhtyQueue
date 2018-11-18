package id.rofiqof.healthyqueue.models

import id.rofiqof.healthyqueue.R

data class Feature(var title: String, var icon: Int)

fun HomeMenu(): ArrayList<Feature> {
    return ArrayList<Feature>().apply {
        add(Feature("Poli Umum", R.drawable.ic_umum))
        add(Feature("Poli Gigi", R.drawable.ic_tooth))
        add(Feature("Poli Mata", R.drawable.ic_mata))
        add(Feature("Poli THT", R.drawable.ic_tht))
        add(Feature("Poli Jantung", R.drawable.ic_hati))
        add(Feature("Poli Syaraf", R.drawable.ic_saraf))
    }

}