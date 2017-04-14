package it.englab.androidcourse.threads.anr;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import it.englab.androidcourse.threads.R;

public class ANRActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anr);

        findViewById(R.id.button_start_thread).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                anrExample();
            }
        });
        findViewById(R.id.button_secondary).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("ANR", "Vorrei fare altro!");
            }
        });
    }


    private void anrExample() {
        try {
            Thread.sleep(5000);
            Toast.makeText(getApplicationContext(), "Il nostro fantastico codice ha finito!", Toast.LENGTH_SHORT).show();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
