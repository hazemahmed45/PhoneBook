package com.example.hazem.phonebook.Models.LogsMVC;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.hazem.phonebook.Features.Adapters.LogsAdapter;
import com.example.hazem.phonebook.Models.LogsMVC.LogModels.LogModel;
import com.example.hazem.phonebook.R;

import java.util.ArrayList;

/**
 * Created by Hazem on 7/9/2017.
 */

public class LogView {

    private ArrayList<LogModel>logModels=null;
    private View view;
    private ListView listView;
    private LogsAdapter adapter=null;
    private AppCompatActivity context;

    public LogView(AppCompatActivity context,View view,ArrayList<LogModel> logModels)
    {
        this.context=context;
        this.view=view;
        listView= (ListView) view.findViewById(R.id.logs_listview);
        this.logModels=logModels;
    }

    public void SettingAdapter()
    {
        adapter=new LogsAdapter(context,logModels);
        listView.setAdapter(adapter);

    }
}
