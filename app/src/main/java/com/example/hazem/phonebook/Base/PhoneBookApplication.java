package com.example.hazem.phonebook.Base;

import android.app.Application;

import com.example.hazem.phonebook.Models.ContactsMVC.ContactController;
import com.example.hazem.phonebook.Models.ContactsMVC.ContactModels.Contact;
import com.example.hazem.phonebook.Models.LogsMVC.LogController;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Hazem on 7/7/2017.
 */

public class PhoneBookApplication extends Application {
    private LogController controller=null;
    public LogController getController()
    {
        return controller;
    }

    private ContactController contactController=null;
    public ContactController getContactController()
    {
        return contactController;
    }

    private HashMap<String,String> MobileToContact=null;
    public HashMap<String,String> getMobileToContact()
    {
        return MobileToContact;
    }

    private static PhoneBookApplication mInstance;
    public static PhoneBookApplication getmInstance()
    {
        return mInstance;
    }
    @Override
    public void onCreate() {
        super.onCreate();
        mInstance=this;
        controller=new LogController();
        contactController=new ContactController();
        MobileToContact=new HashMap<>();
    }
    public void AddContact(Contact contact)
    {
        contactController.getAllContacts().add(contact);
        if(!MobileToContact.containsKey(contact.getPhoneNumber()))
        {
            String phoneNumber=contact.getPhoneNumber().replace("+2","");
            MobileToContact.put(phoneNumber,contact.getFirstname());
        }
    }
}
