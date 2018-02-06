package com.example.android.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    //Switch to Q1
        // Find the View that shows the numbers category
        Button startQuizButton = findViewById(R.id.start_button);

        // Set a click listener on that View
        startQuizButton.setOnClickListener(new View.OnClickListener() {

            // The code in this method will be executed when the numbers View is clicked on.
            @Override
            public void onClick(View view) {
                Intent startQuizIntent = new Intent(MainActivity.this, Question1.class);
                startActivity(startQuizIntent);
            }
        });

    }



}
