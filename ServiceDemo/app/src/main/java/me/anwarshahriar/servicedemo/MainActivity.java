package me.anwarshahriar.servicedemo;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    BoundService boundService;

    Button buttonStart, buttonStop, buttonAdd;

    boolean connected;
    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            connected = true;
            BoundService.NafisBinder binder = (BoundService.NafisBinder) service;
            boundService = binder.getService();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            connected = false;
            boundService = null;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init() {
        buttonStart = (Button) findViewById(R.id.button_start);
        buttonStop = (Button) findViewById(R.id.button_stop);
        buttonAdd = (Button) findViewById(R.id.button_add);

        buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startService();
            }
        });

        buttonStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopService();
            }
        });
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (connected) {
                    int result = boundService.add(2, 2);
                    Toast.makeText(MainActivity.this,
                            String.valueOf(result),
                            Toast.LENGTH_SHORT)
                            .show();
                }
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Intent serviceIntent = new Intent(this, BoundService.class);
        bindService(serviceIntent, connection, BIND_AUTO_CREATE);
    }

    @Override
    protected void onStop() {
        super.onStop();
        unbindService(connection);
    }

    private void stopService() {
        Intent intent = new Intent(this, MyService.class);
        stopService(intent);
    }

    private void startService() {
        Intent intent = new Intent(this, MyService.class);
        intent.putExtra("url", "http://blabla.com/bla.mp3");
        startService(intent);
    }
}
