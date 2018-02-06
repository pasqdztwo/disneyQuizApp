package com.example.android.quizapp;

import android.content.Intent;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class Question1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question1);
    }

    int score = 0;

    public void countScore(View view) {
        RadioButton correctAnswerRB = findViewById(R.id.Q1A3_button);

        // Check which radio button was clicked
        if (correctAnswerRB.isChecked()) {
            score++;
        }

        Intent submitAnswerIntent = new Intent(Question1.this, Question2.class);
        submitAnswerIntent.putExtra("score", score);
        startActivity(submitAnswerIntent);
    }
}


