package com.example.hazem.phonebook.Features.Adapters;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.SectionIndexer;
import android.widget.TextView;

import com.example.hazem.phonebook.Models.ContactsMVC.ContactModels.Contact;
import com.example.hazem.phonebook.Models.Listeners.CallContactTouchListener;
import com.example.hazem.phonebook.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Set;

/**
 * Created by Hazem on 7/6/2017.
 */

public class ContactAdapter extends BaseAdapter implements SectionIndexer{
    ArrayList<Contact> contacts =null;
    AppCompatActivity context;
    HashMap<String,Integer> Indexer;
    String [] sections;
    LayoutInflater inflater;

    public ContactAdapter(ArrayList<Contact> contacts, AppCompatActivity context) {
        this.contacts = contacts;
        this.context=context;
        Indexer=new HashMap<>();
        inflater=LayoutInflater.from(context);
        for (Integer i=0;i.intValue()<contacts.size();i++)
        {
            String chara=contacts.get(i).getFirstname().substring(0,1).toUpperCase();
            if(!Indexer.containsKey(chara))
            {

                Indexer.put(chara,i);
            }
        }
        Set<String> sectionLetters = Indexer.keySet();
        ArrayList<String> sectionList = new ArrayList<>(sectionLetters);
        Collections.sort(sectionList);
        sections = new String[sectionList.size()];
        sectionList.toArray(sections);

    }

    @Override
    public int getCount() {
        return contacts.size();
    }

    @Override
    public Contact getItem(int i) {
        return contacts.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ContactHolder contactHolder;
        if(view==null)
        {
            view=inflater.inflate(R.layout.contact_layout,viewGroup,false);
            contactHolder=new ContactHolder();
            contactHolder.Number= (TextView) view.findViewById(R.id.contact_number);
            contactHolder.Name= (TextView) view.findViewById(R.id.contact_name);
            view.setTag(contactHolder);
        }
        else
        {
            contactHolder= (ContactHolder) view.getTag();
        }
        Contact contact=contacts.get(i);
        contactHolder.Name.setText(contact.getFirstname());
        contactHolder.Number.setText(contact.getPhoneNumber());
        view.setOnTouchListener(new CallContactTouchListener(contactHolder,context,contact) {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return super.onTouch(v, event);
            }
        });
        return view;
    }

    @Override
    public Object[] getSections() {
        return sections;
    }

    @Override
    public int getPositionForSection(int i) {
        return Indexer.get(sections[i]).intValue();

    }

    @Override
    public int getSectionForPosition(int i) {

        return 0;
    }

    public static class ContactHolder
    {
        TextView Name,Number;
        public boolean running;

    }
}
