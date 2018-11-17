package id.rofiqof.healthyqueue.view.activities.homemain

import android.content.Context
import android.content.Intent

class HomeMainWireframe {
    fun toView(context: Context) {
        Intent(context, HomeMainActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK
        }.let {
            context.startActivity(it)
        }
    }
}