package com.example.mood1;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.mood1.data.MoodDatabase;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

public class SuggestionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suggestion);

        // 獲取最新情緒並顯示建議
        fetchLatestMoodAndDisplaySuggestion();

        Button backToMainButton = findViewById(R.id.btn_back_to_main);
        backToMainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 啟動 MainActivity 並關閉當前活動
                Intent intent = new Intent(SuggestionActivity.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // 清除堆疊中的其他活動
                startActivity(intent);
                finish();
            }
        });
    }

    // 從資料庫獲取最新情緒
    private void fetchLatestMoodAndDisplaySuggestion() {
        MoodDatabase database = MoodDatabase.getInstance(this);
        new Thread(() -> {
            String latestMood = database.moodDao().getLatestMood();
            runOnUiThread(() -> displaySuggestion(latestMood));
        }).start();
    }

    // 根據情緒顯示建議
    private void displaySuggestion(String mood) {
        TextView suggestionText = findViewById(R.id.txt_suggestion);
        if (mood == null || mood.isEmpty()) {
            // 如果沒有記錄任何情緒
            suggestionText.setText("推薦活動：尚未記錄情緒，試著開始記錄心情吧！");
            return;
        }

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
