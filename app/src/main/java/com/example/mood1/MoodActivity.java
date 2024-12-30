package com.example.mood1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;

import com.example.mood1.data.Mood;
import com.example.mood1.data.MoodDatabase;

public class MoodActivity extends AppCompatActivity {
    private EditText diaryInput; // 新增日記輸入框變數

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mood);

        // 綁定日記輸入框
        diaryInput = findViewById(R.id.edt_diary);

        // 綁定所有按鈕，並記錄對應的情緒
        findViewById(R.id.btn_happy).setOnClickListener(v -> saveMood("開心"));
        findViewById(R.id.btn_sad).setOnClickListener(v -> saveMood("難過"));
        findViewById(R.id.btn_stressed).setOnClickListener(v -> saveMood("緊張"));
        findViewById(R.id.btn_calm).setOnClickListener(v -> saveMood("平靜"));
        findViewById(R.id.btn_excited).setOnClickListener(v -> saveMood("興奮"));
        findViewById(R.id.btn_angry).setOnClickListener(v -> saveMood("生氣"));
        findViewById(R.id.btn_tired).setOnClickListener(v -> saveMood("疲憊"));
    }

    private void saveMood(String moodType) {
        // 獲取日記內容
        String diary = diaryInput.getText().toString().trim();

        // 建立新的情緒記錄
        Mood newMood = new Mood(moodType, System.currentTimeMillis(), diary);

        // 將記錄存入資料庫
        new Thread(() -> {
            MoodDatabase.getInstance(this).moodDao().insert(newMood);

            // 調試日誌：打印出情緒和日記內容
            Log.d("MoodActivity", "Inserted mood: " + moodType + ", Diary: " + diary);
            // 更新 UI 提示保存成功
            runOnUiThread(() -> {
                Toast.makeText(this, "記錄成功：" + moodType, Toast.LENGTH_SHORT).show();
                // 返回主畫面
                Intent intent = new Intent(MoodActivity.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish(); // 結束當前 Activity，避免重複堆疊
            });
        }).start();
    }

    @Override
    public void finish() {
        super.finish();

        // 添加返回動畫
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }
}
