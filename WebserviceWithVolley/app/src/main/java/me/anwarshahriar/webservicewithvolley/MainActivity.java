package me.anwarshahriar.webservicewithvolley;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;

public class MainActivity extends AppCompatActivity {
    TextView textNames;
    RequestQueue queue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textNames = (TextView) findViewById(R.id.text_names);
        queue = QueueProvider.getInstance(getApplicationContext())
                    .getQueue();

        loadHumans();
    }

    private void loadHumans() {
        JsonArrayRequest request =
                new JsonArrayRequest(Request.Method.GET,
                        "http://10.0.2.2:3000/humans",
                        null,
                        new Response.Listener<JSONArray>() {
                            @Override
                            public void onResponse(JSONArray response) {
                                textNames.setText(response.toString());
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                error.printStackTrace();
                                textNames.setText("Error occurred");
                            }
                        });

        queue.add(request);
    }
}
