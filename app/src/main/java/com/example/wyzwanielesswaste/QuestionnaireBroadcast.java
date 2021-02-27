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

public class QuestionnaireBroadcast extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        ChallengeContent challengeContent = new ChallengeContent();

        ChallengeStepsActivity challengeStepsActivity = new ChallengeStepsActivity();

        int id = challengeStepsActivity.GetId();

        if (id == 1){
            challengeContent.TurnOnOffButton1 = true;
        }
        else if (id == 2){

            challengeContent.TurnOnOffButton2 = true;
        }
        else if (id == 3){

            challengeContent.TurnOnOffButton3 = true;
        }
        else if (id == 4){

            challengeContent.TurnOnOffButton4 = true;
        }
        else if (id == 5){

            challengeContent.TurnOnOffButton5 = true;
        }
        else if (id == 6){

            challengeContent.TurnOnOffButton6 = true;
        }
        else if (id == 7){

            challengeContent.TurnOnOffButton7 = true;
        }
        else if (id == 8){

            challengeContent.TurnOnOffButton8 = true;
        }
        else if (id == 9){

            challengeContent.TurnOnOffButton9 = true;
        }
        else if (id == 10){

            challengeContent.TurnOnOffButton10 = true;
        }


        Vibrator v = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);

        NotificationCompat.Builder notification = new NotificationCompat.Builder(context, CHANNEL_1_ID )
                .setSmallIcon(R.drawable.ic_stat_name)
                .setContentTitle("Dokonaj podsumowania tygodnia")
                .setContentText("Wyzwanie na ten tydzień skończone. Dokonaj podsumowania")
                .setStyle(new NotificationCompat.BigTextStyle())
                .setPriority(Notification.PRIORITY_MAX)
                .setSound(Settings.System.DEFAULT_NOTIFICATION_URI)
                .setAutoCancel(false)
                .setVibrate(new long[]{1000});

        v.vibrate(500);
        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(context);

        notificationManager.notify(3, notification.build());
    }
}
