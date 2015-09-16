package com.example.ucsc.notificationsfortomorrow;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;

public class MainActivity extends AppCompatActivity {

    //giving an ID num fo each notification
    NotificationCompat.Builder notification;
    private static final int uniqueID=45612;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        notification=new NotificationCompat.Builder(this);
        notification.setAutoCancel(true);
    }

    public void ishkButtonClicked(View view){
        //build the notification
        notification.setSmallIcon(R.drawable.ic_launcher);
        notification.setTicker("This is the Ticker");
        notification.setWhen(System.currentTimeMillis());
        notification.setContentTitle("Here is the Title");
        notification.setContentText("I am the Body text of ur Notification");

        Intent intent=new Intent(this,MainActivity.class);
        PendingIntent pendingIntent=PendingIntent.getActivity(this,0,intent,PendingIntent.FLAG_UPDATE_CURRENT);
        notification.setContentIntent(pendingIntent);

        //builds notification and issues it
        NotificationManager nm=(NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        nm.notify(uniqueID,notification.build());

        
    }




}
