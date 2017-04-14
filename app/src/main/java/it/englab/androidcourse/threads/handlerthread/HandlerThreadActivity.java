package it.englab.androidcourse.threads.handlerthread;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import it.englab.androidcourse.threads.R;

public class HandlerThreadActivity extends AppCompatActivity {

    private MyHandlerThread mMyHandlerThread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler_thread);

        mMyHandlerThread = new MyHandlerThread();
        mMyHandlerThread.start();

        findViewById(R.id.button_start_save_configuration).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMyHandlerThread.saveConfiguration();
            }
        });
    }

    @Override
    protected void onDestroy() {
        mMyHandlerThread.quit();
        super.onDestroy();
    }
}
