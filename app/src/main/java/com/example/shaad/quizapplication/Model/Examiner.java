package com.example.shaad.quizapplication.Model;

/**
 * Created by Shaad on 12-11-2017.
 */

public class Examiner {
    private String firstName;
    private String lastName;
    private String password;
    private String branch;

    public Examiner() {
    }

    public Examiner(String firstName, String lastName, String password, String branch) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.branch = branch;
    }

    @Override
    public String toString() {
        return "Examiner{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", password='" + password + '\'' +
                ", branch='" + branch + '\'' +
                '}';
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
}
