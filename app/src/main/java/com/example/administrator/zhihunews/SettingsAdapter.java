package com.example.administrator.zhihunews;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Administrator on 2017/2/17.
 */

public class SettingsAdapter extends ArrayAdapter<Settings> {
    private int nameId;
    public SettingsAdapter (Context context, int setNameId, List<Settings>objects){
        super(context,setNameId,objects);
        nameId = setNameId;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Settings set = getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(nameId,parent,false);
        TextView setName = (TextView)view.findViewById(R.id.set_tv);
        setName.setText(set.getSetName());
        return view;
    }
}
