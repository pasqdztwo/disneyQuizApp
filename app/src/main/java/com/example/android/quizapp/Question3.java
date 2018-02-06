package com.example.android.quizapp;

import android.content.Intent;
import android.media.MediaPlayer;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class Question3 extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question3);
    }

    int score = 0;

    public void countScore(View view) {

        EditText UserInputAnswerQ3 = findViewById(R.id.llama_king_edittext);
        String userAnswer = UserInputAnswerQ3.getText().toString();

        //get score saved in previous question
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            score = extras.getInt("score");

            if (userAnswer.toLowerCase().equals("kuzco")){
                score++;
                Toast.makeText(getApplicationContext(), R.string.correct_toast, Toast.LENGTH_SHORT).show();
                Intent submitAnswerIntent = new Intent(Question3.this, Question4.class);
                submitAnswerIntent.putExtra("score", score);
                startActivity(submitAnswerIntent);

            } else if (userAnswer.toLowerCase().equals("cuzco")||userAnswer.toLowerCase().equals("cuzko")) {
                Toast.makeText(getApplicationContext(), R.string.llama_close_toast, Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getApplicationContext(), R.string.incorrect_toast, Toast.LENGTH_SHORT).show();
                Intent submitAnswerIntent = new Intent(Question3.this, Question4.class);
                submitAnswerIntent.putExtra("score", score);
                startActivity(submitAnswerIntent);
            }
        }
    }
}
