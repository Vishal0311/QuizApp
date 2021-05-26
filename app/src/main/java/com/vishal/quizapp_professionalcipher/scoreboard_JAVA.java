package com.vishal.quizapp_professionalcipher;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class scoreboard_JAVA extends AppCompatActivity {

    ProgressBar circleCProgress;
    TextView currCScore;
    TextView maxCScore ;
    Button playCAgain;
    int correctC,wrongC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scoreboard_c);


        circleCProgress=findViewById(R.id.progress_bar);
        currCScore=findViewById(R.id.currentScore);
        maxCScore=findViewById(R.id.highestScore);
        playCAgain=findViewById(R.id.playAgain);


        correctC=getIntent().getIntExtra("correct",0);
        wrongC=getIntent().getIntExtra("wrong",0);

        circleCProgress.setProgress(correctC);

        SharedPreferences getShared=getSharedPreferences("demo",MODE_PRIVATE);
        String val=getShared.getString("cMax","-1");
        maxCScore.setText(val);


        String curr=correctC+"/10";
        currCScore.setText(curr);
        int max= Integer.parseInt(maxCScore.getText().toString());
        max=Math.max(max,correctC);
        String m=String.valueOf(max);
        maxCScore.setText(m);


        SharedPreferences shrd = getSharedPreferences("demo", MODE_PRIVATE);
        SharedPreferences.Editor editor = shrd.edit();
        editor.putString("cMax",m);
        editor.apply();

        playCAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(scoreboard_JAVA.this,MainActivity.class));
            }
        });



    }
}