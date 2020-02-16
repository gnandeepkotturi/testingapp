package com.example.databasetest;

class Student {
    private String rollno,name,mobileno,section,email;

    public Student(String rollno, String name,String section, String mobileno, String email) {
        this.rollno = rollno;
        this.name = name;
        this.mobileno = mobileno;
        this.section = section;
        this.email = email;
    }

    public Student() {
    }

    public String getRollno() {

        return rollno;
    }

    public String getName() {
        return name;
    }

    public String getMobileno() {

        return mobileno;
    }

    public String getSection() {
        return section;
    }

    public String getEmail() {

        return email;
    }
}
