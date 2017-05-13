package me.anwarshahriar.fragmentintro;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class FragmentB extends Fragment {
    OnFragmentBMessageListener listener;

    @BindView(R.id.field_name)
    EditText fieldName;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (!(context instanceof OnFragmentBMessageListener)) {
            throw new RuntimeException("Activity must implement OnFragmentBMessageListener");
        }
        listener = (OnFragmentBMessageListener) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_b, container, false);
        ButterKnife.bind(this, view);

        return view;
    }

    @OnClick(R.id.button_send)
    public void sendToA() {
        listener.onMessageFromB(fieldName.getText().toString());
    }

    public void onMessage(String message) {
        fieldName.setText(message);
    }

    interface OnFragmentBMessageListener {
        void onMessageFromB(String message);
    }
}
