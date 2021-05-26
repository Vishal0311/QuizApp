package com.vishal.quizapp_professionalcipher;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class scoreboard_C extends AppCompatActivity {

    ProgressBar circleProgress;
    TextView currScore;
    TextView maxScore ;
    Button playAgain;
    int correct,wrong;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scoreboard_java);

        circleProgress=findViewById(R.id.progress_bar);
        currScore=findViewById(R.id.currentScore);
        maxScore=findViewById(R.id.highestScore);
        playAgain=findViewById(R.id.playAgain);

        correct=getIntent().getIntExtra("correct",0);
        wrong=getIntent().getIntExtra("wrong",0);

        circleProgress.setProgress(correct);

        SharedPreferences getShared=getSharedPreferences("demo",MODE_PRIVATE);
        String val=getShared.getString("javaMax","-1");
        maxScore.setText(val);

        String curr=correct+"/10";
        currScore.setText(curr);
        int max= Integer.parseInt(maxScore.getText().toString());
        max=Math.max(max,correct);
        String m=String.valueOf(max);
        maxScore.setText(m);

        SharedPreferences shrd = getSharedPreferences("demo", MODE_PRIVATE);
        SharedPreferences.Editor editor = shrd.edit();
        editor.putString("javaMax",m);
        editor.apply();



        playAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(scoreboard_C.this,MainActivity.class));
            }
        });

    }
}