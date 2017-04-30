package me.anwarshahriar.recyclertest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivty";

    RecyclerView listViewNames;
    Button buttonAdd;
    EditText fieldName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listViewNames = (RecyclerView) findViewById(R.id.list_view_names);
        buttonAdd = (Button) findViewById(R.id.button_add);
        fieldName = (EditText) findViewById(R.id.field_name);

        // Special lines ;)
        LinearLayoutManager linearLayoutManager =
                new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        listViewNames.setLayoutManager(linearLayoutManager);

        final NameAdapter adapter = new NameAdapter(getNames());
        listViewNames.addItemDecoration(
                new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        listViewNames.setAdapter(adapter);

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = fieldName.getText().toString();
                adapter.addName(name);
            }
        });

        Log.d("MainActivity", "Hash: " + listViewNames);
    }

    public List<String> getNames() {
        List<String> names = new ArrayList<>();
        names.add("Boishakhi");
        names.add("Shanto");
        names.add("Al-Amin");
        names.add("Juboraj");
        names.add("Rumi");
        names.add("Faisal");
        for (int i = 0; i < 20; i++) {
            names.add("Row name - " + (i + 1));
        }
        return names;
    }
}
