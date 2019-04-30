package com.area51.clasepush

import android.util.Log
import android.widget.Toast
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import com.google.gson.Gson

class MyFirebaseMessagingService : FirebaseMessagingService() {
    override fun onMessageReceived(p0: RemoteMessage?) {
        super.onMessageReceived(p0)

        p0?.data?.isNotEmpty()?.let {
            Log.d("tag_push", "Mensaje: ${Gson().toJson(p0)}")
        }
    }
}