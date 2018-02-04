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

public class QuestionActivity extends AppCompatActivity {

    // 何問目か
    private int questionNum = 1;
    // 問題データを取り扱う暮らす
    private TrueOrFalse trueOrFalse = new TrueOrFalse();
    // 問題データ
    private HashMap questionDataList;
    static final int RESULT_SUBACTIVITY = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question);

        // 問題データを取得
        questionDataList = trueOrFalse.getQuestionData(questionNum);

        // 問題内容をセット
        String contents = questionDataList.get("contents").toString();
        TextView questionText = findViewById(R.id.question_text);
        questionText.setText(contents);

        // はい
        Button yes = findViewById(R.id.yes);
        yes.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplication(), QuestionResultActivity.class);
                intent.putExtra("answer", 0);
                intent.putExtra("question_num", questionNum);
                // 画面の呼び出し
                startActivityForResult(intent, RESULT_SUBACTIVITY);
            }
        });

        // いいえ
        Button no = findViewById(R.id.no);
        no.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplication(), QuestionResultActivity.class);
                intent.putExtra("answer", 1);
                intent.putExtra("question_num", questionNum);
                // 画面の呼び出し
                startActivityForResult(intent, RESULT_SUBACTIVITY);
            }
        });

        // 戻る
        Button returnButton = findViewById(R.id.return_question_list);
        returnButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
            }
        });
    }

    protected void onActivityResult( int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        TextView nextQuestionNum = findViewById(R.id.question_num);
        // インテントに保存されたデータを取得して、問題数、内容を更新
        if(resultCode == RESULT_OK && requestCode == RESULT_SUBACTIVITY &&
                null != intent) {
            questionNum = intent.getIntExtra("question_num", 0);
            // 問題数を＋1する
            questionNum++;
            // 問題数(何問目か)をセット
            nextQuestionNum.setText(String.valueOf(questionNum));
            // 問題データを取得
            questionDataList = trueOrFalse.getQuestionData(questionNum);
            // 問題内容をセット
            String contents = questionDataList.get("contents").toString();
            TextView questionText = findViewById(R.id.question_text);
            questionText.setText(contents);
        }
    }

}
