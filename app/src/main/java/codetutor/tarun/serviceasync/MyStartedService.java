package codetutor.tarun.serviceasync;

import android.app.Service;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;


public class MyStartedService extends Service {


    private static final String TAG = MyStartedService.class.getSimpleName();


    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate: ThreadName: " + Thread.currentThread().getName());
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        // PERFORM ALL TASKS HERE
        int sleepTime = intent.getIntExtra("sleepTime", 1);
        new MyAsyncTask().execute(sleepTime);

        Log.d(TAG, "onStartCommand: ThreadName: " + Thread.currentThread().getName());
        return super.onStartCommand(intent, flags, startId);

    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.d(TAG, "onBind: " + Thread.currentThread().getName());
        return null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ThreadName: " + Thread.currentThread().getName());
    }


    class MyAsyncTask extends AsyncTask<Integer, String, Void> {
        private final String TAG = MyAsyncTask.class.getSimpleName();

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Log.d(TAG, "onPreExecute: ThreadName: " + Thread.currentThread().getName());
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            Log.d(TAG, "onPostExecute: ThreadName: " + Thread.currentThread().getName());
            //STOP THE SERVICE
            stopSelf();
        }

        @Override
        protected void onProgressUpdate(String... values) {
            super.onProgressUpdate(values);
            Log.d(TAG, "onProgressUpdate: ThreadName: " + Thread.currentThread().getName());

            Toast.makeText(MyStartedService.this, "COUNT: " + values[0], Toast.LENGTH_SHORT).show();

        }

        //Perform Long Running Tasks in doInBackground
        @Override
        protected Void doInBackground(Integer... integers) {
            Log.d(TAG, "doInBackground: ThreadName: " + Thread.currentThread().getName());

            int sleepTime = integers[0];
            int counter = 0;
            
            //Dummy Long Operation
            while (counter <= sleepTime) {
                Log.d(TAG, "While Loop Counter: " + counter + "Thtread: " + Thread.currentThread().getName());
                publishProgress("Counter: " + counter);

                try {
                    Thread.sleep(sleepTime * 100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                counter++;

            }
            return null;
        }
    }
}
