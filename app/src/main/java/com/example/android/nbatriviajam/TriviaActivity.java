package com.example.android.nbatriviajam;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class TriviaActivity extends AppCompatActivity {

    TextView question;
    RadioGroup radio_group;
    RadioButton rb1;
    RadioButton rb2;
    RadioButton rb3;
    RadioButton rb4;
    Button nextButton;
    Button exitButton;
    public static int marks = 0, correct = 0, wrong = 0;

    String questions[] = {
            "Who is the top scorer in NBA history?",
            "Which franchise won the NBA championship more times?",
            "What's the name of the New York Knicks arena?",
            "How many rings won Duncan, Parker and Ginobili together with the San Antonio Spurs?",
            "How long is the 3-point line in the NBA?",
            "Who is the NBA All-Time assist leader?",
            "In which year did Vince Carter win the All-Star Slam Dunk contest?",
            "What's the only franchise to blew a 3-1 lead in the NBA Finals history?",
            "Who is the head coach with the most NBA rings?",
            "What NBA player scored 100 points in just one game?"
    };
    String options[] = {
            "Michael Jordan", "Kareem Abdul-Jabbar", "Lebron James", "Karl Malone",
            "Detroit Pistons", "Chicago Bulls", "Boston Celtics", "Houston Rockets",
            "Madison School Garden", "Barclays Center", "Knicks Garden", "Madison Square Garden",
            "4", "2", "3", "5",
            "22-ft 1.75-inch (6.75 m)", "23-ft 9-inch (7.24 m)", "20-ft 9-inch (6.32 m)", "22 feet (6.7 m)",
            "Magic Johnson", "Allen Iverson", "Jason Kidd", "John Stockton",
            "1999", "2000", "2001", "2003",
            "Orlando Magic", "Minnesota Timberwolves", "Los Angeles Clippers", "Golden State Warriors",
            "Gregg Popovich", "Chuck Daly", "Pat Riley", "Phil Jackson",
            "Kobe Bryant", "Wilt Chamberlain", "Brian Scalabrine", "Michael Jordan"
    };
    String answers[] = {"Kareem Abdul-Jabbar", "Boston Celtics", "Madison Square Garden", "4", "23-ft 9-inch (7.24 m)", "John Stockton", "2000", "Golden State Warriors", "Phil Jackson", "Wilt Chamberlain"};
    int flag = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trivia);

        nextButton = (Button) findViewById(R.id.buttonNext);
        exitButton = (Button) findViewById(R.id.buttonExit);
        question = (TextView) findViewById(R.id.question);

        radio_group = (RadioGroup) findViewById(R.id.answers_group);
        rb1 = (RadioButton) findViewById(R.id.radioButton);
        rb2 = (RadioButton) findViewById(R.id.radioButton2);
        rb3 = (RadioButton) findViewById(R.id.radioButton3);
        rb4 = (RadioButton) findViewById(R.id.radioButton4);

        question.setText(questions[flag]);

        rb1.setText(options[0]);
        rb2.setText(options[1]);
        rb3.setText(options[2]);
        rb4.setText(options[3]);

        nextButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (radio_group.getCheckedRadioButtonId() == -1) {
                    Toast.makeText(getApplicationContext(), "Select one option", Toast.LENGTH_SHORT).show();
                    return;
                }

                RadioButton ans = (RadioButton) findViewById(radio_group.getCheckedRadioButtonId());
                String ansText = ans.getText().toString();

                if (ansText.equals(answers[flag])) {
                    correct++;
                } else {
                    wrong++;
                }

                flag++;

                if (flag < questions.length) {

                    question.setText(questions[flag]);
                    rb1.setText(options[flag * 4]);
                    rb2.setText(options[flag * 4 + 1]);
                    rb3.setText(options[flag * 4 + 2]);
                    rb4.setText(options[flag * 4 + 3]);
                } else {
                    marks = correct;
                    Intent in = new Intent(getApplicationContext(), ScoreActivity.class);
                    startActivity(in);
                }

                radio_group.clearCheck();
            }
        });

        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inte = new Intent(getApplicationContext(), ScoreActivity.class);
                startActivity(inte);
            }
        });
    }
}
