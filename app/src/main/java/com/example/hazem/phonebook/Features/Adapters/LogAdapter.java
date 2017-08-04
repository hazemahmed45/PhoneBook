package com.example.hazem.phonebook.Features.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hazem.phonebook.Models.LogsMVC.LogModels.LogModel;
import com.example.hazem.phonebook.R;

/**
 * Created by Hazem on 7/15/2017.
 */

public class LogAdapter extends BaseAdapter {
    Context context;
    LogModel logModel=null;
    LayoutInflater inflater;

    public LogAdapter(Context context, LogModel logModel) {
        this.context = context;
        this.logModel = logModel;
        inflater=LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return logModel.getCallDate().size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LogHolder holder;
        if(view ==null)
        {
            view=inflater.inflate(R.layout.log_detail_layout,viewGroup,false);
            holder=new LogHolder();
            holder.iconState= (ImageView) view.findViewById(R.id.log_state);
            holder.time= (TextView) view.findViewById(R.id.log_date);
            view.setTag(holder);
        }
        else
        {
            holder= (LogHolder) view.getTag();
        }
        holder.time.setText(logModel.getCallDate().get(i).getHours()+" : "+logModel.getCallDate().get(i).getMinutes());
        holder.iconState.setImageResource(logModel.getStates().get(i).GetIcon());
        return view;
    }

    static class LogHolder
    {
        ImageView iconState;
        TextView time;
    }
}
