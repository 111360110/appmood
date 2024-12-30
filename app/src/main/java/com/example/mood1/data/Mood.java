package com.example.mood1.data;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "mood_table")
public class Mood {
    @PrimaryKey(autoGenerate = true)
    private int id;

    private String diary; // 新增日記字段

    private String moodType;
    private long timestamp;

    public Mood(String moodType, long timestamp, String diary) {
        this.moodType = moodType;
        this.timestamp = timestamp;
        this.diary = diary;
    }

    // Getter 和 Setter 方法
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getMoodType() { return moodType; }
    public void setMoodType(String moodType) { this.moodType = moodType; }
    public long getTimestamp() { return timestamp; }
    public void setTimestamp(long timestamp) { this.timestamp = timestamp; }
    public String getDiary() { return diary; }
    public void setDiary(String diary) { this.diary = diary; }
}
