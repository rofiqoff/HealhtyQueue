package id.rofiqof.healthyqueue.view.activities.login

import android.content.Context
import android.content.Intent

class LoginWireframe{
    fun toView(context: Context) {
        Intent(context, LoginActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK
        }.let {
            context.startActivity(it)
        }
    }
}