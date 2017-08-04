package com.example.hazem.phonebook.Features.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.hazem.phonebook.Models.ContactsMVC.ContactModels.Contact;
import com.example.hazem.phonebook.R;

import java.util.ArrayList;

/**
 * Created by Hazem on 7/7/2017.
 */

public class FavoritesAdapter extends BaseAdapter {
    Context context;
    ArrayList<Contact> contacts=null;
    LayoutInflater inflater;

    public FavoritesAdapter(Context context, ArrayList<Contact> contacts) {
        this.context = context;
        this.contacts = contacts;
        inflater=LayoutInflater.from(context);
    }
    @Override
    public int getCount() {
        return contacts.size();
    }

    @Override
    public Object getItem(int i) {
        return contacts.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        FavoritesHolder holder;
        if(view ==null)
        {
            view=inflater.inflate(R.layout.favorites_layout,viewGroup,false);
            holder=new FavoritesHolder();
            view.setTag(holder);
        }
        else
        {
            holder= (FavoritesHolder) view.getTag();
        }
        return view;
    }
    public class FavoritesHolder
    {

    }
}
