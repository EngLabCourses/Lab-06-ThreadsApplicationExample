package it.englab.androidcourse.threads.service;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 */
public class MyIntentService extends IntentService {
    private static final String ACTION_START = "it.englab.androidcourse.threads.service.action.START";
    private static final String EXTRA_PARAM_WORK_LENGHT = "it.englab.androidcourse.threads.service.extra.WORKLENGHT";
    private static final String TAG = MyIntentService.class.getName();

    public MyIntentService() {
        super("MyIntentService");
    }

    /**
     * Starts this service to perform action Foo with the given parameters. If
     * the service is already performing a task this action will be queued.
     *
     * @see IntentService
     */
    public static void startAction(Context context, long millis) {
        Intent intent = new Intent(context, MyIntentService.class);
        intent.setAction(ACTION_START);
        intent.putExtra(EXTRA_PARAM_WORK_LENGHT, millis);
        context.startService(intent);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            final String action = intent.getAction();
            if (ACTION_START.equals(action)) {
                final long millis = intent.getLongExtra(EXTRA_PARAM_WORK_LENGHT, 0L);
                handleActionFoo(millis);
            }
        }
    }

    /**
     * Handle action Start in the provided background thread with the provided
     * parameters.
     */
    private void handleActionFoo(long millis) {
        try {
            Log.d(TAG, "Lavoro in background iniziato...");
            Thread.sleep(millis);
            Log.d(TAG, "Lavoro completato!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
