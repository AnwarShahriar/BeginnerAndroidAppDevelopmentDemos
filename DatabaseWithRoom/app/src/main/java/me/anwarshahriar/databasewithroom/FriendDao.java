package me.anwarshahriar.databasewithroom;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface FriendDao {

    @Insert
    void addFriend(Friend friend);

    @Query("SELECT * FROM Friend")
    LiveData<List<Friend>> loadFriends();
}
