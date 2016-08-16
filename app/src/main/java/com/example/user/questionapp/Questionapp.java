package com.example.user.questionapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

/**
 * Created by user on 16/08/2016.
 */
public class Questionapp extends AppCompatActivity {

    EditText mQuestionEditText;
    //TextView mAnswerText;
    Button mShakeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mQuestionEditText = (EditText)findViewById(R.id.question_text);
        //mAnswerText = (TextView)findViewById(R.id.answer_text);
        mShakeButton = (Button)findViewById(R.id.shake_button);

        mShakeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String question = mQuestionEditText.getText().toString();
                Log.d("Questionapp:", "Shake button clicked!");
                Log.d("Questionapp:", "The question asked was'" + question + "'");
//                mAnswerText.setText("Computer says 'No'!");

                String answer = randomAnswer();
                Intent intent = new Intent(Questionapp.this, AnswerActivity.class);
                intent.putExtra("answer", answer);
                Log.d("Questionapp:", "passing through '" + answer + "'");
                startActivity(intent);
            }

            public String randomAnswer() {
                String[] options = new String[5];

                options[0] = "Sleep on memory foam";
                options[1] = "Look for the resident squirrel";
                options[2] = "Swim in the sea";
                options[3] = "Find things to eat on the beach";
                options[4] = "Chew his bone";

                Random rand = new Random();
                int n = rand.nextInt(5);

                return options[n];
            }
        });
    }
}
