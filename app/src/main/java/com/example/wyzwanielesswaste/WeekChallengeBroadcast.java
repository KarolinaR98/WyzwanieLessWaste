package com.example.wyzwanielesswaste;

import android.app.Notification;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Vibrator;
import android.provider.Settings;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import static com.example.wyzwanielesswaste.App.CHANNEL_1_ID;

public class WeekChallengeBroadcast extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        MyDBHandler myDBHandler = new MyDBHandler(context, null,null,4);

        MainActivity mainActivity = new MainActivity();
        int challengeWeek;
        challengeWeek = mainActivity.GetChallengeWeek();

        Vibrator v = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
        if(challengeWeek != 0){ NotificationCompat.Builder notification = new NotificationCompat.Builder(context, CHANNEL_1_ID )
                .setSmallIcon(R.drawable.ic_stat_name)
                .setContentTitle( myDBHandler.loadChallengeNotificationRow1(challengeWeek))
                .setContentText(myDBHandler.loadChallengeNotificationRow2(challengeWeek))
                .setStyle(new NotificationCompat.BigTextStyle())
                .setPriority(Notification.PRIORITY_MAX)
                .setSound(Settings.System.DEFAULT_NOTIFICATION_URI)
                .setAutoCancel(false)
                .setVibrate(new long[]{1000});


            v.vibrate(500);
            NotificationManagerCompat notificationManager = NotificationManagerCompat.from(context);

            notificationManager.notify(2, notification.build());}
        else
            return;


    }
}
