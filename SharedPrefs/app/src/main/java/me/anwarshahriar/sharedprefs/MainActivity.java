package me.anwarshahriar.sharedprefs;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    SharedPreferences prefs;
    EditText fieldUsername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fieldUsername = (EditText) findViewById(R.id.field_username);

        prefs = getSharedPreferences("user_prefs", MODE_PRIVATE);
        //getPreferences(MODE_PRIVATE);
        //PreferenceManager.getDefaultSharedPreferences(this);
        String username = prefs.getString("username", "");
        fieldUsername.setText(username);
    }

    @Override
    protected void onStop() {
        super.onStop();
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("username", fieldUsername.getText().toString());
        editor.apply();
    }
}
