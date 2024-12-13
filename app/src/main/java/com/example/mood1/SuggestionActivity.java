package com.example.mood1;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class SuggestionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suggestion);

        // 模擬從資料庫獲取情緒
        String mood = "緊張"; // 假設用戶最近記錄的情緒

        // 根據情緒推薦舒壓活動
        TextView suggestionText = findViewById(R.id.txt_suggestion);
        switch (mood) {
            case "開心":
                suggestionText.setText("推薦活動：記錄今天的快樂時光！");
                break;
            case "難過":
                suggestionText.setText("推薦活動：試試深呼吸，放鬆一下！");
                break;
            case "緊張":
                suggestionText.setText("推薦活動：聽一首輕音樂，平靜心情。");
                break;
            default:
                suggestionText.setText("推薦活動：保持微笑，享受當下！");
                break;
        }
    }
}
