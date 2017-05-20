package me.anwarshahriar.webservice;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import org.json.JSONException;

import java.io.IOException;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    TextView textNames;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textNames = (TextView) findViewById(R.id.text_names);

        // New Thread
        new LoadHumanTask().execute();

        Log.d(TAG, "This is a log");
    }

    private void printHumans(List<Human> humans) {
        if (humans == null) {
            textNames.setText("No human found");
            return;
        }

        String text = "";
        for (Human human : humans) {
            text += human.getName() + "\n";
        }
        textNames.setText(text);
    }

    private class LoadHumanTask extends AsyncTask<Void, Void, List<Human>> {

        @Override
        protected void onPreExecute() {
            Log.d(TAG, "onPreExecute");
        }

        @Override
        protected List<Human> doInBackground(Void... params) {
            List<Human> humans = null;
            try {
                humans = HumanService.humans();
            } catch (IOException | JSONException e) {
                e.printStackTrace();
            }
            return humans;
        }

        @Override
        protected void onPostExecute(List<Human> humans) {
            Log.d(TAG, "onPostExecute");
            printHumans(humans);
        }
    }
}
