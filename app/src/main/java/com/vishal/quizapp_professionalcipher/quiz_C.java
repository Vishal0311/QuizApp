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

import static com.vishal.quizapp_professionalcipher.MainActivity.cQues;

public class quiz_C extends AppCompatActivity {


    CountDownTimer countDownTimer;
    int timerVal=20;
    ProgressBar progressBarC;
    Dialog dialog;
    List<Model_C> CList;
    Model_C modelC;
    int index=0;
    TextView questionC,optionCa,optionCb,optionCc,optionCd;
    CardView cardOCa,cardOCb,cardOCc,cardOCd;
    int correctCCount=0;
    int wrongCCount=0;

    Button nextC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_c);

        questionC=findViewById(R.id.cardQuestionC);
        optionCa=findViewById(R.id.optionaC);
        optionCb=findViewById(R.id.optionbC);
        optionCc=findViewById(R.id.optioncC);
        optionCd=findViewById(R.id.optiondC);
        cardOCa=findViewById(R.id.cardView2C);
        cardOCb=findViewById(R.id.cardView3C);
        cardOCc=findViewById(R.id.cardView4C);
        cardOCd=findViewById(R.id.cardView5C);
        progressBarC=findViewById(R.id.progressBarC);
        nextC=findViewById(R.id.nextC);


        CList=cQues;
        Collections.shuffle(CList);
        modelC=CList.get(index);

        countDownTimer=new CountDownTimer(20000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timerVal=timerVal-1;
                progressBarC.setProgress(timerVal);
            }
            @Override
            public void onFinish() {
                dialog=new Dialog(quiz_C.this);
                dialog.getWindow().addFlags(WindowManager.LayoutParams.FLAG_BLUR_BEHIND);
                dialog.setContentView(R.layout.timeout);
                dialog.setCancelable(false);
                dialog.findViewById(R.id.exit).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(quiz_C.this,MainActivity.class));
                    }
                });
                dialog.show();

            }
        }.start();
        setAllData();

    }
    private void setAllData() {
        questionC.setText(modelC.getCquestion());
        optionCa.setText(modelC.getaCA());
        optionCb.setText(modelC.getaCB());
        optionCc.setText(modelC.getaCC());
        optionCd.setText(modelC.getaCD());
        timerVal=20;
        countDownTimer.cancel();
        countDownTimer.start();
    }
    public void correct(CardView card){
        nextC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                correctCCount++;
                if(index<CList.size()-1){
                    index++;
                    modelC=CList.get(index);
                    setAllData();
                    resetColor();
                    enableButton();
                }else{
                    GameCWon();
                }

            }
        });
    }
    public void wrong(CardView card){
        nextC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                wrongCCount++;
                if(index<CList.size()-1){
                    index++;
                    modelC=CList.get(index);
                    setAllData();
                    resetColor();
                    enableButton();
                }else{
                    GameCWon();
                }
            }
        });
    }
    public void enableButton(){
        cardOCa.setClickable(true);
        cardOCb.setClickable(true);
        cardOCc.setClickable(true);
        cardOCd.setClickable(true);
    }
    public void disableButton(){
        cardOCa.setClickable(false);
        cardOCb.setClickable(false);
        cardOCc.setClickable(false);
        cardOCd.setClickable(false);
    }
    public void resetColor(){
        cardOCa.setBackgroundColor(getResources().getColor(R.color.myColor));
        cardOCb.setBackgroundColor(getResources().getColor(R.color.myColor));
        cardOCc.setBackgroundColor(getResources().getColor(R.color.myColor));
        cardOCd.setBackgroundColor(getResources().getColor(R.color.myColor));
    }
    public void optionACClick(View view) {
        Toast.makeText(this, "Answer marked", Toast.LENGTH_SHORT).show();
        disableButton();
        nextC.setClickable(true);
        if(modelC.getaCA().equals(modelC.getCans())){
            if(index<CList.size()-1){
                correct(cardOCa);
            }else{
                GameCWon();
            }
        }else{
            wrong(cardOCa);
        }
    }

    public void optionBCClick(View view) {
        Toast.makeText(this, "Answer marked", Toast.LENGTH_SHORT).show();
        disableButton();
        nextC.setClickable(true);
        if(modelC.getaCB().equals(modelC.getCans())){
            if(index<CList.size()-1){
                correct(cardOCb);
            }else{
                GameCWon();
            }
        }else{
            wrong(cardOCb);
        }
    }

    public void optionCCClick(View view) {
        Toast.makeText(this, "Answer marked", Toast.LENGTH_SHORT).show();
        disableButton();
        nextC.setClickable(true);
        if(modelC.getaCC().equals(modelC.getCans())){
            if(index<CList.size()-1){
                correct(cardOCc);
            }else{
                GameCWon();
            }
        }else{
            wrong(cardOCc);
        }
    }

    public void optionDCClick(View view) {
        Toast.makeText(this, "Answer marked", Toast.LENGTH_SHORT).show();
        disableButton();
        nextC.setClickable(true);
        if(modelC.getaCD().equals(modelC.getCans())){
            if(index<CList.size()-1){
                correct(cardOCd);
            }else{
                GameCWon();
            }
        }else{
            wrong(cardOCd);
        }
    }



    private void GameCWon() {
        Intent intent=new Intent(quiz_C.this, scoreboard_JAVA.class);
        intent.putExtra("correct",correctCCount);
        intent.putExtra("wrong",wrongCCount);
        startActivity(intent);
    }
}