package it.englab.androidcourse.threads.handlerthread;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.Process;
import android.util.Log;

/**
 * Created by spawn on 10/04/17.
 */

public class MyHandlerThread extends HandlerThread {

    private Handler mHandler;

    public MyHandlerThread() {

        super("MyHandlerThread", Process.THREAD_PRIORITY_BACKGROUND);
    }

    @Override
    protected void onLooperPrepared() {
        super.onLooperPrepared();

        mHandler = new Handler(getLooper()) {

            @Override
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 0:
                        try {
                            sleep(2000);
                            Log.d("MyHandlerThread", "Configurazione salvata correttamente");
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        break;
                }
            }

        };

    }

    public void saveConfiguration() {
        mHandler.sendEmptyMessage(0);
    }

}
