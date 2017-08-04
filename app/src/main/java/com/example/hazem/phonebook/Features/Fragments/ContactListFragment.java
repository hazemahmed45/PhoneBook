package com.example.hazem.phonebook.Features.Fragments;


import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.hazem.phonebook.Base.PhoneBookApplication;
import com.example.hazem.phonebook.Features.Adapters.ContactAdapter;
import com.example.hazem.phonebook.Models.ContactsMVC.ContactController;
import com.example.hazem.phonebook.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ContactListFragment extends Fragment {

    ListView listView;
    ContactAdapter adapters;
    ContactController controller;

    View view;
    public ContactListFragment() {
        // Required empty public constructor
    }


    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.contactlist_fragment, container, false);
        controller=PhoneBookApplication.getmInstance().getContactController();
        controller.setContactView((AppCompatActivity)ContactListFragment.this.getActivity(),view);
        controller.getContactView().setAdapter();

        return view;
    }
}
