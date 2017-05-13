package me.anwarshahriar.fragmentintro;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        implements FragmentB.OnFragmentBMessageListener,
        FragmentA.OnFragmentAMessageListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onMessageFromB(String message) {
        FragmentA fragmentA = (FragmentA) getSupportFragmentManager()
                .findFragmentById(R.id.fragmentA);
        fragmentA.onMessage(message);
    }

    @Override
    public void onMessageFromA(String message) {
        FragmentB fragmentB = (FragmentB) getSupportFragmentManager()
                .findFragmentById(R.id.fragmentB);
        fragmentB.onMessage(message);
    }
}
