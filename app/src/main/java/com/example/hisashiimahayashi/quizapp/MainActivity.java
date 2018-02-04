package com.example.hisashiimahayashi.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 問題一覧画面へ
        Button toQuestionList = findViewById(R.id.to_question_list);
        toQuestionList.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplication(), QuestionListActivity.class);
                startActivity(intent);
            }
        });
    }
}
