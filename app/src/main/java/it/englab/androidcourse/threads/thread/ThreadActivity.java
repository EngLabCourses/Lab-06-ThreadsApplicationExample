package it.englab.androidcourse.threads.thread;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import it.englab.androidcourse.threads.R;

public class ThreadActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread);

        findViewById(R.id.button_start_thread).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                threadExample();
            }
        });
        findViewById(R.id.button_secondary).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("THREAD", "Vorrei fare altro!");
            }
        });
    }

    private void threadExample() {

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(15000);
                    Toast.makeText(getApplicationContext(), "Il nostro fantastico codice ha finito!", Toast.LENGTH_SHORT).show();
                    runOnUiThread(new );
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
    }
}
