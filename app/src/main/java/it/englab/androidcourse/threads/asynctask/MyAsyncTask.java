package it.englab.androidcourse.threads.asynctask;

import android.os.AsyncTask;
import android.util.Log;

/**
 * Created by spawn on 07/04/17.
 */

class MyAsyncTask extends AsyncTask<Integer, Integer, String> {

    private static final String TAG = MyAsyncTask.class.getName();
    private Callaback mCallaback;

    interface Callaback {
        void onTaskProgressing(int progress);

        void onTaskComplete(String status);
    }

    MyAsyncTask(Callaback callaback) {
        mCallaback = callaback;
    }

    @Override
    protected void onPreExecute() {
        Log.d(TAG, "onPreExecute");
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        Log.d(TAG, "Progress..." + values[0]);
        mCallaback.onTaskProgressing(values[0]);
    }

    @Override
    protected String doInBackground(Integer... params) {

        Integer numOfLoops = params[0];
        for (int i = 0; i < numOfLoops; i++) {
            try {

                Thread.sleep(1000);
                if (isCancelled()) break;
                publishProgress(i+1);

            } catch (InterruptedException e) {
                Log.i(TAG, "Thread interrupted!");
            }
        }
        return "ok";
    }

    @Override
    protected void onPostExecute(String s) {
        mCallaback.onTaskComplete(s);
    }

    @Override
    protected void onCancelled() {
        mCallaback = null;
        super.onCancelled();
    }

}
