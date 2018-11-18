package id.rofiqof.healthyqueue.utils

import android.content.Context
import android.content.SharedPreferences
import id.rofiqof.healthyqueue.models.User

class SessionData(context: Context) {
    var session: SharedPreferences = context.getSharedPreferences("session", 0)
    var editor: SharedPreferences.Editor = session.edit()

    fun updateSaldo(saldo: Int) {
        editor.putInt("saldo", saldo)
        editor.apply()
    }

    fun getSaldo(): Int = session.getInt("saldo", 0)

    fun saveUser(data: User) {
        editor.putString("phone", data.phone)
        editor.putString("email", data.email)
        editor.apply()
    }

    fun getUser(): User {
        return User(
            session.getString("phone", ""),
            session.getString("email", "")
        )
    }

    fun setLogin(isLogin: Boolean) {
        editor.putBoolean("isLogin", isLogin)
        editor.apply()
    }

    fun isLogin(): Boolean = session.getBoolean("isLogin", false)

    fun clearSession() {
        editor.remove("isLogin")
        editor.remove("phone")
        editor.remove("email")
        editor.apply()
    }
}