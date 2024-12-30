package com.example.mood1;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.TextView;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        // 找到TextView來顯示歡迎信息
        TextView welcomeTextView = findViewById(R.id.text_welcome);
        welcomeTextView.setText("歡迎來到 Mood 追蹤程式!");

        // 設定延遲 3 秒鐘後跳轉至 MainActivity
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(WelcomeActivity.this, NameInputActivity.class);
                startActivity(intent);
                finish(); // 關閉當前的 WelcomeActivity
            }
        }, 3000);  // 延遲 3 秒
    }
}
