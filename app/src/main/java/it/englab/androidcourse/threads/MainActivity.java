package it.englab.androidcourse.threads;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import it.englab.androidcourse.threads.anr.ANRActivity;
import it.englab.androidcourse.threads.asynctask.AsyncTaskActivity;
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
    }

}
