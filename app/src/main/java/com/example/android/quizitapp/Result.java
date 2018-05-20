package com.example.android.quizitapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Result extends AppCompatActivity {

    TextView language, name, correct, wrong, percent, keepPlaying;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        language = findViewById(R.id.language);
        name = findViewById(R.id.name);
        correct = findViewById(R.id.correct);
        wrong = findViewById(R.id.wrong);
        percent = findViewById(R.id.percent);
        keepPlaying = findViewById(R.id.keepPlaying);

        int acc = QuestionView.acc;
        int wa = QuestionView.wa;
        double per = acc / 5.00 * 100.00;

        language.setText(Home.language);
        correct.setText("" + acc);
        wrong.setText("" + wa);
        percent.setText("" + per);

        keepPlaying.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Result.this, Home.class);
                startActivity(i);
            }
        });

    }
}
