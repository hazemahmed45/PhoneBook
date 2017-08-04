package com.example.hazem.phonebook.Features.Activity;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.hazem.phonebook.Base.PhoneBookApplication;
import com.example.hazem.phonebook.Features.Fragments.ContactListFragment;
import com.example.hazem.phonebook.Features.Fragments.FavoritiesFragment;
import com.example.hazem.phonebook.Features.Fragments.KeyPadFragment;
import com.example.hazem.phonebook.Features.Fragments.LogsFragment;
import com.example.hazem.phonebook.R;

public class MainScreen extends AppCompatActivity {
    TabLayout tabLayout;

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_screen_activity);
        Toast.makeText(this, PhoneBookApplication.getmInstance().getController().getLogModels().size()+"", Toast.LENGTH_SHORT).show();
        FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.framelayout,new KeyPadFragment());
        transaction.commit();
        SettingIDs();
        MakingTabs();
    }
    void SettingIDs()
    {
        tabLayout= (TabLayout) findViewById(R.id.tablayout);

    }
    void MakingTabs()
    {
        tabLayout.addTab(tabLayout.newTab()/*.setText("KeyPad")*/.setIcon(R.drawable.dialpad));
        tabLayout.addTab(tabLayout.newTab()/*.setText("Logs")*/.setIcon(R.drawable.telephone));
        tabLayout.addTab(tabLayout.newTab()/*.setText("Favorites")*/.setIcon(R.drawable.star));
        tabLayout.addTab(tabLayout.newTab()/*.setText("Contacts")*/.setIcon(R.drawable.phonebook));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition())
                {
                    case 0:
                    {
                        FragmentTransaction transaction=MainScreen.this.getSupportFragmentManager().beginTransaction();
                        transaction.replace(R.id.framelayout,new KeyPadFragment());
                        transaction.commit();
                        break;
                    }
                    case 1:
                    {
                        FragmentTransaction transaction=MainScreen.this.getSupportFragmentManager().beginTransaction();
                        transaction.replace(R.id.framelayout,new LogsFragment());
                        transaction.commit();
                        break;
                    }
                    case 2:
                    {
                        FragmentTransaction transaction=MainScreen.this.getSupportFragmentManager().beginTransaction();
                        transaction.replace(R.id.framelayout,new FavoritiesFragment());
                        transaction.commit();
                        break;
                    }
                    case 3:
                    {
                        FragmentTransaction transaction=MainScreen.this.getSupportFragmentManager().beginTransaction();
                        transaction.replace(R.id.framelayout,new ContactListFragment());
                        transaction.commit();
                    }
                }
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }
            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

}
