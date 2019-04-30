package com.area51.clasepush

import android.app.Notification
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.iid.FirebaseInstanceId
import com.google.firebase.messaging.FirebaseMessaging
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    companion object {
        const val TAG = "tag_push"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        FirebaseMessaging.getInstance().isAutoInitEnabled = true
        inicializar()
    }

    override fun onResume() {
        super.onResume()

        btnPresionar.setOnClickListener {
            val notificacion = Notification.Builder(this)
            notificacion.setContentTitle("Titulo")
            notificacion.setContentText("Contenido")
            notificacion.setSmallIcon(R.mipmap.ic_launcher)

            val intent = Intent()
            val pendingIntent = PendingIntent.getActivity(
                    this,
                    123,
                    intent,
                    PendingIntent.FLAG_UPDATE_CURRENT)
            notificacion.setContentIntent(pendingIntent)

            val noti = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            noti.notify(123, notificacion.build())

        }
    }

    private fun inicializar() {
        FirebaseInstanceId.getInstance().instanceId
                .addOnCompleteListener(OnCompleteListener { task ->
                    if (!task.isSuccessful) {
                        Log.w(TAG, "getInstanceId failed", task.exception)
                        return@OnCompleteListener
                    }

                    // Get new Instance ID token
                    val token = task.result?.token

                    // Log and toast
                    val msg = "El token es: $token"//getString(R.string.msg_token_fmt, token)
                    Log.d(TAG, msg)
                    Toast.makeText(baseContext, msg, Toast.LENGTH_SHORT).show()
                })
    }
}
