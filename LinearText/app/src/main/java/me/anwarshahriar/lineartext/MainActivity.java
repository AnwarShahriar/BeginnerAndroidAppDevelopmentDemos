package me.anwarshahriar.lineartext;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    LinearLayout container;
    EditText fieldName;
    Button add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        container = (LinearLayout) findViewById(R.id.container);
        fieldName = (EditText) findViewById(R.id.field_name);
        add = (Button) findViewById(R.id.button_add);

        AddListener addListener = new AddListener();
        add.setOnClickListener(addListener);
    }

    private class AddListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            String name = fieldName.getText().toString();

            if (name.length() == 0) {
                Toast.makeText(MainActivity.this,
                        "Please enter a name", Toast.LENGTH_SHORT).show();
            } else {
                TextView textName = new TextView(MainActivity.this);
                LinearLayout.LayoutParams params =
                        new LinearLayout.LayoutParams(
                                ViewGroup.LayoutParams.MATCH_PARENT,
                                100);
                textName.setPadding(50, 0, 0, 0);
                textName.setLayoutParams(params);
                textName.setGravity(Gravity.CENTER_VERTICAL);
                textName.setText(name);
                textName.setTextSize(22);

                container.addView(textName);
            }
        }
    }
 }
