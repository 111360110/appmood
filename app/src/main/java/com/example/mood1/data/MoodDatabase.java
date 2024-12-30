package com.example.mood1.data;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;


@Database(entities = {Mood.class}, version = 2)
public abstract class MoodDatabase extends RoomDatabase {
    private static MoodDatabase instance;

    public abstract MoodDao moodDao();

    public static synchronized MoodDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                            MoodDatabase.class, "mood_database")
                    .addMigrations(MIGRATION_1_2)
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }
    // 定義遷移策略
    public static final Migration MIGRATION_1_2 = new Migration(1, 2) {
        @Override
        public void migrate(SupportSQLiteDatabase database) {
            // 添加新的日記字段
            database.execSQL("ALTER TABLE mood_table ADD COLUMN diary TEXT");
        }
    };
}
