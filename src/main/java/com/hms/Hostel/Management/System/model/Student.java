package com.hms.Hostel.Management.System.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Student")
public class Student {
    @Id
    private String Reg_No;

    private String First_Name;
    private String Last_Name;
    private String Initials;
    private String ID_No;
    private Character Gender;
    private String Email;
    private String Phone;
    private String Faculty;
    private Short Batch;
    private String Address_House_No;
    private String Address_Street;
    private String Address_Locality;
    private String Address_City;
    private Short Address_Postcode;
    private Boolean Medical_Condition;
    @Column(columnDefinition = "TEXT")
    private String Note;
    private Boolean Active;

    public String getReg_No() {
        return Reg_No;
    }

    public void setReg_No(String reg_No) {
        Reg_No = reg_No;
    }

    public String getFirst_Name() {
        return First_Name;
    }

    public void setFirst_Name(String first_Name) {
        First_Name = first_Name;
    }

    public String getLast_Name() {
        return Last_Name;
    }

    public void setLast_Name(String last_Name) {
        Last_Name = last_Name;
    }

    public String getInitials() {
        return Initials;
    }

    public void setInitials(String initials) {
        Initials = initials;
    }

    public String getID_No() {
        return ID_No;
    }

    public void setID_No(String ID_No) {
        this.ID_No = ID_No;
    }

    public Character getGender() {
        return Gender;
    }

    public void setGender(Character gender) {
        Gender = gender;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getFaculty() {
        return Faculty;
    }

    public void setFaculty(String faculty) {
        Faculty = faculty;
    }

    public Short getBatch() {
        return Batch;
    }

    public void setBatch(Short batch) {
        Batch = batch;
    }

    public String getAddress_House_No() {
        return Address_House_No;
    }

    public void setAddress_House_No(String address_House_No) {
        Address_House_No = address_House_No;
    }

    public String getAddress_Street() {
        return Address_Street;
    }

    public void setAddress_Street(String address_Street) {
        Address_Street = address_Street;
    }

    public String getAddress_Locality() {
        return Address_Locality;
    }

    public void setAddress_Locality(String address_Locality) {
        Address_Locality = address_Locality;
    }

    public String getAddress_City() {
        return Address_City;
    }

    public void setAddress_City(String address_City) {
        Address_City = address_City;
    }

    public Short getAddress_Postcode() {
        return Address_Postcode;
    }

    public void setAddress_Postcode(Short address_Postcode) {
        Address_Postcode = address_Postcode;
    }

    public Boolean getMedical_Condition() {
        return Medical_Condition;
    }

    public void setMedical_Condition(Boolean medical_Condition) {
        Medical_Condition = medical_Condition;
    }

    public String getNote() {
        return Note;
    }

    public void setNote(String note) {
        Note = note;
    }

    public Boolean getActive() {
        return Active;
    }

    public void setActive(Boolean active) {
        Active = active;
    }
}

