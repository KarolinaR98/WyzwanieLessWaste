package com.example.wyzwanielesswaste;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.provider.Settings;

import androidx.core.app.NotificationCompat;

public class NotificationHelper {


    private Context mContext;
    private static final String NOTIFICATION_CHANNEL_ID = "1001";

    NotificationHelper(Context context){
        mContext = context;
    }



    void createNotification(){

        Intent intent = new Intent(mContext, NotificationActivity.class);

        MyDBHandler myDBHandler = new MyDBHandler( mContext, null, null,2);


        int min = 1, max = 84, id;
        id = (int)Math.floor((Math.random() * 84) + 1);



        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        PendingIntent resultPendingIntent = PendingIntent.getActivity(mContext,0,intent,PendingIntent.FLAG_UPDATE_CURRENT);

        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(mContext, NOTIFICATION_CHANNEL_ID);
        mBuilder.setSmallIcon(R.drawable.ic_stat_name);
        mBuilder.setContentTitle( myDBHandler.loadHandlerTitle(id));
        mBuilder.setContentText(myDBHandler.loadHandlerText(id));
        mBuilder.setStyle(new NotificationCompat.BigTextStyle());
        mBuilder.setPriority(Notification.PRIORITY_MAX);
        mBuilder.setSound(Settings.System.DEFAULT_NOTIFICATION_URI);
        mBuilder.setVibrate(new long[]{1000});
        mBuilder.setContentIntent(resultPendingIntent);
        mBuilder.setAutoCancel(false);


        NotificationManager notificationManager = (NotificationManager) mContext.getSystemService(Context.NOTIFICATION_SERVICE);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
        {
            int importance = NotificationManager.IMPORTANCE_HIGH;
            NotificationChannel notificationChannel = new NotificationChannel(NOTIFICATION_CHANNEL_ID, "NOTIFICATION_CHANNEL_NAME", importance);
            notificationChannel.enableLights(true);
            notificationChannel.enableVibration(true);
            assert notificationManager != null;
            mBuilder.setChannelId(NOTIFICATION_CHANNEL_ID);
            notificationManager.createNotificationChannel(notificationChannel);
        }
        assert notificationManager != null;
        notificationManager.notify(0,mBuilder.build());


    }
}
