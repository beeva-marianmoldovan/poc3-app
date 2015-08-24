package com.beeva.iotday;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;

import com.beeva.ubiqlibrary.blocks.UbiqonsContentViewActivity;

import java.util.Random;

public class UbiqonsBroadcastReceiver extends BroadcastReceiver {
    public UbiqonsBroadcastReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {

        Intent contentIntent = new Intent(context, UbiqonsContentViewActivity.class);

        contentIntent.putExtra(UbiqonsContentViewActivity.CONTENT_TYPE, intent.getExtras().getString("type"));
        contentIntent.putExtra(UbiqonsContentViewActivity.CONTENT_NAME, intent.getExtras().getString("name"));
        contentIntent.putExtra(UbiqonsContentViewActivity.CONTENT, intent.getExtras().getString("content"));

        PendingIntent viewPendingIntent = PendingIntent.getActivity(context, 0, contentIntent, PendingIntent.FLAG_CANCEL_CURRENT);

        NotificationCompat.Builder notificationBuilder =
                new NotificationCompat.Builder(context)
                        .setSmallIcon(com.beeva.ubiqlibrary.R.mipmap.ic_launcher)
                        .setContentTitle(intent.getExtras().getString("title"))
                        .setContentText(intent.getExtras().getString("content"))
                        .setContentIntent(viewPendingIntent)
                        .setAutoCancel(true);

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(context);
        notificationManager.notify(new Random().nextInt(), notificationBuilder.build());
    }
}
