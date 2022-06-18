package com.example.myapplication;

public class Member {
    private String Name;
    private String Email_id;
    private String Password;
    private Long Phone_number;
    private String Department;

    public Member() {

    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail_id() {
        return Email_id;
    }

    public void setEmail_id(String email_id) {
        Email_id = email_id;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public Long getPhone_number() {
        return Phone_number;
    }

    public void setPhone_number(Long phone_number) {
        Phone_number = phone_number;
    }

    public String getDepartment() {
        return Department;
    }

    public void setDepartment(String department) {
        Department = department;
    }
}
