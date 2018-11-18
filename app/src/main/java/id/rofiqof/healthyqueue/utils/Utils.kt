package id.rofiqof.healthyqueue.utils

import java.text.NumberFormat
import java.util.*

class Utils{

    fun setFormatRupiah(harga: Int): String {
        val localeID = Locale("in", "ID")
        val formatRupiah = NumberFormat.getCurrencyInstance(localeID)

        val s = formatRupiah.format(harga.toDouble())

        return s.replace("Rp", "Rp ")
    }

    fun setFormatRupiahWithoutRp(harga: Int): String {
        val localeID = Locale("in", "ID")
        val formatRupiah = NumberFormat.getCurrencyInstance(localeID)
        val s = formatRupiah.format(harga.toDouble())

        return s.replace("Rp", "")
    }
}