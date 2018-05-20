package com.example.android.quizitapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class QuestionView extends AppCompatActivity {

    TextView question;
    RadioButton opt1, opt2, opt3, opt4, none;
    RadioGroup options;
    Button submit, skip;
    int qno = 0;
    String ques[], opt[], res[];
    static int acc = 0, wa = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_view);

        question = findViewById(R.id.question);
        opt1 = findViewById(R.id.opt1);
        opt2 = findViewById(R.id.opt2);
        opt3 = findViewById(R.id.opt3);
        opt4 = findViewById(R.id.opt4);
        none = findViewById(R.id.none);
        options = findViewById(R.id.options);
        submit = findViewById(R.id.submit);
        skip = findViewById(R.id.skip);

        if (Home.language.equals("C")) {
            ques = getResources().getStringArray(R.array.cQues);
            opt = getResources().getStringArray(R.array.cOpt);
            res = getResources().getStringArray(R.array.cRes);
        } else if (Home.language.equals("C++")) {
            ques = getResources().getStringArray(R.array.cppQues);
            opt = getResources().getStringArray(R.array.cppOpt);
            res = getResources().getStringArray(R.array.cppRes);
        } else if (Home.language.equals("Java")) {
            ques = getResources().getStringArray(R.array.javaQues);
            opt = getResources().getStringArray(R.array.javaOpt);
            res = getResources().getStringArray(R.array.javaRes);
        } else if (Home.language.equals("Python")) {
            ques = getResources().getStringArray(R.array.pythonQues);
            opt = getResources().getStringArray(R.array.pythonOpt);
            res = getResources().getStringArray(R.array.pythonRes);
        }
        askQuestion();
    }

    public void askQuestion() {
        if (qno == 5) {
            Intent i = new Intent(QuestionView.this, Result.class);
            startActivity(i);
            return;
        }
        question.setText(ques[qno]);
        opt1.setText(opt[4 * qno]);
        opt2.setText(opt[4 * qno + 1]);
        opt3.setText(opt[4 * qno + 2]);
        opt4.setText(opt[4 * qno + 3]);
        none.setChecked(true);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = options.getCheckedRadioButtonId();
                RadioButton selButton = findViewById(id);
                if (selButton.getText().toString().equals("None"))
                    Toast.makeText(QuestionView.this, "Press skip button", Toast.LENGTH_SHORT).show();
                else if (selButton.getText().toString().equals(res[qno])) {
                    acc++;
                    qno++;
                } else {
                    wa++;
                    qno++;
                }
                askQuestion();
            }

        });

        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RadioButton b = findViewById(options.getCheckedRadioButtonId());
                if (b.getText().toString().equals("None"))
                    qno++;
                else
                    Toast.makeText(QuestionView.this, "Select none to skip question", Toast.LENGTH_SHORT).show();
                askQuestion();
            }
        });
    }
}

