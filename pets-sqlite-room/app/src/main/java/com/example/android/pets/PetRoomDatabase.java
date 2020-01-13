package com.example.android.pets;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {PetEntity.class}, version = 1)
public abstract class PetRoomDatabase extends RoomDatabase {

    public abstract PetDao petDao();

    private static volatile PetRoomDatabase INSTANCE;

    static PetRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (PetRoomDatabase.class) {
                if (INSTANCE == null) {
                    // Create database here
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            PetRoomDatabase.class, "pet_db")
                            .allowMainThreadQueries()
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
