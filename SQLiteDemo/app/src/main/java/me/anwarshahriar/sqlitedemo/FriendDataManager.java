package me.anwarshahriar.sqlitedemo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class FriendDataManager {
    DBHelper helper;
    SQLiteDatabase db;

    public FriendDataManager(Context context) {
        helper = new DBHelper(context);
    }

    public void open() {
        db = helper.getWritableDatabase();
    }

    public void close() {
        helper.close();
    }

    public void addFriend(Friend friend) {
        ContentValues values = new ContentValues();
        values.put(DBHelper.NAME, friend.getName());

        db.insert(DBHelper.TABLE_NAME, null, values);
    }

    public List<Friend> loadFriends() {
        Cursor cursor =
                db.rawQuery("SELECT * FROM " + DBHelper.TABLE_NAME, null);
        List<Friend> friends = new ArrayList<>();

        while (cursor.moveToNext()){
            Friend friend = new Friend();
            int id = cursor.getInt(cursor.getColumnIndex(DBHelper._ID));
            String name = cursor.getString(cursor.getColumnIndex(DBHelper.NAME));
            friend.setId(id);
            friend.setName(name);

            friends.add(friend);
        }

        cursor.close();
        return friends;
    }
}
