package id.rofiqof.healthyqueue.view.activities.detailantrian

import android.content.Context
import android.content.Intent

class DetailAntrianWireframe {
    fun toView(context: Context) {
        Intent(context, DetailAntrianActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK
        }.let {
            context.startActivity(it)
        }
    }
}