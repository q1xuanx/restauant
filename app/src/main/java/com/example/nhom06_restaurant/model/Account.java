package com.example.nhom06_restaurant.model;

public class Account {
    private String phoneNumber;
    private String isPassword;
    private String fullName;
    private String birthDay;
    private String gender;

    public Account(){

    }
    public Account(String phoneNumber, String isPassword, String fullName, String birthDay, String gender) {
        this.phoneNumber = phoneNumber;
        this.isPassword = isPassword;
        this.fullName = fullName;
        this.birthDay = birthDay;
        this.gender = gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getIsPassword() {
        return isPassword;
    }

    public void setIsPassword(String isPassword) {
        this.isPassword = isPassword;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
