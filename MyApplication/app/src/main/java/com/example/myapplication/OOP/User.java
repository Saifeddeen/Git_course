package com.example.myapplication.OOP;

import android.widget.Toast;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class User {

    String name;
    String gender;
    private int weight;
    private int length;
    private String email;
    private String password;
    private LocalDate dob;
    private int age;
    private double agePercent;
    private ArrayList<Record> records;
    private String currentStatus;

    public User(String name, String email, String password){
        this.name = name;
        this.email = email;
        this.password = password;
    }
    public User(String name, String email, List<User> users, String password, String confirmation, String gender, int length, int weight, LocalDate dob){

        if(!findEmail(email,users)){
            if(this.checkEmail(email)){
                if(this.checkPassword(password, confirmation)){
                    this.setEmail(email);
                    this.setPassword(password);
                    this.name = name;
                    this.setLength(length);
                    this.setWeight(weight);
                    this.setGender(gender);
                    this.setDob(dob);
                    this.setAge();
                    this.setAgePercent();
                    this.records = new ArrayList<Record>();
                    //this.records = new List<Record>();
                }else {
                    System.out.println("Password not matches");
                }
            }else{
                System.out.println("Wrong Email");
            }
        }else{
            System.out.println("Email already exists");
        }

    }

    public static boolean checkEmail(String email){
        return Pattern.compile("^(.+)@(\\S+)$").matcher(email).matches();
    }

    public static boolean findEmail(String email, List<User> users){
        for(int i=0; i<=users.size(); i++){
            if(email.compareTo(users.get(i).email)==0){
                return true;
            }
        }
        return false;
    }

    public boolean checkPassword(String password, String confirmation){
        return (password.compareTo(confirmation)==0);
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setGender(String gender) {
        if(gender.equalsIgnoreCase("male") || gender.equalsIgnoreCase("female")){
            this.gender = gender;
        }
    }

    public String getGender() {
        return gender;
    }

    public void setLength(int length) {
        if(length>=100 && length<=220){
            this.length = length;
        }
    }

    public int getLength() {
        return length;
    }

    public void setWeight(int weight) {
        if(weight>=30 && weight<=300){
            this.weight = weight;
        }
    }

    public int getWeight() {
        return weight;
    }

    //check age is 2 or more
    public static boolean checkAge(LocalDate dob){
        if(dob != null){
            LocalDate today = LocalDate.now();

            Period period = Period.between(this.dob,today);
            int age = period.getYears();
            if(age>=2){
                return true;
            }
            return true;
        }
        return false;
    }

    public void setDob(LocalDate dob) {
        if(User.checkAge(dob)){
            this.dob = dob;
        }
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setAge() {
        LocalDate today = LocalDate.now();

        Period period = Period.between(this.dob,today);
        this.age = period.getYears();
    }

    public int getAge() {
        return age;
    }

    //add record to records
    public void addRecord(Record record){
        this.records.add(record);
    }

    //complete user info
    public void completeInfo(String gender, int weight, int length, LocalDate dob){

        /*if(gender.equalsIgnoreCase("male") || gender.equalsIgnoreCase("female")){
            if(weight >= 20 || weight <= 500){
                if(length >= 100 || length <= 250){
                    if(dob.getYear() <= (LocalDate.now().getYear()-15)){
                        this.setGender(gender);
                        this.se
                    }
                }
            }

        }*/
        this.setGender(gender);
        this.setLength(length);
        this.setWeight(weight);
        this.setDob(dob);
        this.setAge();

    }

    public ArrayList<Record> getRecords() {
        return records;
    }

    //set and get age percent

    public void setAgePercent() {
        if(getAge()>=2 && getAge()<=10){
            agePercent = 0.7;
        }else if((getAge()>10 && getAge()<=20)&&(getGender().equalsIgnoreCase("male"))){
            agePercent = 0.9;
        }else if((getAge()>10 && getAge()<=20)&&(getGender().equalsIgnoreCase("female"))){
            agePercent = 0.9;
        }else{
            agePercent = 1;
        }
    }

    public double getAgePercent() {
        return agePercent;
    }

    //set and get user status
    public void setCurrentStatus() {

        if(records.size() == 0){
            this.currentStatus = "Normal";
            return;
        }

        double bmi1 = this.records.get(this.records.size()).getBmiValue();
        double bmi2 = this.records.get(this.records.size()-1).getBmiValue();
        double deltaBmi = bmi1 - bmi2;
        int index1 = AppMethodsData.getDeltaIndex(deltaBmi);
        int index2 = AppMethodsData.getBmiCategIndex(this.records.get(this.records.size()).getBmiCategory());
        this.currentStatus = AppMethodsData.messageMatrix[index1][index2];
        this.records.get(this.records.size()).setStatus(this.currentStatus);
    }

    public String getCurrentStatus() {
        return currentStatus;
    }
}
