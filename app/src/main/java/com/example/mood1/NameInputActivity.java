package com.example.mood1;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class NameInputActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name_input);

        final EditText nameEditText = findViewById(R.id.edit_name);

        findViewById(R.id.btn_submit_name).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameEditText.getText().toString();

                // 使用 Intent 傳遞使用者輸入的姓名到 MainActivity
                Intent intent = new Intent(NameInputActivity.this, MainActivity.class);
                intent.putExtra("user_name", name);
                startActivity(intent);
                finish();  // 關閉當前的 NameInputActivity
            }
        });
    }
}