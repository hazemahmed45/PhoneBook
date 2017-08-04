package com.example.hazem.phonebook.Models.ContactsMVC;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.hazem.phonebook.Models.ContactsMVC.ContactModels.Contact;

import java.util.ArrayList;

/**
 * Created by Hazem on 7/11/2017.
 */

public class ContactController {
    ArrayList<Contact> AllContacts=null;
    ContactView contactView=null;
    public ContactController()
    {
        AllContacts=new ArrayList<>();
    }

    public ArrayList<Contact> getAllContacts() {
        return AllContacts;
    }

    public ContactView getContactView() {
        return contactView;
    }
    public void setContactView(AppCompatActivity context, View view)
    {
        contactView=new ContactView(context,AllContacts,view);
    }

}
