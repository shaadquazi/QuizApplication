package com.example.shaad.quizapplication.Model;

import java.io.Serializable;
import java.util.Map;

public class Subject implements Serializable {
    private String Name;
    private String Code;
    private String Credits;
    private Map<String, QuestionBank> QuestionBank;

    public Subject() {
    }

    public Subject(String name, String code, String credits) {
        Name = name;
        Code = code;
        Credits = credits;
    }

    public Subject(String name, String code, String credits, Map<String, com.example.shaad.quizapplication.Model.QuestionBank> questionBank) {
        Name = name;
        Code = code;
        Credits = credits;
        QuestionBank = questionBank;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getCode() {
        return Code;
    }

    public void setCode(String code) {
        Code = code;
    }

    public String getCredits() {
        return Credits;
    }

    public void setCredits(String credits) {
        Credits = credits;
    }

    public Map<String, com.example.shaad.quizapplication.Model.QuestionBank> getQuestionBank() {
        return QuestionBank;
    }

    public void setQuestionBank(Map<String, com.example.shaad.quizapplication.Model.QuestionBank> questionBank) {
        QuestionBank = questionBank;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "\nName='" + Name + '\'' +
                ",\n Code='" + Code + '\'' +
                ", \nCredits='" + Credits + '\'' +
                ",\n QuestionBank=" + QuestionBank +
                '}';
    }
}
