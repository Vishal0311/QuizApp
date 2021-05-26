package com.vishal.quizapp_professionalcipher;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import java.util.Collections;
import java.util.List;

import static com.vishal.quizapp_professionalcipher.MainActivity.javaQues;

public class quiz_JAVA extends AppCompatActivity {

    CountDownTimer countDownTimer;
    int timerVal=20;
    ProgressBar progressBar;
    Dialog dialog;
    List<Model_JAVA>javaList;
    Model_JAVA modelJAVA;
    int index=0;
    TextView question,optiona,optionb,optionc,optiond;
    CardView cardOa,cardOb,cardOc,cardOd;
    int correctCount=0;
    int wrongCount=0;

    Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_java);

        question=findViewById(R.id.cardQuestion);
        optiona=findViewById(R.id.optiona);
        optionb=findViewById(R.id.optionb);
        optionc=findViewById(R.id.optionc);
        optiond=findViewById(R.id.optiond);
        cardOa=findViewById(R.id.cardView2);
        cardOb=findViewById(R.id.cardView3);
        cardOc=findViewById(R.id.cardView4);
        cardOd=findViewById(R.id.cardView5);
        progressBar=findViewById(R.id.progressBar);
        next=findViewById(R.id.next);

        javaList=javaQues;
        Collections.shuffle(javaList);
        modelJAVA =javaList.get(index);



        countDownTimer=new CountDownTimer(20000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timerVal=timerVal-1;
                progressBar.setProgress(timerVal);
            }
            @Override
            public void onFinish() {
                dialog=new Dialog(quiz_JAVA.this);
                dialog.getWindow().addFlags(WindowManager.LayoutParams.FLAG_BLUR_BEHIND);
                dialog.setContentView(R.layout.timeout);
                dialog.setCancelable(false);
                dialog.findViewById(R.id.exit).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(quiz_JAVA.this,MainActivity.class));
                    }
                });
                dialog.show();

            }
        }.start();
        setAllData();
    }

    private void setAllData() {
        question.setText(modelJAVA.getQuestion());
        optiona.setText(modelJAVA.getaA());
        optionb.setText(modelJAVA.getaB());
        optionc.setText(modelJAVA.getaC());
        optiond.setText(modelJAVA.getaD());
        timerVal=20;
        countDownTimer.cancel();
        countDownTimer.start();
    }
    public void correct(CardView card){
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                correctCount++;
                if(index<javaList.size()-1){
                    index++;
                    modelJAVA =javaList.get(index);
                    setAllData();
                    resetColor();
                    enableButton();
                }else{
                    GameWon();
                }

            }
        });

    }
    public void wrong(CardView card){
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wrongCount++;
                if(index<javaList.size()-1){
                    index++;
                    modelJAVA =javaList.get(index);
                    setAllData();
                    resetColor();
                    enableButton();
                }else{
                    GameWon();
                }
            }
        });
    }


    public void enableButton(){
        cardOa.setClickable(true);
        cardOb.setClickable(true);
        cardOc.setClickable(true);
        cardOd.setClickable(true);
    }
    public void disableButton(){
        cardOa.setClickable(false);
        cardOb.setClickable(false);
        cardOc.setClickable(false);
        cardOd.setClickable(false);
    }
    public void resetColor(){
        cardOa.setBackgroundColor(getResources().getColor(R.color.myColor));
        cardOb.setBackgroundColor(getResources().getColor(R.color.myColor));
        cardOc.setBackgroundColor(getResources().getColor(R.color.myColor));
        cardOd.setBackgroundColor(getResources().getColor(R.color.myColor));
    }

    public void optionAClick(View view) {
        Toast.makeText(this, "Answer marked", Toast.LENGTH_SHORT).show();
        disableButton();
        next.setClickable(true);
        if(modelJAVA.getaA().equals(modelJAVA.getAns())){
            if(index<javaList.size()-1){
                correct(cardOa);
            }else{
                GameWon();
            }
        }else{
            wrong(cardOa);
        }
    }

    public void optionBClick(View view) {
        Toast.makeText(this, "Answer marked", Toast.LENGTH_SHORT).show();
        disableButton();
        next.setClickable(true);
        if(modelJAVA.getaB().equals(modelJAVA.getAns())){
            if(index<javaList.size()-1){
                correct(cardOb);
            }else{
                GameWon();
            }
        }else{
            wrong(cardOb);
        }
    }

    public void optionCClick(View view) {
        Toast.makeText(this, "Answer marked", Toast.LENGTH_SHORT).show();
        disableButton();
        next.setClickable(true);
        if(modelJAVA.getaC().equals(modelJAVA.getAns())){
            if(index<javaList.size()-1){
                correct(cardOc);
            }else{
                GameWon();
            }
        }else{

            wrong(cardOc);
        }
    }

    public void optionDClick(View view) {
        Toast.makeText(this, "Answer marked", Toast.LENGTH_SHORT).show();
        disableButton();
        next.setClickable(true);
        if(modelJAVA.getaD().equals(modelJAVA.getAns())){
            if(index<javaList.size()-1){
              correct(cardOd);
            }else{
                GameWon();
            }
        }else{
            wrong(cardOd);
        }
    }



    private void GameWon() {
        Intent intent=new Intent(quiz_JAVA.this, scoreboard_C.class);
        intent.putExtra("correct",correctCount);
        intent.putExtra("wrong",wrongCount);
        startActivity(intent);
    }
}