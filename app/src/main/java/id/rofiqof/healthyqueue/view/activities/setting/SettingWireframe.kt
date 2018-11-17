package id.rofiqof.healthyqueue.view.activities.setting

import android.content.Context
import android.content.Intent

class SettingWireframe {
    fun toView(context: Context) {
        Intent(context, SettingActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK
        }.let {
            context.startActivity(it)
        }
    }
}