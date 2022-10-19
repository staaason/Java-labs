//l6_2_1
package com.student;

import java.util.List;

public class Student {

    private int id;
    private String surname;
    private String name;
    private String middlename;
    private String birthDate;
    private String address;
    private String phoneNumber;
    private String fac;
    private String course;
    private String group;

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", middlename='" + middlename + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", fac='" + fac + '\'' +
                ", course=" + course +
                ", group='" + group + '\'' +
                '}';
    }

    public Student(int id, String surname, String name, String middlename, String birthDate, String address, String phoneNumber,
                   String fac, String course, String group){
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.middlename = middlename;
        this.birthDate = birthDate;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.fac = fac;
        this.course = course;
        this.group = group;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMiddlename() {
        return middlename;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getFac() {
        return fac;
    }

    public void setFac(String fac) {
        this.fac = fac;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public int getYear(){
        String[] birth = birthDate.split("\\.");
        return Integer.parseInt(birth[2]);
    }
}
