package com.patient;
public class Patient {
    private final int id;
    private final String surname;
    private final String name;
    private final String middlename;
    private final String address;
    private final String phoneNumber;
    private final int medicalCardNumber;
    private final String diagnosis;

    public Patient(int id, String surname, String name, String middlename,
                   String address, String phoneNumber, int medicalCardNumber, String diagnosis) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.middlename = middlename;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.medicalCardNumber = medicalCardNumber;
        this.diagnosis = diagnosis;
    }

    public int getId() {
        return id;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public String getMiddlename() {
        return middlename;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getMedicalCardNumber() {
        return medicalCardNumber;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", middlename='" + middlename + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", medicalCardNumber='" + medicalCardNumber + '\'' +
                ", diagnosis='" + diagnosis + '\'' +
                '}';
    }
}
