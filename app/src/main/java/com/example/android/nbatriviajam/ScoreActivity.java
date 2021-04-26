package com.example.android.nbatriviajam;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ScoreActivity extends AppCompatActivity {

    TextView correctText;
    TextView incorrectText;
    TextView winOrLose;
    ImageView jordan;
    Button buttonRestart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        correctText = (TextView) findViewById(R.id.correctsAns);
        incorrectText = (TextView) findViewById(R.id.incorrectsAns);
        winOrLose = (TextView) findViewById(R.id.scoreText);
        jordan = (ImageView) findViewById(R.id.scorePic);
        buttonRestart = (Button) findViewById(R.id.restartButton);

        StringBuffer sCorrect = new StringBuffer();
        sCorrect.append("Corrects: " + TriviaActivity.correct + "\n");
        StringBuffer sIncorrect = new StringBuffer();
        sIncorrect.append("Incorrects: " + TriviaActivity.wrong + "\n");

        correctText.setText(sCorrect);
        incorrectText.setText(sIncorrect);

        if (TriviaActivity.correct > 5) {
            winOrLose.setText("You win!");
            jordan.setImageResource(R.drawable.winningjordan);
        } else {
            winOrLose.setText("You need 6 to win");
            jordan.setImageResource(R.drawable.jordansix);
        }

        TriviaActivity.correct = 0;
        TriviaActivity.wrong = 0;

        buttonRestart.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent inte = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(inte);
            }
        });
    }
}
