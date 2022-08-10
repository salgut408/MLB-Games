package com.example.android.gamesredo.notifications

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.example.android.gamesredo.notifications.services.ScoreNotificationService

class CounterNotificationReciever: BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent?) {
        val  service = ScoreNotificationService(context)
        service.showNotification(++Counter.value)

    }
}