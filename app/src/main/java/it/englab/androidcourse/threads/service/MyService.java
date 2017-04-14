package it.englab.androidcourse.threads.service;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {
    private static final String TAG = MyIntentService.class.getName();
    public static final String COMMAND_KEY = "command";
    public static final int COMMAND_ANR_START = 0;

    public MyService() {
    }

    public static void startCommandAnrStart(Context context) {
        Intent intent = new Intent(context, MyService.class);
        intent.putExtra(MyService.COMMAND_KEY, MyService.COMMAND_ANR_START);
        context.startService(intent);
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        int commandKey = intent.getIntExtra(COMMAND_KEY, -1);

        switch (commandKey) {
            case COMMAND_ANR_START:
                doSomeWork();
                stopSelf();
                break;
        }
        return START_NOT_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    private void doSomeWork() {

        try {
            Log.d(TAG, "Lavoro in background iniziato...");
            Thread.sleep(8000L);
            Log.d(TAG, "Lavoro completato!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
