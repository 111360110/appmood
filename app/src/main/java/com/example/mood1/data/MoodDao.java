package com.example.mood1.data;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import java.util.List;

@Dao
public interface MoodDao {
    @Insert
    void insert(Mood mood);

    @Query("SELECT * FROM mood_table ORDER BY timestamp DESC")
    List<Mood> getAllMoods();

    @Query("SELECT moodType FROM mood_table ORDER BY timestamp DESC LIMIT 1")
    String getLatestMood();

    // 返回完整的 Mood 對象，包含情緒類型和日記內容
    @Query("SELECT * FROM mood_table WHERE timestamp >= :startOfDay AND timestamp < :startOfDay + 86400000 LIMIT 1")
    Mood getMoodForToday(long startOfDay);
}
