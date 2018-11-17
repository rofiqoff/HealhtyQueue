package id.rofiqof.healthyqueue.utils

import id.rofiqof.healthyqueue.view.activities.homemain.HomeMainWireframe
import id.rofiqof.healthyqueue.view.activities.login.LoginWireframe

class AppWireframe{
    val home by lazy { HomeMainWireframe() }
    val login by lazy { LoginWireframe() }
}