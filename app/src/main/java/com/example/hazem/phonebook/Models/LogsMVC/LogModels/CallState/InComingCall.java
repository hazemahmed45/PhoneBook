package com.example.hazem.phonebook.Models.LogsMVC.LogModels.CallState;

import com.example.hazem.phonebook.R;

import java.io.Serializable;

/**
 * Created by Hazem on 7/9/2017.
 */

public class InComingCall implements CallLogState,Serializable {
    public static final int IncomingCallIcon= R.drawable.incomingcall;
    @Override
    public int GetIcon() {
        return IncomingCallIcon;
    }
}
