package com.example.hisashiimahayashi.quizapp;

import java.util.HashMap;

/**
 * Created by HisashiImahayashi on 2018/02/04.
 */

public class TrueOrFalse {

    private HashMap data1 = new HashMap<String, String>() {
        {
            put("id", "1");
            put("contents", "鎌倉時代の創始者は源頼朝である");
            put("answer", "0");
        }
    };

    private HashMap data2 = new HashMap<String, String>() {
        {
            put("id", "2");
            put("contents", "徳川幕府最後の将軍は徳川家康である");
            put("answer", "1");
        }
    };

    private HashMap data3 = new HashMap<String, String>() {
        {
            put("id", "3");
            put("contents", "邪馬台国の女王は卑弥呼である");
            put("answer", "0");
        }
    };

    public HashMap getQuestionData(int questionNum) {

        System.out.println("問題数");
        System.out.println(questionNum);
        if(questionNum == 1) {
            return data1;
        } else if(questionNum == 2) {
            return data2;
        } else {
            return data3;
        }

    }


}
