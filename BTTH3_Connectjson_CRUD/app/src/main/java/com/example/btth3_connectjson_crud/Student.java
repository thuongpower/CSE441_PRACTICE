package com.example.btth3_connectjson_crud;

public class Student {
    private String id;
    private FullName full_name;
    private String gender;
    private String birth_date;
    private String email;
    private String address;
    private String major;
    private double gpa;
    private int year;

    // Class for full name
    public class FullName {
        private String first;
        private String last;
        private String middle;

        public String getFirst() { return first; }
        public String getLast() { return last; }
        public String getMiddle() { return middle; }
    }

    // Getters for student
    public String getId() { return id; }
    public FullName getFullName() { return full_name; }
    public String getGender() { return gender; }
    public String getBirthDate() { return birth_date; }
    public String getEmail() { return email; }
    public String getAddress() { return address; }
    public String getMajor() { return major; }
    public double getGpa() { return gpa; }
    public int getYear() { return year; }
}

