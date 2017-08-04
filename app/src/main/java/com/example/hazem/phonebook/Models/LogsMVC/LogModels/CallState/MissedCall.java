package com.example.hazem.phonebook.Models.LogsMVC.LogModels.CallState;

import android.graphics.Bitmap;

import com.example.hazem.phonebook.R;

import java.io.Serializable;

/**
 * Created by Hazem on 7/9/2017.
 */

public class MissedCall implements CallLogState,Serializable {
    public static final int MissedCallIcon= R.drawable.missedcall;

    @Override
    public int GetIcon() {
        return MissedCallIcon;
    }
}
