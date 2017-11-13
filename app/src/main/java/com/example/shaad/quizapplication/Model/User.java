package com.example.shaad.quizapplication.Model;

public class User {
    private String firstName;
    private String lastName;
    private String userType;
    private String branch;
    private String password;
    private String semester;
    private String section;


    public User() {
    }

    public User(String firstName, String lastName, String userType, String branch, String password, String semester, String section) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userType = userType;
        this.branch = branch;
        this.password = password;
        this.semester = semester;
        this.section = section;
    }

    public static User instaceOfStudent(String firstName, String lastName, String userType, String branch, String password, String semester, String section) {
        return new User(firstName, lastName, userType, branch, password, semester, section);
    }

    public static User instanceOdExaminer(String firstName, String lastName, String userType, String branch, String password) {
        return new User(firstName, lastName, userType, branch, password, "null", "null");
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

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", userType='" + userType + '\'' +
                ", branch='" + branch + '\'' +
                ", password='" + password + '\'' +
                ", semester='" + semester + '\'' +
                ", section='" + section + '\'' +
                '}';
    }
}
