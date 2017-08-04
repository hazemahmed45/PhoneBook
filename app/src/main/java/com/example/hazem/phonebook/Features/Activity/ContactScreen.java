package com.example.hazem.phonebook.Features.Activity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hazem.phonebook.Base.Constants.NavConstants;
import com.example.hazem.phonebook.Models.ContactsMVC.ContactModels.Contact;
import com.example.hazem.phonebook.R;

public class ContactScreen extends AppCompatActivity {
    Contact contact;
    TextView contactName,contactNum;
    View contactInfoTelephone;
    Toolbar toolbar;
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact_screen_activity);
        if(getIntent()!=null)
        {
            contact= (Contact) getIntent().getSerializableExtra(NavConstants.ContactKey);
            Toast.makeText(this, contact.getFirstname()+"", Toast.LENGTH_SHORT).show();
        }
        SettingIDs();
        SettingData();
    }
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    void SettingIDs()
    {
        contactName= (TextView) findViewById(R.id.contact_info_name);
        contactNum= (TextView) findViewById(R.id.contact_info_telephone);
        contactInfoTelephone=findViewById(R.id.contact_info_telephone_view);
        toolbar= (Toolbar) findViewById(R.id.toolbar);
    }
    void SettingData()
    {
        contactName.setText(contact.getFirstname());
        contactNum.setText(contact.getPhoneNumber());
        contactInfoTelephone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:" + contact.getPhoneNumber()));
                if (ActivityCompat.checkSelfPermission(ContactScreen.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                }
                ContactScreen.this.startActivity(intent);
            }
        });
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        toolbar.setNavigationIcon(R.drawable.left_arrow);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.share,menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.whatsapp:
            {
                Toast.makeText(this, "here", Toast.LENGTH_SHORT).show();
            }
        }
        return super.onOptionsItemSelected(item);
    }
}
