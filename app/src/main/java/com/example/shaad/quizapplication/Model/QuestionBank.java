package com.example.shaad.quizapplication.Model;

import java.io.Serializable;

public class QuestionBank implements Serializable {
    private String CorrectAnswer;
    private String ImageQuestion;
    private String Option1;
    private String Option2;
    private String Option3;
    private String Option4;
    private String QuestionText;

    //subjectCode

    public QuestionBank() {
    }

    public QuestionBank(String correctAnswer, String imageQuestion, String option1, String option2, String option3, String option4, String questionText) {
        CorrectAnswer = correctAnswer;
        ImageQuestion = imageQuestion;
        Option1 = option1;
        Option2 = option2;
        Option3 = option3;
        Option4 = option4;
        QuestionText = questionText;
    }

    public String getCorrectAnswer() {
        return CorrectAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        CorrectAnswer = correctAnswer;
    }

    public String getImageQuestion() {
        return ImageQuestion;
    }

    public void setImageQuestion(String imageQuestion) {
        ImageQuestion = imageQuestion;
    }

    public String getOption1() {
        return Option1;
    }

    public void setOption1(String option1) {
        Option1 = option1;
    }

    public String getOption2() {
        return Option2;
    }

    public void setOption2(String option2) {
        Option2 = option2;
    }

    public String getOption3() {
        return Option3;
    }

    public void setOption3(String option3) {
        Option3 = option3;
    }

    public String getOption4() {
        return Option4;
    }

    public void setOption4(String option4) {
        Option4 = option4;
    }

    public String getQuestionText() {
        return QuestionText;
    }

    public void setQuestionText(String questionText) {
        QuestionText = questionText;
    }
}
