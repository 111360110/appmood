package com.example.mood1;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.TextView;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;


import com.airbnb.lottie.LottieAnimationView;
import com.example.mood1.data.Mood;
import com.example.mood1.data.MoodDatabase;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

<<<<<<< HEAD

=======
    private TextView todayMoodTextView;
    private TextView todayDiaryTextView;
    private LottieAnimationView lottieAnimationView;
>>>>>>> 59cb55811b1f3e11f15d2ad2148a3a1ee44a3021

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

<<<<<<< HEAD
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
=======
        // 初始化元件
        lottieAnimationView = findViewById(R.id.lottie_animation);
        todayMoodTextView = findViewById(R.id.txt_today_mood);
        todayDiaryTextView = findViewById(R.id.txt_today_diary);
        Button btnRecordMood = findViewById(R.id.btn_record_mood);
        Button btnSuggestions = findViewById(R.id.btn_suggestions);
        Button btnViewChart = findViewById(R.id.btn_view_chart);
        Button btnStopAnimation = findViewById(R.id.btn_stop_animation); // 停止動畫按鈕

        // 顯示今日心情和日記
        displayTodayMood();

        // 點擊記錄心情按鈕
        btnRecordMood.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, MoodActivity.class);
            startActivity(intent);
            // 添加過渡動畫
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
>>>>>>> 59cb55811b1f3e11f15d2ad2148a3a1ee44a3021
        });

        // 點擊查看建議按鈕
        btnSuggestions.setOnClickListener(v -> {
            lottieAnimationView.playAnimation(); // 播放動畫
            Toast.makeText(this, "顯示建議", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainActivity.this, SuggestionActivity.class);
            startActivity(intent);
            // 添加過渡動畫
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        });

        // 點擊查看圖表按鈕
        btnViewChart.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, MoodChartActivity.class);
            startActivity(intent);
            // 添加過渡動畫
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        });

        // 點擊停止動畫按鈕
        btnStopAnimation.setOnClickListener(v -> {
            lottieAnimationView.pauseAnimation(); // 暫停動畫
            Toast.makeText(this, "動畫已停止", Toast.LENGTH_SHORT).show();
        });
    }

    // 顯示今日心情
    protected void displayTodayMood() {
        // 計算今天的開始時間戳
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        long startOfDay = calendar.getTimeInMillis();

        // 獲取資料庫實例
        MoodDatabase database = MoodDatabase.getInstance(this);

        new Thread(() -> {
            // 從資料庫中查詢今天的心情
            Mood todayMood = database.moodDao().getMoodForToday(startOfDay);

            // 更新 UI
            runOnUiThread(() -> {
                if (todayMood != null) {
                    String moodType = todayMood.getMoodType();
                    String diary = todayMood.getDiary();
                    todayMoodTextView.setText("今日心情：" + moodType);
                    todayDiaryTextView.setText("今日日記：" + diary);
                    Log.d("MainActivity", "Fetched mood for today: " + diary);
                } else {
                    todayMoodTextView.setText("今日心情：尚未記錄");
                    todayDiaryTextView.setText("今日日記：尚未記錄");
                    Log.d("MainActivity", "No mood data for today.");
                }
            });
        }).start();
    }

    @Override
    public void finish() {
        super.finish();
        // 返回時的過渡動畫
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }
}
