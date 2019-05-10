package codetutor.tarun.serviceasync;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startService(View view)
    {
        Intent intent=new Intent(MainActivity.this,MyStartedService.class);
        intent.putExtra("sleepTime",10);
        startService(intent);
    }

    public void stopService(View view) {
        Intent intent=new Intent(MainActivity.this,MyStartedService.class);
        stopService( intent);
    }

    public void startIntentService(View view) {

        Intent intent=new Intent(MainActivity.this,MyIntentService.class);
        intent.putExtra("sleepTime",10);
        startService(intent);
    }
}
