package com.example.hazem.phonebook.Features.Activity;

import android.Manifest;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Build;
import android.os.Handler;
import android.provider.CallLog;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.hazem.phonebook.Base.PhoneBookApplication;
import com.example.hazem.phonebook.Models.ContactsMVC.ContactModels.Contact;
import com.example.hazem.phonebook.Models.LogsMVC.LogModels.LogModel;
import com.example.hazem.phonebook.R;

import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

public class Splash extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        if(checkSelfPermission(Manifest.permission.READ_CONTACTS)!= PackageManager.PERMISSION_GRANTED &&
                checkSelfPermission(Manifest.permission.WRITE_CONTACTS)!= PackageManager.PERMISSION_GRANTED &&
                checkSelfPermission(Manifest.permission.WRITE_CALL_LOG)!= PackageManager.PERMISSION_GRANTED &&
                checkSelfPermission(Manifest.permission.READ_CALL_LOG)!= PackageManager.PERMISSION_GRANTED &&
                checkSelfPermission(Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED)
        {
            requestPermissions(new String[]{Manifest.permission.MEDIA_CONTENT_CONTROL,Manifest.permission.CALL_PHONE,Manifest.permission.READ_CONTACTS,Manifest.permission.WRITE_CONTACTS,Manifest.permission.WRITE_CALL_LOG,Manifest.permission.READ_CALL_LOG},1);
        }
        else
        {
            if(PhoneBookApplication.getmInstance().getContactController().getAllContacts().size()<=0)
            {
                GetContacts();
                Collections.sort(PhoneBookApplication.getmInstance().getContactController().getAllContacts(), new Comparator<Contact>() {
                    @Override
                    public int compare(Contact contact, Contact t1) {

                        return contact.getFirstname().compareTo(t1.getFirstname());
                    }
                });
            }
            if(PhoneBookApplication.getmInstance().getController().getLogModels().size()<=0)
            {
                GettingLogs();
            }

            Handler handler=new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {

                    Intent intent=new Intent(Splash.this,MainScreen.class);
                    startActivity(intent);
                    finish();
                }
            },2000);
        }



    }
    void GetContacts()
    {
        ContentResolver cr=getContentResolver();
        Cursor cursor=cr.query(ContactsContract.Contacts.CONTENT_URI,null,null,null,null);
        if (cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                String id = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts._ID));
                String name = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
                Contact contact=new Contact();
                if (Integer.parseInt(cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER))) > 0) {
                    System.out.println("name : " + name + ", ID : " + id);
                    contact.setFirstname(name);
                    // get the phone number
                    //ContactsContract.Data.
                    Cursor pCur = cr.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null,
                            ContactsContract.CommonDataKinds.Phone.CONTACT_ID + " = ?",
                            new String[]{id}, null);
                    if (pCur.moveToNext()) {
                        String phone = pCur.getString(
                                pCur.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                        System.out.println("phone" + phone);
                        contact.setPhoneNumber(phone);
                    }
                    pCur.close();

                    PhoneBookApplication.getmInstance().AddContact(contact);

                    // get email and type

//                    Cursor emailCur = cr.query(
//                            ContactsContract.CommonDataKinds.Email.CONTENT_URI,
//                            null,
//                            ContactsContract.CommonDataKinds.Email.CONTACT_ID + " = ?",
//                            new String[]{id}, null);
//                    while (emailCur.moveToNext()) {
//                        // This would allow you get several email addresses
//                        // if the email addresses were stored in an array
//                        String email = emailCur.getString(
//                                emailCur.getColumnIndex(ContactsContract.CommonDataKinds.Email.DATA));
//                        String emailType = emailCur.getString(
//                                emailCur.getColumnIndex(ContactsContract.CommonDataKinds.Email.TYPE));
//
//                        System.out.println("Email " + email + " Email Type : " + emailType);
//                    }
//                    emailCur.close();

                    // Get note.......
//                    String noteWhere = ContactsContract.Data.CONTACT_ID + " = ? AND " + ContactsContract.Data.MIMETYPE + " = ?";
//                    String[] noteWhereParams = new String[]{id,
//                            ContactsContract.CommonDataKinds.Note.CONTENT_ITEM_TYPE};
//                    Cursor noteCur = cr.query(ContactsContract.Data.CONTENT_URI, null, noteWhere, noteWhereParams, null);
//                    if (noteCur.moveToFirst()) {
//                        String note = noteCur.getString(noteCur.getColumnIndex(ContactsContract.CommonDataKinds.Note.NOTE));
//                        System.out.println("Note " + note);
//                    }
//                    noteCur.close();

                    //Get Postal Address....

//                    String addrWhere = ContactsContract.Data.CONTACT_ID + " = ? AND " + ContactsContract.Data.MIMETYPE + " = ?";
//                    String[] addrWhereParams = new String[]{id,
//                            ContactsContract.CommonDataKinds.StructuredPostal.CONTENT_ITEM_TYPE};
//                    Cursor addrCur = cr.query(ContactsContract.Data.CONTENT_URI,
//                            null, null, null, null);
//                    while (addrCur.moveToNext()) {
//                        String poBox = addrCur.getString(
//                                addrCur.getColumnIndex(ContactsContract.CommonDataKinds.StructuredPostal.POBOX));
//                        String street = addrCur.getString(
//                                addrCur.getColumnIndex(ContactsContract.CommonDataKinds.StructuredPostal.STREET));
//                        String city = addrCur.getString(
//                                addrCur.getColumnIndex(ContactsContract.CommonDataKinds.StructuredPostal.CITY));
//                        String state = addrCur.getString(
//                                addrCur.getColumnIndex(ContactsContract.CommonDataKinds.StructuredPostal.REGION));
//                        String postalCode = addrCur.getString(
//                                addrCur.getColumnIndex(ContactsContract.CommonDataKinds.StructuredPostal.POSTCODE));
//                        String country = addrCur.getString(
//                                addrCur.getColumnIndex(ContactsContract.CommonDataKinds.StructuredPostal.COUNTRY));
//                        String type = addrCur.getString(
//                                addrCur.getColumnIndex(ContactsContract.CommonDataKinds.StructuredPostal.TYPE));
//
//                        // Do something with these....
//
//                    }
//                    addrCur.close();
//
//                    // Get Instant Messenger.........
//                    String imWhere = ContactsContract.Data.CONTACT_ID + " = ? AND " + ContactsContract.Data.MIMETYPE + " = ?";
//                    String[] imWhereParams = new String[]{id,
//                            ContactsContract.CommonDataKinds.Im.CONTENT_ITEM_TYPE};
//                    Cursor imCur = cr.query(ContactsContract.Data.CONTENT_URI,
//                            null, imWhere, imWhereParams, null);
//                    if (imCur.moveToFirst()) {
//                        String imName = imCur.getString(
//                                imCur.getColumnIndex(ContactsContract.CommonDataKinds.Im.DATA));
//                        String imType;
//                        imType = imCur.getString(
//                                imCur.getColumnIndex(ContactsContract.CommonDataKinds.Im.TYPE));
//                    }
//                    imCur.close();
//
//                    // Get Organizations.........
//
//                    String orgWhere = ContactsContract.Data.CONTACT_ID + " = ? AND " + ContactsContract.Data.MIMETYPE + " = ?";
//                    String[] orgWhereParams = new String[]{id,
//                            ContactsContract.CommonDataKinds.Organization.CONTENT_ITEM_TYPE};
//                    Cursor orgCur = cr.query(ContactsContract.Data.CONTENT_URI,
//                            null, orgWhere, orgWhereParams, null);
//                    if (orgCur.moveToFirst()) {
//                        String orgName = orgCur.getString(orgCur.getColumnIndex(ContactsContract.CommonDataKinds.Organization.DATA));
//                        String title = orgCur.getString(orgCur.getColumnIndex(ContactsContract.CommonDataKinds.Organization.TITLE));
//                    }
//                    orgCur.close();
                }
            }
        }
    }
    void GettingLogs()
    {
        Cursor managedCursor = managedQuery(CallLog.Calls.CONTENT_URI, null, null, null, null);
        int number = managedCursor.getColumnIndex(CallLog.Calls.NUMBER);
        int type = managedCursor.getColumnIndex(CallLog.Calls.TYPE);
        int date = managedCursor.getColumnIndex(CallLog.Calls.DATE);
        int duration = managedCursor.getColumnIndex(CallLog.Calls.DURATION);
        int geolocation=managedCursor.getColumnIndex(CallLog.Calls.GEOCODED_LOCATION);
        int cachedName=managedCursor.getColumnIndex(CallLog.Calls.CACHED_NAME);
        int formatedNumber=managedCursor.getColumnIndex(CallLog.Calls.CACHED_FORMATTED_NUMBER);
        LogModel contactLog=null;
        while (managedCursor.moveToNext()) {
            String phNumber = managedCursor.getString(number);
            String callType = managedCursor.getString(type);
            String callDate = managedCursor.getString(date);
            String callDuration = managedCursor.getString(duration);
            String geocodeLocation=managedCursor.getString(geolocation);
            String cachedLogName=managedCursor.getString(cachedName);
            String formateNum=managedCursor.getString(formatedNumber);

            Date formatedDate=new Date(Long.valueOf(callDate));;
            Log.i("HEHE",phNumber);
            if(contactLog!=null )
            {

                if(contactLog.getCallerName()!=null &&contactLog.getCallerName().equals(cachedLogName))
                {
                    contactLog.getCallDate().add(formatedDate);
                    contactLog.AddCallState(callType);
                }
                else
                {
                    PhoneBookApplication.getmInstance().getController().getLogModels().add(contactLog);
                    Log.i("HEHE",contactLog.getCallerNumber()+" "+contactLog.getCallDate().size());
                    contactLog =new LogModel(cachedLogName,phNumber,formateNum,callType,formatedDate,callDuration,geocodeLocation);
                }
            }
            else
            {
                contactLog =new LogModel(cachedLogName,phNumber,formateNum,callType,formatedDate,callDuration,geocodeLocation);
            }



        }
        managedCursor.close();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults)
    {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        //Toast.makeText(this, requestCode+" "+grantResults.length+" "+grantResults[0]+grantResults[1]+grantResults[2]+" "+PackageManager.PERMISSION_GRANTED, Toast.LENGTH_SHORT).show();
        switch (requestCode) {
            case 1: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0 && grantResults[1] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(this, "done", Toast.LENGTH_SHORT).show();
                    GetContacts();
                    Collections.sort(PhoneBookApplication.getmInstance().getContactController().getAllContacts(), new Comparator<Contact>() {
                        @Override
                        public int compare(Contact contact, Contact t1) {

                            return contact.getFirstname().compareTo(t1.getFirstname());
                        }
                    });
                    GettingLogs();
                    Handler handler=new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {

                            Intent intent=new Intent(Splash.this,MainScreen.class);
                            startActivity(intent);
                            finish();
                        }
                    },2000);

                }
                return;
            }

        }
    }
}

