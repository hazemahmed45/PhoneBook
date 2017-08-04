package com.example.hazem.phonebook.Models.LogsMVC.LogModels.CallState;

import com.example.hazem.phonebook.R;

import java.io.Serializable;

/**
 * Created by Hazem on 7/11/2017.
 */

public class RejectedCall implements CallLogState,Serializable {
    public static final int RejectedCallIcon= R.drawable.rejectcall;

    @Override
    public int GetIcon() {
        return RejectedCallIcon;
    }
}
