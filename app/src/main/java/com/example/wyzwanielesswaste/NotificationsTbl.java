package com.example.wyzwanielesswaste;

import android.app.Notification;

public class NotificationsTbl {

    private int _id;
    private String _notificationTitle;
    private String _notificationText;

    public NotificationsTbl(int id, String notificationTitle, String notificationText){
        this._id = id;
        this._notificationTitle = notificationTitle;
        this._notificationText = notificationText;
    }

    public void setID(int id){
        this._id = id ;
    }

    public int getID(){
        return this._id;
    }

    public void setNotificationTitle(String notificationTitle){
        this._notificationTitle = notificationTitle ;
    }

    public String getNotificationTitle(){
        return this._notificationTitle;
    }

    public void setNotificationText(String notificationText){
        this._notificationText = notificationText ;
    }

    public String getNotificationText() {
        return this._notificationText;
    }
}
