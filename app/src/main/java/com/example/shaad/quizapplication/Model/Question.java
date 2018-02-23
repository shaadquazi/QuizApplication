package com.example.shaad.quizapplication.Model;


public class Question {
    private String mQuestion;
    private String mImage;
    private String mOptionA;
    private String mOptionB;
    private String mOptionC;
    private String mOptionD;
    private String mCorrectAnswer;
    private String isQuestionImage;

    public Question() {
    }

    public Question(String mQuestion, String mImage, String mOptionA, String mOptionB, String mOptionC, String mOptionD, String mCorrectAnswer, String isQuestionImage) {
        this.mQuestion = mQuestion;
        this.mImage = mImage;
        this.mOptionA = mOptionA;
        this.mOptionB = mOptionB;
        this.mOptionC = mOptionC;
        this.mOptionD = mOptionD;
        this.mCorrectAnswer = mCorrectAnswer;
        this.isQuestionImage = isQuestionImage;
    }

    public String getmQuestion() {
        return mQuestion;
    }

    public void setmQuestion(String mQuestion) {
        this.mQuestion = mQuestion;
    }

    public String getmImage() {
        return mImage;
    }

    public void setmImage(String mImage) {
        this.mImage = mImage;
    }

    public String getmOptionA() {
        return mOptionA;
    }

    public void setmOptionA(String mOptionA) {
        this.mOptionA = mOptionA;
    }

    public String getmOptionB() {
        return mOptionB;
    }

    public void setmOptionB(String mOptionB) {
        this.mOptionB = mOptionB;
    }

    public String getmOptionC() {
        return mOptionC;
    }

    public void setmOptionC(String mOptionC) {
        this.mOptionC = mOptionC;
    }

    public String getmOptionD() {
        return mOptionD;
    }

    public void setmOptionD(String mOptionD) {
        this.mOptionD = mOptionD;
    }

    public String getmCorrectAnswer() {
        return mCorrectAnswer;
    }

    public void setmCorrectAnswer(String mCorrectAnswer) {
        this.mCorrectAnswer = mCorrectAnswer;
    }

    public String getIsQuestionImage() {
        return isQuestionImage;
    }

    public void setIsQuestionImage(String isQuestionImage) {
        this.isQuestionImage = isQuestionImage;
    }
}
