package com.example.shaad.quizapplication.Model;

public class User {
    private String userName;
    private String userType;
    private String branch;
    private String password;
    private String semester;
    private String section;


    public User() {
    }

    public User(String userName, String userType, String branch, String password, String semester, String section) {
        this.userName = userName;
        this.userType = userType;
        this.branch = branch;
        this.password = password;
        this.semester = semester;
        this.section = section;

    }

    public static User instaceOfStudent(String userName, String userType, String branch, String password, String semester, String section) {
        return new User(userName, userType, branch, password, semester, section);
    }

    public static User instanceOdExaminer(String userName, String userType, String branch, String password) {
        return new User(userName, userType, branch, password, "null", "null");
    }

    public String getuserName() {
        return userName;
    }

    public void setuserName(String userName) {
        this.userName = userName;
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
                "userName='" + userName + '\'' +
                ", userType='" + userType + '\'' +
                ", branch='" + branch + '\'' +
                ", password='" + password + '\'' +
                ", semester='" + semester + '\'' +
                ", section='" + section + '\'' +
                '}';
    }
}
