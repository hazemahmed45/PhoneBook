package com.example.hazem.phonebook.Models.Listeners;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AbsListView;

import com.example.hazem.phonebook.Base.Constants.NavConstants;
import com.example.hazem.phonebook.Features.Activity.ContactScreen;
import com.example.hazem.phonebook.Features.Adapters.ContactAdapter;
import com.example.hazem.phonebook.Features.Adapters.LogsAdapter;
import com.example.hazem.phonebook.Models.ContactsMVC.ContactModels.Contact;
import com.example.hazem.phonebook.Models.LogsMVC.LogModels.LogModel;

/**
 * Created by Hazem on 7/13/2017.
 */

public abstract class CallContactTouchListener implements AbsListView.OnTouchListener {
    private int padding = 0;
    private int initialx = 0;
    private int currentx = 0;
    private boolean normalClick=false;
    private ContactAdapter.ContactHolder holder;
    Activity activity;
    Contact model;
    public CallContactTouchListener(ContactAdapter.ContactHolder holder, Activity activity, Contact model)
    {
        this.activity=activity;
        this.holder=holder;
        this.model=model;
    }

    public boolean onTouch(View v, MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            padding = 0;
            initialx = (int) event.getX();
            currentx = (int) event.getX();
        }
        if (event.getAction() == MotionEvent.ACTION_MOVE) {
            currentx = (int) event.getX();
            padding = currentx - initialx;
        }
        if (event.getAction() == MotionEvent.ACTION_UP || event.getAction() == MotionEvent.ACTION_CANCEL) {

            if(normalClick==true && event.getAction()==MotionEvent.ACTION_UP)
            {
                onItemClick();
            }
            padding = 0;
            initialx = 0;
            currentx = 0;
        }
        if (holder != null)
        {
            if (padding == 0)
            {
                v.setBackgroundColor(0xFFFFFFFF);

                if (holder.running)
                {
                    v.setBackgroundColor(0xFF058805);
                    Intent intent = new Intent(Intent.ACTION_CALL);
                    intent.setData(Uri.parse("tel:" + model.getPhoneNumber()));
                    if (ActivityCompat.checkSelfPermission(activity, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    }
                    activity.startActivity(intent);
                }

            }
            if(padding > 75)
            {
                if(padding>500)
                {
                    holder.running = true;
                    v.setBackgroundColor(0xFF058805 );
                }
                else if (padding>300)
                {
                    holder.running=false;
                    v.setBackgroundColor(0xFF00FF00 );
                }
                else if(padding>100)
                {
                    holder.running=false;
                    v.setBackgroundColor(0x6600FF00 );
                }
            }
            if(padding>=0)
            {
                if(padding<75)
                {
                    normalClick=true;
                }
                else
                {
                    normalClick=false;
                }
                v.setPadding(padding, 0,0, 0);
            }
        }
        return true;
    }
    void onItemClick()
    {
        Intent intent=new Intent(activity, ContactScreen.class);
        intent.putExtra(NavConstants.ContactKey,model);
        activity.startActivity(intent);
    }
}
