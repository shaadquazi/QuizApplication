package com.example.shaad.quizapplication.Model;

/**
 * Created by Shaad on 12-11-2017.
 */

public class Student {
    private String firstName;
    private String lastName;
    private String password;
    private String branch;
    private String semester;
    private String section;

    public Student() {
    }

    public Student(String firstName, String lastName, String password, String branch, String semester, String section) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.branch = branch;
        this.semester = semester;
        this.section = section;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", password='" + password + '\'' +
                ", branch='" + branch + '\'' +
                ", semester='" + semester + '\'' +
                ", section='" + section + '\'' +
                '}';
    }
}
