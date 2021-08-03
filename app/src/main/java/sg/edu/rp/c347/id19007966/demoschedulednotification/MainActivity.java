package sg.edu.rp.c347.id19007966.demoschedulednotification;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    int requestCode = 12345;
    Button buttonSchedule;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonSchedule = findViewById(R.id.buttonSchedule);

        buttonSchedule.setOnClickListener(view -> {
            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.SECOND, 5);
            Intent intent = new Intent(MainActivity.this, ScheduledNotificationReceiver.class);

            PendingIntent pendingIntent = PendingIntent.getBroadcast(MainActivity.this, requestCode, intent, PendingIntent.FLAG_CANCEL_CURRENT);

            AlarmManager alarmManager = (AlarmManager) getSystemService(Activity.ALARM_SERVICE);
            alarmManager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent);
        });
    }
}