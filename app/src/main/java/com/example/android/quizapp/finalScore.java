package com.example.android.quizapp;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class finalScore extends AppCompatActivity {

    int score = 0;
    String message;
    AnimationDrawable hakunaMatataAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_score);

        ImageView hakunaMatataIV = findViewById(R.id.hakuna_matata_iv);
        hakunaMatataIV.setBackgroundResource(R.drawable.hakuna_matata);
        hakunaMatataAnimation = (AnimationDrawable) hakunaMatataIV.getBackground();

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            score = extras.getInt("score");
        }
        TextView finalScoreTV = findViewById(R.id.final_score_tv);
        finalScoreTV.setText("" + score);

        if (score == 0) {
            message = getString(R.string.zero_score_message);
        } else if (score <= 3) {
            message = getString(R.string.low_score_message);
        } else if (score < 6) {
            message = getString(R.string.mid_score_message);
        } else {
            message = getString(R.string.high_score_message);
        }

        TextView messageTV = findViewById(R.id.message_tv);
        messageTV.setText("" + message);
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        hakunaMatataAnimation.start();
    }

    public void restartButton(View view) {
        Intent restartIntent = new Intent(finalScore.this, MainActivity.class);
        startActivity(restartIntent);
    }
}
