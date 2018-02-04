package com.example.hisashiimahayashi.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by imahayashi on 2017/11/09.
 */

public class QuestionListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question_list);

        // 問題画面へ
        Button toQuestion = findViewById(R.id.to_question);
        toQuestion.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplication(), QuestionActivity.class);
                startActivity(intent);
            }
        });

        // TOPへ戻る
        Button returnMain = findViewById(R.id.return_main);
        returnMain.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplication(), MainActivity.class);
                startActivity(intent);
            }
        });

    }

}
