package com.example.hazem.phonebook.Features.Adapters;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hazem.phonebook.Models.Listeners.CallLogTouchListener;
import com.example.hazem.phonebook.Models.LogsMVC.LogModels.LogModel;
import com.example.hazem.phonebook.R;

import java.util.ArrayList;

/**
 * Created by Hazem on 7/7/2017.
 */

public class LogsAdapter extends BaseAdapter {
    Context context;
    ArrayList<LogModel> logModels = null;
    LayoutInflater inflater;
    Activity activity;

    public LogsAdapter(AppCompatActivity context, ArrayList<LogModel> logModels) {
        this.context = context;
        this.logModels = logModels;
        inflater = LayoutInflater.from(context);
        activity = context;
    }


    @Override
    public int getCount() {
        return logModels.size();
    }

    @Override
    public LogModel getItem(int i) {
        return logModels.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LogsHolder holder;
        LogModel logModel=logModels.get(i);
        if (view == null) {
            view = inflater.inflate(R.layout.logs_layout, viewGroup, false);
            holder = new LogsHolder();
            holder.name = (TextView) view.findViewById(R.id.logs_name);
            holder.image = (ImageView) view.findViewById(R.id.logs_image);
            holder.num= (TextView) view.findViewById(R.id.logs_num);
            holder.callnum= (TextView) view.findViewById(R.id.logs_callnum);
            holder.lastCall= (TextView) view.findViewById(R.id.last_call);
            view.setTag(holder);
        } else {
            holder = (LogsHolder) view.getTag();
        }
        if ((logModel.getCallerName() != null)){
            holder.name.setText(logModels.get(i).getCallerName());
        }
        holder.num.setText(logModel.getCallerNumber());
        holder.callnum.setText(logModel.getCallDate().size()+"");
        holder.lastCall.setText(logModel.getCallDate().get(logModel.getStates().size()-1).getHours()+":"+logModel.getCallDate().get(logModel.getStates().size()-1).getMinutes());
        view.setOnTouchListener(new CallLogTouchListener(holder,activity,logModels.get(i)) {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return super.onTouch(v, event);
            }
        });

        return view;
    }
    public static class LogsHolder
    {
        ImageView image;
        TextView name;
        TextView num;
        TextView callnum;
        TextView lastCall;
        public boolean running;

    }
}
