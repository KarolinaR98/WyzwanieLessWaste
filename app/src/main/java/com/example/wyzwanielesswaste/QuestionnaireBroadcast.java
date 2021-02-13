package com.example.wyzwanielesswaste;

import android.app.Notification;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.provider.Settings;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import static com.example.wyzwanielesswaste.App.CHANNEL_1_ID;

public class QuestionnaireBroadcast extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        NotificationCompat.Builder notification = new NotificationCompat.Builder(context, CHANNEL_1_ID )
                .setSmallIcon(R.drawable.ic_stat_name)
                .setContentTitle("Dokonaj podsumowania tygodnia")
                .setContentText("Wyzwanie na ten tydzień skończone. Dokonaj podsumowania")
                .setStyle(new NotificationCompat.BigTextStyle())
                .setPriority(Notification.PRIORITY_MAX)
                .setSound(Settings.System.DEFAULT_NOTIFICATION_URI)
                .setAutoCancel(false)
                .setVibrate(new long[]{1000});

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(context);

        notificationManager.notify(3, notification.build());
    }
}
