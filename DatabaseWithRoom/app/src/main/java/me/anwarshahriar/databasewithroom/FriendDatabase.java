package me.anwarshahriar.databasewithroom;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {Friend.class}, version = 1)
public abstract class FriendDatabase extends RoomDatabase {

    public abstract FriendDao friendDao();
}
