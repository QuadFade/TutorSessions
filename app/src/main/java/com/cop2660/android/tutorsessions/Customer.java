package com.cop2660.android.tutorsessions;

public class Customer {
    private String name,email, streetAddress,city,state;
    private int zipCode,phoneNumber;
    private byte photo;


    public Customer(String name, String email, String streetAddress, String city, String state, int zipCode, int phoneNumber, byte photo){

        this.setName(name);
        this.setEmail(email);
        this.setZipCode(zipCode);
        this.setPhoneNumber(phoneNumber);
        this.setStreetAddress(streetAddress);
        this.setCity(city);
        this.setState(state);
        this.setPhoto(photo);

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

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }


    public byte getPhoto() {
        return photo;
    }

    public void setPhoto(byte photo) {
        this.photo = photo;
    }
}
