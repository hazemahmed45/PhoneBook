package com.example.hazem.phonebook.Features.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.example.hazem.phonebook.Base.PhoneBookApplication;
import com.example.hazem.phonebook.Features.Adapters.LogsAdapter;
import com.example.hazem.phonebook.Models.LogsMVC.LogController;
import com.example.hazem.phonebook.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class LogsFragment extends Fragment {

    ListView listView;
    LogsAdapter adapter;
    LogController controller;
    View view;
    public LogsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.logs_fragment, container, false);
        //SettingIDs();
        controller=PhoneBookApplication.getmInstance().getController();
        controller.setLogView((AppCompatActivity)LogsFragment.this.getActivity(),view);
        controller.getLogView().SettingAdapter();

        return view;
    }

}
