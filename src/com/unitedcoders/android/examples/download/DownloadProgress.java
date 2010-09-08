package com.unitedcoders.android.examples.download;

import com.unitedcoders.android.examples.R;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.RemoteViews;

/**
 * Simulates a download and updates the notification bar with a Progress
 * 
 * @author Nico Heid
 * 
 */
public class DownloadProgress extends Activity {

    ProgressBar progressBar;
    private int progress = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // get the layout
        setContentView(R.layout.download_progress);

        // configure the intent
        Intent intent = new Intent(this, DownloadProgress.class);
        final PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(), 0, intent, 0);

        // configure the notification
        final Notification notification = new Notification(R.drawable.icon, "simulating a download", System
                .currentTimeMillis());
        notification.flags = notification.flags | Notification.FLAG_ONGOING_EVENT;
        notification.contentView = new RemoteViews(getApplicationContext().getPackageName(), R.layout.download_progress);
        notification.contentIntent = pendingIntent;
        notification.contentView.setImageViewResource(R.id.status_icon, R.drawable.ic_menu_save);
        notification.contentView.setTextViewText(R.id.status_text, "simulation in progress");
        notification.contentView.setProgressBar(R.id.status_progress, 100, progress, false);

        final NotificationManager notificationManager = (NotificationManager) getApplicationContext().getSystemService(
                getApplicationContext().NOTIFICATION_SERVICE);

        notificationManager.notify(42, notification);

        // simulate progress
        Thread download = new Thread() {

            @Override
            public void run() {

                for (int i = 1; i < 100; i++) {
                    progress++;
                    notification.contentView.setProgressBar(R.id.status_progress, 100, progress, false);

                    // inform the progress bar of updates in progress
                    notificationManager.notify(42, notification);

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }

                // remove the notification (we're done)
                notificationManager.cancel(42);

            }
        };

        download.run();

        finish();

    }

}