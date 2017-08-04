package com.example.hazem.phonebook.Models.ContactsMVC.ContactModels;

import java.io.Serializable;

/**
 * Created by Hazem on 7/6/2017.
 */

public class Contact implements Serializable {
    String Firstname,PhoneNumber;

    public Contact()
    {
        PhoneNumber="XXXXXXXX";
    }

    public Contact(String firstname, String phoneNumber) {
        Firstname = firstname;
        PhoneNumber = phoneNumber;
    }
    public String getFirstname() {
        return Firstname;
    }

    public void setFirstname(String firstname) {
        Firstname = firstname;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }
}
