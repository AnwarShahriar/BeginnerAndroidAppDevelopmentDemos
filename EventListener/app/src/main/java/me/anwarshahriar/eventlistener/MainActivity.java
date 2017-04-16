package me.anwarshahriar.eventlistener;

import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonSubmit = (Button) findViewById(R.id.button_submit);

        EventListener listener = new EventListener();
        buttonSubmit.setOnClickListener(listener);
    }

    private class EventListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            Toast.makeText(getApplicationContext(), "Baishakhi", Toast.LENGTH_LONG).show();
        }
    }
}
