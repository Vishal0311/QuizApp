package com.vishal.quizapp_professionalcipher;

public class Model_C {

    String Cquestion;
    String aCA;
    String aCB;
    String aCC;
    String aCD;

    public Model_C(String cquestion, String aCA, String aCB, String aCC, String aCD, String cans) {
        Cquestion = cquestion;
        this.aCA = aCA;
        this.aCB = aCB;
        this.aCC = aCC;
        this.aCD = aCD;
        Cans = cans;
    }

    String Cans;

    public String getCquestion() {
        return Cquestion;
    }

    public void setCquestion(String cquestion) {
        Cquestion = cquestion;
    }

    public String getaCA() {
        return aCA;
    }

    public void setaCA(String aCA) {
        this.aCA = aCA;
    }

    public String getaCB() {
        return aCB;
    }

    public void setaCB(String aCB) {
        this.aCB = aCB;
    }

    public String getaCC() {
        return aCC;
    }

    public void setaCC(String aCC) {
        this.aCC = aCC;
    }

    public String getaCD() {
        return aCD;
    }

    public void setaCD(String aCD) {
        this.aCD = aCD;
    }

    public String getCans() {
        return Cans;
    }

    public void setCans(String cans) {
        Cans = cans;
    }
}
