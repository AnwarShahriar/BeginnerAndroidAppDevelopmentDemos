package me.anwarshahriar.databasewithroom;

import android.arch.lifecycle.LifecycleActivity;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.arch.persistence.room.InvalidationTracker;
import android.arch.persistence.room.Room;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends LifecycleActivity {
    FriendDatabase db;
    LiveData<List<Friend>> friendsLiveData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = Room.databaseBuilder(getApplicationContext(),
                FriendDatabase.class, "frienddb")
                .allowMainThreadQueries()
                .build();

        friendsLiveData = db.friendDao().loadFriends();
    }

    @Override
    protected void onResume() {
        super.onResume();
        friendsLiveData.observe(this, new Observer<List<Friend>>() {
            @Override
            public void onChanged(@Nullable List<Friend> friends) {
                StringBuilder builder = new StringBuilder();
                for (Friend friend : friends) {
                    builder.append(friend.getName());
                    builder.append("\n");
                }
                TextView textFriends =
                        (TextView) findViewById(R.id.text_friends);
                textFriends.setText(builder.toString());
            }
        });
        addSomeFriends();
    }

    @Override
    protected void onPause() {
        super.onPause();
        friendsLiveData.removeObservers(this);
    }

    private void addSomeFriends() {
        Friend darda = new Friend();
        darda.setName("Darda");
        db.friendDao().addFriend(darda);

        Friend shanto = new Friend();
        shanto.setName("Shanto");
        db.friendDao().addFriend(shanto);
    }
}
