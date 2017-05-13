package me.anwarshahriar.datapassingbetweenactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import org.parceler.Parcel;
import org.parceler.Parcels;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    private static final int EXPECT_NAME_BACK = 1;

    @BindView(R.id.field_name)
    EditText fieldName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.button_send)
    public void sendToSecond() {
        String name = fieldName.getText().toString();
        Student student = new Student();
        student.setName(name);

        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("student", Parcels.wrap(student));
        //startActivity(intent);
        startActivityForResult(intent, EXPECT_NAME_BACK);
    }

    @Override
    protected void onActivityResult(int requestCode,
                                    int resultCode,
                                    Intent data) {
        if (resultCode == RESULT_OK) {
            if (requestCode == EXPECT_NAME_BACK) {
                Student student = Parcels.unwrap(data.getParcelableExtra("nafis"));
                fieldName.setText(student.getName());
            }
        }
    }
}
