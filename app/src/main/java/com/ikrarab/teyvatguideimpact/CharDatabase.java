package com.ikrarab.teyvatguideimpact;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {CharEntity.class}, version = 1)
public abstract class CharDatabase extends RoomDatabase {
    private static final String DB_NAME = "charDatabase.db";
    private static volatile CharDatabase instance;

    static synchronized CharDatabase getInstance(Context context){
        if(instance == null){
            instance = create(context);
        }
        return instance;
    }

    private static CharDatabase create(final Context context){
        return Room.databaseBuilder(
                context,
                CharDatabase.class,
                DB_NAME).build();
    }
    public abstract CharDao getCharDao();
}
