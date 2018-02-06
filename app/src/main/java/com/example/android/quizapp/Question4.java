package com.example.android.quizapp;

import android.content.Intent;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;

public class Question4 extends AppCompatActivity {

    int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question4);
    }

    public void countScore(View view) {

        //get score saved in previous question
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            score = extras.getInt("score");
        }

        //declare names for checkboxes
        CheckBox correctAnswerCB1 = findViewById(R.id.Q4A3_box);
        CheckBox correctAnswerCB2 = findViewById(R.id.Q4A5_box);
        CheckBox incorrectAnswerCB1 = findViewById(R.id.Q4A1_box);
        CheckBox incorrectAnswerCB2 = findViewById(R.id.Q4A2_box);
        CheckBox incorrectAnswerCB3 = findViewById(R.id.Q4A4_box);
        CheckBox incorrectAnswerCB4 = findViewById(R.id.Q4A6_box);

        //check if no incorrect answer was checked
        boolean incorrectAnswersChecked = false;

        if ((incorrectAnswerCB1.isChecked()) || (incorrectAnswerCB2.isChecked()) || (incorrectAnswerCB3.isChecked()) || (incorrectAnswerCB4.isChecked())) {
            incorrectAnswersChecked = true;
        } else {
            incorrectAnswersChecked = false;
        }

        //assign score
        if ((correctAnswerCB1.isChecked()) && (correctAnswerCB2.isChecked()) && (incorrectAnswersChecked == false)) {
            score = score + 2;
        } else if (((correctAnswerCB1.isChecked()) || (correctAnswerCB2.isChecked())) && (incorrectAnswersChecked == false)) {
            score++;
        }

        Intent submitAnswerIntent = new Intent(Question4.this, Question5.class);
        submitAnswerIntent.putExtra("score", score);
        startActivity(submitAnswerIntent);
    }
}

