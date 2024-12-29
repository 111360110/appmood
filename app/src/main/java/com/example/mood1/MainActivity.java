package com.example.mood1;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.TextView;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;


public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 獲取從 NameInputActivity 傳遞過來的姓名
        Intent intent = getIntent();
        String userName = intent.getStringExtra("user_name");

        // 顯示歡迎訊息
        TextView welcomeTextView = findViewById(R.id.text_welcome);
        if (userName != null && !userName.isEmpty()) {
            welcomeTextView.setText("歡迎, " + userName + "!");
        } else {
            welcomeTextView.setText("歡迎, 使用者!");
        }



        // 找到TextView來顯示時間
        TextView timeTextView = findViewById(R.id.text_time);

        // 使用台灣地區的時間格式
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.TAIWAN);

        // 設置時區為台灣時區 (Asia/Taipei)
        sdf.setTimeZone(TimeZone.getTimeZone("Asia/Taipei"));

        // 獲取當前時間並格式化
        String currentTime = sdf.format(new Date());

        // 顯示當前時間
        timeTextView.setText("當前時間: " + currentTime);



        // 記錄情緒按鈕
        findViewById(R.id.btn_record_mood).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, MoodActivity.class));
            }
        });

        // 舒壓建議按鈕
        findViewById(R.id.btn_suggestions).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SuggestionActivity.class));
            }
        });
    }
}
