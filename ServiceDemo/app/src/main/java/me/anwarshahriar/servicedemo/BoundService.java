package me.anwarshahriar.servicedemo;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

public class BoundService extends Service {
    private NafisBinder binder = new NafisBinder();

    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }

    public class NafisBinder extends Binder {
        public BoundService getService() {
            return BoundService.this;
        }
    }

    public int add(int a, int b) {
        return a + b;
    }
}
