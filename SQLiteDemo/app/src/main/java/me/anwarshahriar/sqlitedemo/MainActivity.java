package me.anwarshahriar.sqlitedemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    FriendDataManager friendDataManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        friendDataManager = new FriendDataManager(getApplicationContext());
    }

    @Override
    protected void onResume() {
        super.onResume();
        friendDataManager.open();

        insertSomeFriends();

        showFriends();
    }

    private void showFriends() {
        List<Friend> friendList = friendDataManager.loadFriends();

        StringBuilder builder = new StringBuilder();
        for (Friend friend : friendList) {
            builder.append(friend.getName());
            builder.append("\n");
        }

        ((TextView) findViewById(R.id.text_result))
                .setText(builder.toString());
    }

    private void insertSomeFriends() {
        Friend a = new Friend();
        a.setName("Darda");
        friendDataManager.addFriend(a);

        Friend b = new Friend();
        b.setName("Shanto");
        friendDataManager.addFriend(b);

        Friend c = new Friend();
        c.setName("Faisal");
        friendDataManager.addFriend(c);

        Friend d = new Friend();
        d.setName("Boishakhi");
        friendDataManager.addFriend(d);

        Friend e = new Friend();
        e.setName("Juboraj");
        friendDataManager.addFriend(e);
    }



    @Override
    protected void onPause() {
        super.onPause();
        friendDataManager.close();
    }
}
