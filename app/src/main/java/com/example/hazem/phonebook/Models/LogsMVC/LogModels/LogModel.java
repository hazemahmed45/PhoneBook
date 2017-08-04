package com.example.hazem.phonebook.Models.LogsMVC.LogModels;

import android.provider.CallLog;

import com.example.hazem.phonebook.Models.LogsMVC.LogModels.CallState.BlockedCall;
import com.example.hazem.phonebook.Models.LogsMVC.LogModels.CallState.CallLogState;
import com.example.hazem.phonebook.Models.LogsMVC.LogModels.CallState.InComingCall;
import com.example.hazem.phonebook.Models.LogsMVC.LogModels.CallState.MissedCall;
import com.example.hazem.phonebook.Models.LogsMVC.LogModels.CallState.OutGoingCall;
import com.example.hazem.phonebook.Models.LogsMVC.LogModels.CallState.RejectedCall;
import com.example.hazem.phonebook.Models.LogsMVC.LogModels.CallState.VoicemailedCall;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Hazem on 7/8/2017.
 */

public class LogModel implements Serializable
{
    String CallerName,CallerFormatedNumber,CallerNumber,CallDuration,GeoLocation;
    ArrayList<CallLogState> states=null;
    ArrayList<Date> callDate=null;

    public LogModel(String callerName, String callerNumber,String callerFormatedNumber, String callType, Date callDate, String callDuration, String geoLocation)
    {
        this.callDate=new ArrayList<>();
        this.states=new ArrayList<>();
        CallerName = callerName;
        CallerNumber = callerNumber;
        this.callDate.add(callDate);
        states.add(LogType(callType));
        CallDuration=callDuration;
        CallerFormatedNumber=callerFormatedNumber;
        GeoLocation=geoLocation;
    }

    public void AddCallState(String CallType)
    {
        states.add(LogType(CallType));
    }

    public ArrayList<CallLogState> getStates() {
        return states;
    }

    public void setStates(ArrayList<CallLogState> states) {
        this.states = states;
    }

    public String getGeoLocation() {
        return GeoLocation;
    }

    public void setGeoLocation(String geoLocation) {
        GeoLocation = geoLocation;
    }

    public String getCallerFormatedNumber() {
        return CallerFormatedNumber;
    }

    public void setCallerFormatedNumber(String callerFormatedNumber) {
        CallerFormatedNumber = callerFormatedNumber;
    }

    public String getCallDuration() {
        return CallDuration;
    }

    public void setCallDuration(String callDuration) {
        CallDuration = callDuration;
    }

    public String getCallerName() {
        return CallerName;
    }

    public void setCallerName(String callerName) {
        CallerName = callerName;
    }

    public String getCallerNumber() {
        return CallerNumber;
    }

    public void setCallerNumber(String callerNumber) {
        CallerNumber = callerNumber;
    }

    public ArrayList<Date> getCallDate() {
        return callDate;
    }

    public void setCallDate(ArrayList<Date> callDate) {
        this.callDate = callDate;
    }

    public CallLogState LogType(String type)
    {
        CallLogState state=null;
        int dircode = Integer.parseInt(type);
        switch (dircode) {
            case CallLog.Calls.OUTGOING_TYPE:
                state=new OutGoingCall();
                break;
            case CallLog.Calls.INCOMING_TYPE:
                state=new InComingCall();
                break;
            case CallLog.Calls.MISSED_TYPE:
                state=new MissedCall();
                break;
            case CallLog.Calls.BLOCKED_TYPE:
                state=new BlockedCall();
                break;
            case CallLog.Calls.REJECTED_TYPE:
                state=new RejectedCall();
                break;
            case CallLog.Calls.VOICEMAIL_TYPE:
                state=new VoicemailedCall();
                break;

        }
        return state;
    }
}
