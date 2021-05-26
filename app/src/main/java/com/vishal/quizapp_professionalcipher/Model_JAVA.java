package com.vishal.quizapp_professionalcipher;

public class Model_JAVA {

    String question;
    String aA;
    String aB;
    String aC;
    String aD;
    String ans;

    public Model_JAVA(String question, String aA, String aB, String aC, String aD, String ans) {
        this.question = question;
        this.aA = aA;
        this.aB = aB;
        this.aC = aC;
        this.aD = aD;
        this.ans = ans;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getaA() {
        return aA;
    }

    public void setaA(String aA) {
        this.aA = aA;
    }

    public String getaB() {
        return aB;
    }

    public void setaB(String aB) {
        this.aB = aB;
    }

    public String getaC() {
        return aC;
    }

    public void setaC(String aC) {
        this.aC = aC;
    }

    public String getaD() {
        return aD;
    }

    public void setaD(String aD) {
        this.aD = aD;
    }

    public String getAns() {
        return ans;
    }

    public void setAns(String ans) {
        this.ans = ans;
    }
}
