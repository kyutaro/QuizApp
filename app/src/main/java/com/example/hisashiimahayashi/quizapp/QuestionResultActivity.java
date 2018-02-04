package com.example.hisashiimahayashi.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.HashMap;

/**
 * Created by imahayashi on 2017/11/13.
 */

public class QuestionResultActivity extends AppCompatActivity {

    private int questionNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question_result);

        // インテントを取得
        Intent intent = getIntent();
        // 問題数(何問目か)を取得
        questionNum = intent.getIntExtra("question_num", 0);

        // 問題データを取得
        TrueOrFalse trueOrFalse = new TrueOrFalse();
        HashMap questionDataList = trueOrFalse.getQuestionData(questionNum);

        // 答え合わせ
        String tmp = questionDataList.get("answer").toString();
        int answer = new Integer(tmp).intValue();
        int userAnswer = intent.getIntExtra("answer", 0);
        TextView questionResult = findViewById(R.id.question_result);
        if(answer == userAnswer) {
            questionResult.setText("正解");
        } else {
            questionResult.setText("不正解");
        }

        // 次の問題画面へ
        Button toQuestionResult = findViewById(R.id.to_question);
        // 次の問題がある場合はボタンを表示
        if(questionNum < 3) {
            toQuestionResult.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Intent intent = new Intent(getApplication(), QuestionActivity.class);
                    intent.putExtra("question_num", questionNum);
                    setResult(RESULT_OK, intent);
                    finish();
                    //startActivity(intent);
                }
            });
        } else {
            // 次の問題がない場合はボタンを非表示
            toQuestionResult.setVisibility(View.GONE);
            // 問題を全て解き終わった旨を表示
            TextView questionEnd = findViewById(R.id.question_end);
            questionEnd.setVisibility(View.VISIBLE);
        }

        // 質問一覧に戻る
        Button toQuestionList = findViewById(R.id.return_question_list);
        toQuestionList.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplication(), QuestionListActivity.class);
                startActivity(intent);
            }
        });
    }
}
