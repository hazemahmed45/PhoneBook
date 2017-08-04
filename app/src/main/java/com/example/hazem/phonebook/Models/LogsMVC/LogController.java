package com.example.hazem.phonebook.Models.LogsMVC;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.hazem.phonebook.Models.LogsMVC.LogModels.LogModel;

import java.util.ArrayList;

/**
 * Created by Hazem on 7/9/2017.
 */

public class LogController {
    private ArrayList<LogModel>logModels=null;
    LogView logView=null;
    public ArrayList<LogModel> getLogModels()
    {
        if(logModels==null)
        {
            logModels=new ArrayList<>();
        }
        return logModels;
    }
    public void setLogView(AppCompatActivity context, View view)
    {
        logView=new LogView(context,view,logModels);
    }
    public LogView getLogView()
    {
        return logView;
    }
}
