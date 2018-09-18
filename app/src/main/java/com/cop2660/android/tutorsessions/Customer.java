package com.cop2660.android.tutorsessions;

public class Customer {
    private String name,email;
    private int zipCode,phoneNumber;
    public Customer(String name, String email, int zipCode, int phoneNumber){

        this.setName(name);
        this.setEmail(email);
        this.setZipCode(zipCode);
        this.setPhoneNumber(phoneNumber);

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }






}
