package com.example.quiz_app.model;


public class Questionmodel {
    private String majorq,question1,question2,question3,question4,correctans;





    public Questionmodel(String majorq, String question1, String question2, String question3, String question4, String correctans  ){


    this.majorq = majorq;
    this.question1 = question1;
    this.question2 = question2;

    this.question3 = question3;

    this.question4 = question4;

    this.correctans = correctans;



}



    public String getMajorq() {
        return majorq;
    }

    public void setMajorq(String majorq) {
        this.majorq = majorq;
    }

    public String getQuestion1() {
        return question1;
    }

    public void setQuestion1(String question1) {
        this.question1 = question1;
    }

    public String getQuestion2() {
        return question2;
    }

    public void setQuestion2(String question2) {
        this.question2 = question2;
    }

    public String getQuestion3() {
        return question3;
    }

    public void setQuestion3(String question3) {
        this.question3 = question3;
    }

    public String getQuestion4() {
        return question4;
    }

    public void setQuestion4(String question4) {
        this.question4 = question4;
    }



    public String getCorrectans() {
        return correctans;
    }

    public void setCorrectans(String correctans) {
        this.correctans = correctans;
    }
}

