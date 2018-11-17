package id.rofiqof.healthyqueue.view.activities.detail

import android.content.Context
import android.content.Intent

class DetailWireframe {
    fun toView(context: Context, title: String?, icon: Int?) {
        Intent(context, DetailActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK
            putExtra("title", title)
            putExtra("icon", icon)
        }.let {
            context.startActivity(it)
        }
    }
}