package me.anwarshahriar.recyclertest;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class NameAdapter extends RecyclerView.Adapter<NameAdapter.NameViewHolder> {

    List<String> names;
    int i = 1;

    public NameAdapter(List<String> names) {
        this.names = names;
    }

    public void addName(String name) {
        names.add(name);
        notifyDataSetChanged();
    }

    @Override
    public NameViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.d("NameAdapter", "Row number: " + i);
        i++;
        View nameViewItem =
                LayoutInflater
                        .from(parent.getContext())
                        .inflate(R.layout.name_item,
                                parent,
                                false);
        NameViewHolder holder = new NameViewHolder(nameViewItem);
        return holder;
    }

    @Override
    public void onBindViewHolder(NameViewHolder holder, int position) {
        View view = holder.itemView;
        TextView textName = (TextView) view.findViewById(R.id.text_name);
        String name = names.get(position);
        textName.setText(name);
    }

    @Override
    public int getItemCount() {
        return names.size();
    }

    public class NameViewHolder extends RecyclerView.ViewHolder {

        public NameViewHolder(View itemView) {
            super(itemView);
        }
    }
}
