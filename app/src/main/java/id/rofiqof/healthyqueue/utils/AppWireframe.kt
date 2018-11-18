package id.rofiqof.healthyqueue.utils

import id.rofiqof.healthyqueue.view.activities.barcode.BarcodeWireframe
import id.rofiqof.healthyqueue.view.activities.detail.DetailWireframe
import id.rofiqof.healthyqueue.view.activities.detailantrian.DetailAntrianWireframe
import id.rofiqof.healthyqueue.view.activities.homemain.HomeMainWireframe
import id.rofiqof.healthyqueue.view.activities.login.LoginWireframe
import id.rofiqof.healthyqueue.view.activities.setting.SettingWireframe

class AppWireframe {
    val home by lazy { HomeMainWireframe() }
    val login by lazy { LoginWireframe() }
    val detail by lazy { DetailWireframe() }
    val detailAntrin by lazy { DetailAntrianWireframe() }
    val barcode by lazy { BarcodeWireframe() }
    val setting by lazy { SettingWireframe() }
}