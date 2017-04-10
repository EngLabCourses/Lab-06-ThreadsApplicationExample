package it.englab.androidcourse.threads;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.Process;
import android.util.Log;
import android.view.View;

import it.englab.androidcourse.threads.anr.ANRActivity;
import it.englab.androidcourse.threads.asynctask.AsyncTaskActivity;
import it.englab.androidcourse.threads.handlerthread.HandlerThreadActivity;
import it.englab.androidcourse.threads.thread.ThreadActivity;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.button_anr).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ANRActivity.class));
            }
        });

        findViewById(R.id.button_thread).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ThreadActivity.class));
            }
        });

        findViewById(R.id.button_asynctask).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, AsyncTaskActivity.class));
            }
        });

        findViewById(R.id.button_handlerthread).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, HandlerThreadActivity.class));
            }
        });

        Handler handlerA = new Handler(new Handler.Callback() {
            @Override
            public boolean handleMessage(Message msg) {
                Log.d("HANDLERA", "Message: " + msg.what);
                return true;
            }
        });
        Message messageA1 = handlerA.obtainMessage(0);
        Message messageA2 = handlerA.obtainMessage(1);

        Handler handlerB = new Handler(new Handler.Callback() {
            @Override
            public boolean handleMessage(Message msg) {
                Log.d("HANDLERB", "Message: " + msg.what);
                return true;
            }
        });
        Message messageB1 = handlerB.obtainMessage(2);
        Message messageB2 = handlerB.obtainMessage(3);
        Message messageWithTarget = Message.obtain();
        messageWithTarget.what = 4;
        messageWithTarget.setTarget(handlerA);

        handlerA.sendMessage(messageA1);
        handlerB.sendMessage(messageB1);
        handlerB.post(new Runnable() {
            @Override
            public void run() {
                Log.d("RUNNABLE", "Runnable task!");
            }
        });
        messageWithTarget.sendToTarget();
        handlerA.sendMessage(messageA2);
        handlerB.sendMessage(messageB2);
    }

}
