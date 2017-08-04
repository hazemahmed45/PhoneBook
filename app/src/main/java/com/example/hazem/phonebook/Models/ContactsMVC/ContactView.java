package com.example.hazem.phonebook.Models.ContactsMVC;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.hazem.phonebook.Features.Activity.ContactScreen;
import com.example.hazem.phonebook.Features.Adapters.ContactAdapter;
import com.example.hazem.phonebook.Models.ContactsMVC.ContactModels.Contact;
import com.example.hazem.phonebook.R;

import java.util.ArrayList;

/**
 * Created by Hazem on 7/11/2017.
 */

public class ContactView {
    ListView listView=null;
    ContactAdapter adapter=null;
    ArrayList<Contact>contacts=null;
    AppCompatActivity context;
    View view;
    public ContactView(AppCompatActivity context,ArrayList<Contact> contacts,View v)
    {
        this.context=context;
        this.contacts=contacts;
        view=v;
        listView= (ListView) v.findViewById(R.id.recyclerview);
    }
    public void setAdapter()
    {
        adapter=new ContactAdapter(contacts,context);
        listView.setAdapter(adapter);

    }
}
