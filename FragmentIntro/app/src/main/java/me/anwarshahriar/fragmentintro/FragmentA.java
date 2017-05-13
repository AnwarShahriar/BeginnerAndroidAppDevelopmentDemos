package me.anwarshahriar.fragmentintro;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentA extends Fragment {
    OnFragmentAMessageListener listener;

    @BindView(R.id.field_name)
    EditText fieldName;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (!(context instanceof OnFragmentAMessageListener)) {
            throw new RuntimeException("Activity must implement OnFragmentAMessageListener");
        }
        listener = (OnFragmentAMessageListener) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_a, container, false);
        ButterKnife.bind(this, view);

        return view;
    }

    @OnClick(R.id.button_send)
    public void sendToB() {
        listener.onMessageFromA(fieldName.getText().toString());
    }

    public void onMessage(String message) {
        fieldName.setText(message);
    }

    public interface OnFragmentAMessageListener {
        void onMessageFromA(String message);
    }

}
