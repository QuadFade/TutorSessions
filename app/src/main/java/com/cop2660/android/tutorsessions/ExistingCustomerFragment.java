package com.cop2660.android.tutorsessions;

import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cop2660.android.tutorsessions.database.DatabaseHelper;

import java.util.ArrayList;

public class ExistingCustomerFragment extends AppCompatActivity{

    DatabaseHelper mDatabaseHelper;
    private TextView nameTextView;



    public ExistingCustomerFragment() {
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.customer_existing_activity);
        nameTextView = (TextView) findViewById(R.id.nameTextView);
        mDatabaseHelper = new DatabaseHelper(this);

        populateTextView();

    }

    private void populateTextView() {
        Cursor data = mDatabaseHelper.getAllData();
        ArrayList<String> nameData = new ArrayList<>();
        while(data.moveToNext()){
            nameData.add(data.getString(1));
        }



    }

}
