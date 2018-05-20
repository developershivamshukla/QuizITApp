package com.example.android.quizitapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Home extends AppCompatActivity {

    Button start;
    RadioGroup lang;
    static String language;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        start = findViewById(R.id.start);
        lang = findViewById(R.id.lang);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Home.this, QuestionView.class);
                int id = lang.getCheckedRadioButtonId();
                RadioButton selLang = findViewById(id);
                language = selLang.getText().toString();
                startActivity(i);
            }
        });
    }
}

