package com.example.android.quizapp;

import android.content.Intent;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;

public class Question5 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question5);
    }

    int score = 0;

    public void countScore(View view) {


        //get score saved in previous question
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            score = extras.getInt("score");

            RadioButton correctAnswerRB = findViewById(R.id.Q5A4_button);

            // Check which radio button was clicked
            if (correctAnswerRB.isChecked()) {
                score++;
            }
        }

        Intent submitAnswerIntent = new Intent(Question5.this, Question6.class);
        submitAnswerIntent.putExtra("score", score);
        startActivity(submitAnswerIntent);
    }
}
