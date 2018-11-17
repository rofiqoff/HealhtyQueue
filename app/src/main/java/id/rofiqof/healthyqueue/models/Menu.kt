package id.rofiqof.healthyqueue.models

import android.graphics.Color

data class Feature(var title: String)

fun HomeMenu(): ArrayList<Feature> {
    return ArrayList<Feature>().apply {
        add(Feature("Poly Umum"))
        add(Feature("Poly Gigi"))
        add(Feature("Poly Mata"))
        add(Feature("Poly THT"))
        add(Feature("Poly Jantung"))
        add(Feature("Poly Syaraf"))
    }

}