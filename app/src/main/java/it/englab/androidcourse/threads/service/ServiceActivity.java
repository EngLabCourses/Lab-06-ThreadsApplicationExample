package it.englab.androidcourse.threads.service;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import it.englab.androidcourse.threads.R;

public class ServiceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);

        findViewById(R.id.button_start_thread).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startServiceANR();
            }
        });
        findViewById(R.id.button_secondary).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("THREAD", "Vorrei fare altro!");
            }
        });
    }

    private void startServiceANR() {
        MyService.startCommandAnrStart(this);
    }

    private void startIntentService() {
        MyIntentService.startAction(this, "param1");
    }
}
