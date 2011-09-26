
package net.pikanji.startservicebyalarm;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

public class MainService extends Service {
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent i, int flags, int startId) {
        Toast.makeText(this, "Hello from service", Toast.LENGTH_SHORT).show();
        Log.v("StartServiceByAlarm", "Hello again from service!");

        long schedTime = System.currentTimeMillis() + 10000; // 10 sec later

        Intent intent = new Intent(this, MainService.class);
        PendingIntent pi = PendingIntent.getService(this, 0, intent, PendingIntent.FLAG_ONE_SHOT);

        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        alarmManager.set(AlarmManager.RTC_WAKEUP, schedTime, pi);

        stopSelf();

        return Service.START_NOT_STICKY;
    }
}
