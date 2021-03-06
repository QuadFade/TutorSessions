package com.cop2660.android.tutorsessions;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.List;

public class CustomerAdapter extends ArrayAdapter {
    List list = new ArrayList<>();


    public CustomerAdapter(Context context, int resource) {
        super(context, resource);
    }


    public void add(Customer object) {
        list.add(object);
        super.add(object);
    }

    @Override
    public int getCount(){
        return super.getCount();
    }

    @Override
    public Object getItem(int position) {
        return super.getItem(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return super.getView(position,convertView,parent);
    }

}
