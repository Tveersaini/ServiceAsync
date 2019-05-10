package codetutor.tarun.serviceasync;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;



public class MyStartedService extends Service {


private static final String TAG = MyStartedService.class.getSimpleName();






    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate: ThreadName "+Thread.currentThread().getName());
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        // PERFORM ALL TASKS HERE
        int sleepTime=intent.getIntExtra("sleepTime",1);
        try {
            Thread.sleep(sleepTime * 1000);
        } catch (InterruptedException e) {

        }

        Log.d(TAG, "onStartCommand: ThreadName"+Thread.currentThread().getName());
        return super.onStartCommand(intent, flags, startId);
        
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.d(TAG, "onBind: "+Thread.currentThread().getName());
        return null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ThreadName"+Thread.currentThread().getName());
    }
}
