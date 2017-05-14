package me.anwarshahriar.masterdetailflow;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadFragment();
    }

    private void loadFragment() {
        FragmentTransaction transaction =
                getSupportFragmentManager().beginTransaction();
        Fragment blank = new BlankFragment();
        transaction.add(R.id.container, blank);
        transaction.commit();
    }

    public void load2(View view) {
        FragmentTransaction transaction =
                getSupportFragmentManager().beginTransaction();
        Fragment blank = new BlankFragment2();
        transaction.add(R.id.container, blank);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
