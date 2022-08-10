package com.example.android.gamesredo.notifications.services

import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.core.app.NotificationCompat
import com.example.android.gamesredo.MainActivity
import com.example.android.gamesredo.R
import com.example.android.gamesredo.notifications.CounterNotificationReciever
import okhttp3.internal.notify

class ScoreNotificationService(
    private val context: Context
){

    private val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

    fun showNotification(counter: Int) {
        val activityIntent = Intent(context, MainActivity::class.java)
        val activityPendingIntent = PendingIntent.getActivity(
            context,
            1,
            activityIntent,
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) PendingIntent.FLAG_IMMUTABLE else 0
        )

        val incrementIntent = PendingIntent.getBroadcast(
            context,
            2,
            Intent(context, CounterNotificationReciever::class.java),
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) PendingIntent.FLAG_IMMUTABLE else 0
        )


        val notification = NotificationCompat.Builder(context, SCORE_CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_baseline_sports_baseball_24)
            .setContentTitle("Score!")
            .setContentText("The score is $counter")
            .setContentIntent(activityPendingIntent)
            .addAction(
                R.drawable.ic_baseline_sports_baseball_24,
                "incrementIntent",
                incrementIntent
            )
            .build()
        notificationManager.notify(
            1,
            notification
        )
    }

    companion object {
        const val SCORE_CHANNEL_ID = "score_channel "
    }
}