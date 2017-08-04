package com.example.hazem.phonebook.Features.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.example.hazem.phonebook.Base.Constants.NavConstants;
import com.example.hazem.phonebook.Features.Adapters.LogAdapter;
import com.example.hazem.phonebook.Models.LogsMVC.LogModels.LogModel;
import com.example.hazem.phonebook.R;

public class LogsScreen extends AppCompatActivity {
    ListView listView;
    Toolbar toolbar;
    TextView logName;
    LogModel logModel;
    LogAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.logs_screen_activity);
        if(getIntent()!=null)
        {
            logModel= (LogModel) getIntent().getSerializableExtra(NavConstants.LogModelKey);
        }
        SettingIDs();
        SettingData();
    }
    void SettingIDs()
    {
        toolbar= (Toolbar) findViewById(R.id.logs_info_toolbar);
        listView= (ListView) findViewById(R.id.logs_info_details);
        logName= (TextView) findViewById(R.id.logs_info).findViewById(R.id.contact_info_name);

    }
    void SettingData()
    {
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        logName.setText(logModel.getCallerName());
        adapter=new LogAdapter(this,logModel);
        listView.setAdapter(adapter);

    }
}
