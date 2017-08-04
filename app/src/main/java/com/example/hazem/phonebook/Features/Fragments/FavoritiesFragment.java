package com.example.hazem.phonebook.Features.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.hazem.phonebook.Features.Adapters.FavoritesAdapter;
import com.example.hazem.phonebook.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FavoritiesFragment extends Fragment {

    ListView listView;
    FavoritesAdapter adapter;
    View view;
    public FavoritiesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.favorities_fragment, container, false);
        SettingIDs();
        return view;
    }
    void SettingIDs()
    {
        listView= (ListView) view.findViewById(R.id.favorites_listview);
    }
    void SettingData()
    {

    }
}
