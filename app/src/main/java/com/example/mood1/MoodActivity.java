package com.example.mood1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MoodActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mood);

        // 記錄心情
        findViewById(R.id.btn_happy).setOnClickListener(v -> saveMood("開心"));
        findViewById(R.id.btn_sad).setOnClickListener(v -> saveMood("難過"));
        findViewById(R.id.btn_stressed).setOnClickListener(v -> saveMood("緊張"));
    }

    private void saveMood(String mood) {
        // 模擬資料儲存（你可以改用 Room Database）
        Toast.makeText(this, "記錄成功：" + mood, Toast.LENGTH_SHORT).show();

        // 返回主畫面
        startActivity(new Intent(MoodActivity.this, MainActivity.class));
    }
}
