package id.rofiqof.healthyqueue.view.activities.barcode

import android.content.Context
import android.content.Intent

class BarcodeWireframe {
    fun toView(context: Context, antrian: String?) {
        Intent(context, BarcodeActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK
            putExtra("antrian", antrian)
        }.let {
            context.startActivity(it)
        }
    }
}