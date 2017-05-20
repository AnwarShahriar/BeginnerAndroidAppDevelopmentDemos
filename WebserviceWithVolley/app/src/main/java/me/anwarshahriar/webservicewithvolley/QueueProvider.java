package me.anwarshahriar.webservicewithvolley;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class QueueProvider {
    private static QueueProvider instance;

    private RequestQueue queue;

    private QueueProvider(Context context) {
        queue = Volley.newRequestQueue(context);
    }

    public static synchronized QueueProvider getInstance(Context context) {
        if (instance == null) {
            instance = new QueueProvider(context);
        }
        return instance;
    }

    public RequestQueue getQueue() {
        return queue;
    }
}
