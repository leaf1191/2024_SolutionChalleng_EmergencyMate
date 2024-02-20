package com.example.demo;


import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class User {

    @Getter
    private Role role;
    private String uid;
    private String fcmToken;

    private String email;
    private String number;
    private String waitNumber;
    @Getter
    private String name;
    @Getter
    private String date;
    private String gender;
    @Getter
    private String symptom;
    private String bloodType;
    private String phoneNum;
    private String phoneNum2;


    public User(){}

    public void setUid(String uid) {this.uid = uid;}
    public void setFcmToken(String fcmToken) {this.fcmToken = fcmToken;}
    public void setEmail(String email){ this.email = email; }
    public void setName(String name){
        this.name = name;
    }
    public void setDate(String date){
        this.date = date;
    }
    public void setGender(String gender){
        this.gender = gender;
    }
    public void setSymptom(String symptom){
        this.symptom = symptom;
    }
    public void setBloodType(String bloodType){
        this.bloodType = bloodType;
    }
    public void setPhoneNum(String phoneNum){
        this.phoneNum = phoneNum;
    }
    public void setPhoneNum2(String phoneNum2){
        this.phoneNum2 = phoneNum2;
    }
}
