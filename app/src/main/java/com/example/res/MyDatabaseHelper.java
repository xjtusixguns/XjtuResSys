package com.example.res;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MyDatabaseHelper extends SQLiteOpenHelper {
    private Context context;

    public MyDatabaseHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        this.context = context;
    }

    private String createUser = "create table User ("
            + "id integer primary key autoincrement,"
            + "UserName text unique,"
            + "UserPWD text)";

    private String createOrder = "create table Orders ("
            + "UserId integer ,"
            + "OrderContext text)";

    public void onCreate(SQLiteDatabase db) {
        db.execSQL(createUser);
        db.execSQL(createOrder);
        Toast.makeText(this.context, "Create user table successed!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists User");
        db.execSQL("drop table if exists Orders");
        onCreate(db);
    }
}
