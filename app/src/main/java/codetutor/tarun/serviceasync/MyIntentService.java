package codetutor.tarun.serviceasync;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.util.Log;

public class MyIntentService extends IntentService {

    private static final String TAG = MyIntentService.class.getSimpleName();

    public MyIntentService() {
        super("MyWorkerThread");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate: Thread Name: "+Thread.currentThread().getName());
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy Thread Name: "+Thread.currentThread().getName());


    }


    @Override
    protected void onHandleIntent(Intent intent) {

        Log.d(TAG, "onHandleIntent Thread Name: "+Thread.currentThread().getName());
        int sleepTime= intent.getIntExtra("sleepTime",1);
        int counter = 0;

        //Dummy Long Operation
        while (counter <= sleepTime) {
            Log.d(TAG, "While Loop Counter: " + counter + " ,Thread: " + Thread.currentThread().getName());

            try {
                Thread.sleep(sleepTime * 100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            counter++;

        }


    }


}
