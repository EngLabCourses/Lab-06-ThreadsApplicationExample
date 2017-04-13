package it.englab.androidcourse.threads.asynctask;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import it.englab.androidcourse.threads.R;

public class AsyncTaskActivity extends AppCompatActivity implements MyAsyncTask.Callback {

    private static final String TAG = AsyncTaskActivity.class.getName();
    private static final int MAX_ITERATIONS = 15;
    private ProgressBar mProgressBar;
    private MyAsyncTask mMyAsyncTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async_task);

        findViewById(R.id.button_start_asynctask).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                asyncTaskExample();
            }
        });

        mProgressBar = (ProgressBar) findViewById(R.id.progress_bar);
        mProgressBar.setMax(MAX_ITERATIONS);
    }

    @Override
    protected void onResume() {
        super.onResume();
        //Inizializza il valore attuale della progress
        mProgressBar.setProgress(0);
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (mMyAsyncTask != null) {
            mMyAsyncTask.cancel(true);
        }
    }

    @Override
    protected void onDestroy() {
        mMyAsyncTask = null;
        Log.d(TAG, "onDestroy");
        super.onDestroy();
    }

    private void asyncTaskExample() {
        mMyAsyncTask = new MyAsyncTask(this);
        mMyAsyncTask.execute(MAX_ITERATIONS);
    }

    @Override
    public void onTaskProgressing(int progress) {
        Log.d(TAG, "Progress [" + progress + "]");
        mProgressBar.setProgress(progress);
    }

    @Override
    public void onTaskComplete(String status) {
        Toast.makeText(this, "Il nostro lavoro in background è stato completato con status [" + status + "]", Toast.LENGTH_LONG).show();
    }
}
