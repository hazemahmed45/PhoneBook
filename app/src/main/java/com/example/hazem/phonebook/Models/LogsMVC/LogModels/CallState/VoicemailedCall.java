package com.example.hazem.phonebook.Models.LogsMVC.LogModels.CallState;

import java.io.Serializable;

/**
 * Created by Hazem on 7/11/2017.
 */

public class VoicemailedCall implements CallLogState,Serializable {
    @Override
    public int GetIcon() {
        return 0;
    }
}
