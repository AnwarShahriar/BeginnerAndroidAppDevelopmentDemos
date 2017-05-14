package me.anwarshahriar.masterdetail;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView listNames;
    List<String> names;
    boolean isDetailViewAvailable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init() {
        loadNames();

        listNames = (RecyclerView) findViewById(R.id.list_names);
        LinearLayoutManager manager =
                new LinearLayoutManager(this,
                                        LinearLayoutManager.VERTICAL,
                                        false);
        NameAdapter adapter = new NameAdapter();
        listNames.setLayoutManager(manager);
        listNames.addItemDecoration(
                new DividerItemDecoration(this,
                                          DividerItemDecoration.VERTICAL));
        listNames.setAdapter(adapter);

        if (findViewById(R.id.container) != null) {
            isDetailViewAvailable = true;
            Fragment detail = new DetailFragment();
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.container, detail)
                    .commit();
        }
    }

    private void loadNames() {
        names = new ArrayList<>();
        names.add("Shanto");
        names.add("Abu Darda");
        names.add("Boishakhi");
        names.add("Nafis");
        names.add("Al-Amin");
        names.add("Juboraj");
        names.add("Faisal");
    }

    private void showDetail(String name) {
        if (!isDetailViewAvailable) {
            Toast.makeText(this, name, Toast.LENGTH_SHORT).show();
        } else {
            DetailFragment detail =
                    (DetailFragment) getSupportFragmentManager()
                        .findFragmentById(R.id.container);
            detail.showName(name);
        }
    }

    private class NameAdapter extends RecyclerView.Adapter<NameAdapter.NameViewHolder> {

        @Override
        public NameViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item, parent, false);
            return new NameViewHolder(view);
        }

        @Override
        public void onBindViewHolder(NameViewHolder holder, int position) {
            holder.bind(names.get(position));
        }

        @Override
        public int getItemCount() {
            return names.size();
        }

        class NameViewHolder extends RecyclerView.ViewHolder {
            TextView textName;

            public NameViewHolder(View itemView) {
                super(itemView);
                textName = (TextView) itemView.findViewById(R.id.text_name);
            }

            void bind(final String name) {
                textName.setText(name);
                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        showDetail(name);
                    }
                });
            }
        }
    }
}
