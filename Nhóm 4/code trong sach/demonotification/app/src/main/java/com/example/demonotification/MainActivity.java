package com.example.demonotification;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import androidx.core.app.TaskStackBuilder;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {
    Button btnTaoNotification;
    Button btnDongNotification;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnTaoNotification = (Button) findViewById(R.id.btnTaoNotificationId);
        btnDongNotification = (Button) findViewById(R.id.btnDongNotificationId);
        Intent i = getIntent();
        String s = i.getStringExtra("CHITIET");
        TextView txtChitiet = (TextView) findViewById(R.id.txtViewNotificationId);
        txtChitiet.setText(s);
        this.btnTaoNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xulyTaoNotification(view);
            }
        });
        this.btnDongNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xulyDongNotification(view);
            }
        });
    }
//    public void xulyTaoNotification(View view){
//        NotificationCompat.Builder mbuilder = new NotificationCompat.Builder(this);
//        mbuilder.setSmallIcon(R.drawable.noty_icon1_foreground);
//        mbuilder.setContentTitle("Có Notification, Click tôi");
//        mbuilder.setContentText("Xin chào, Đây là Android Notification Chi tiết!");
//        Intent Resultintent = new Intent(this,MainActivity.class);
//        String st="Xin chào bạn Notification";
//        Resultintent.putExtra("CHITIET",st);
//        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
//        stackBuilder.addParentStack(MainActivity.class);
//        stackBuilder.addNextIntent(Resultintent);
//        PendingIntent ResultpendingIntent = stackBuilder.getPendingIntent(0,PendingIntent.FLAG_UPDATE_CURRENT);
//        mbuilder.setContentIntent(ResultpendingIntent);
//        NotificationManager notificationManager= (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
//        notificationManager.notify(123,mbuilder.build());
//    }

    public void xulyTaoNotification(View view) {
        String channelId = "my_channel_id";
        String channelName = "My Channel";

        NotificationCompat.Builder mbuilder = new NotificationCompat.Builder(this, channelId);
        mbuilder.setSmallIcon(R.drawable.noty_icon1_foreground);
        mbuilder.setContentTitle("Có Notification, Click tôi");
        mbuilder.setContentText("Xin chào, Đây là Android Notification Chi tiết!");

        Intent Resultintent = new Intent(this, MainActivity.class);
        String st = "Xin chào bạn Notification";
        Resultintent.putExtra("CHITIET", st);

        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
        stackBuilder.addParentStack(MainActivity.class);
        stackBuilder.addNextIntent(Resultintent);

        PendingIntent ResultpendingIntent = stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);
        mbuilder.setContentIntent(ResultpendingIntent);

        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(channelId, channelName, NotificationManager.IMPORTANCE_DEFAULT);
            notificationManager.createNotificationChannel(channel);
        }

        notificationManager.notify(123, mbuilder.build());
    }

    public void xulyDongNotification(View view){
        NotificationManager notificationManager= (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
    notificationManager.cancel(123);}
}