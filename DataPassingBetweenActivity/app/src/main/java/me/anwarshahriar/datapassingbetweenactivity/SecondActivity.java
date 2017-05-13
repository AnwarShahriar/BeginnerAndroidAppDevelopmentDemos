package me.anwarshahriar.datapassingbetweenactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SecondActivity extends AppCompatActivity {

    @BindView(R.id.text_name)
    TextView textName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sencond);
        ButterKnife.bind(this);

        receiveName();
    }

    @OnClick(R.id.button_back)
    public void backName() {
        returnNameBack("Nafis");
    }

    private void returnNameBack(String name) {
        Student nafis = new Student();
        nafis.setName("Nafis");
        Intent intent = new Intent();
        intent.putExtra("nafis", nafis);
        setResult(RESULT_OK, intent);
        finish();
    }

    private void receiveName() {
        Intent receiver = getIntent();
        Student student = receiver.getParcelableExtra("student");
        textName.setText(student.getName());
    }
}
