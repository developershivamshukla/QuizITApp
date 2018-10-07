package com.example.android.quizitapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Result extends AppCompatActivity {

    TextView language, name, correct, wrong, percent, keepPlaying;
    Button exit,restart;

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
        exit = findViewById(R.id.Exit);
        restart = findViewById(R.id.Restart);

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

        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Result.this,Home.class);
                startActivity(intent);
            }
        });
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishAffinity();
            }
        });

    }
}
