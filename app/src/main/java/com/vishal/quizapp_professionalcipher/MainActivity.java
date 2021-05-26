package com.vishal.quizapp_professionalcipher;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView quizJava,quizC;
    public static ArrayList<Model_JAVA> javaQues;
    public static ArrayList<Model_C> cQues;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        quizC=findViewById(R.id.cplusplus);
        quizJava=findViewById(R.id.java);

        javaQues=new ArrayList<>();
        javaQues.add(new Model_JAVA("Which of the following is a legal identifier in java ?","2variable","+@$var","#myvar","$_myvar","$_myvar"));
        javaQues.add(new Model_JAVA("Which of these is NOT a valid keyword or reserved word in Java ?","default","String","null","volatile","String"));
        javaQues.add(new Model_JAVA("Which of the following Array declaration statement is illegal ?","int [ ] a [ ] = new int [4] [4];","int a[ ][ ] = new int [4] [4];","int a[ ] [ ] = new int [ ] [4];","int [ ] a [ ] = new int [4] [ ];","int a[ ][ ] = new int [4] [4];"));
        javaQues.add(new Model_JAVA("Which is the legal range of values for a short ?","-128 to 127","-256 to 255","-32768 to 32767","0 to 65535","-32768 to 32767"));
        javaQues.add(new Model_JAVA("Which one of the following is invalid declaration of a char ?","char c1 = 064770;","char c2 = 'face';","char c3 = 0xbeef;","char c4 = '\uface';","char c2 = 'face';"));
        javaQues.add(new Model_JAVA("Which of the following class defines print() and println() method ?","System class","InputStream class","Object class","PrintStream class","PrintStream class"));
        javaQues.add(new Model_JAVA("Which operator will always evaluate all the Operands?","||","&&","?:","%","%"));
        javaQues.add(new Model_JAVA("Which operator will find remainder?","/","&&","*","%","%"));
        javaQues.add(new Model_JAVA("Which class cannot be a subclass in java?","Abstract class","Parent class","Final class","None of the above","Final class"));
        javaQues.add(new Model_JAVA("A Suspended thread can be revived by using?","start() method","suspend() method","resume() method","yield() method","resume() method"));


        cQues=new ArrayList<>();
        cQues.add(new Model_C("Which header file should we include for using std::auto_ptr?","memory","alloc","autoptr","smartptr","memory"));
        cQues.add(new Model_C("Size hierarchy for floating point numbers is : float < double < long float","true","false","maybe true","maybe false","false"));
        cQues.add(new Model_C("Destructor has the same name as the constructor and it is preceded by ______ .","!","?","~","$","~"));
        cQues.add(new Model_C("You can never use or compute address of _________ variable ?","local","static","register","global","register"));
        cQues.add(new Model_C("Default storage class for local variables is ?","auto","static","register","extern","auto"));
        cQues.add(new Model_C("cout stands for __________.","class output","character output","common output","call output","common output"));
        cQues.add(new Model_C("Function which is defined inside a class is by default treated as","virtual","public","inline","none of these","inline"));
        cQues.add(new Model_C("Function overloading do not depend on _______ .","number of parameter","order of parameter","differ in type of parameter"," return values"," return values"));
        cQues.add(new Model_C("Which of the following cannot be declared as template?","Global functions","Classes","Member functions","Macros","Macros"));
        cQues.add(new Model_C("What does a compiler add to an empty class declaration in C++ ?","a constructor","a destructor","assignment operator","all of the above","all of the above"));



        quizC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, quiz_C.class));
            }
        });
        quizJava.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, quiz_JAVA.class));
            }
        });
    }
}