package com.cop2660.android.tutorsessions;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.cop2660.android.tutorsessions.database.CustomerDbSchema;
import com.cop2660.android.tutorsessions.database.DatabaseHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class NewCustomer extends AppCompatActivity {
    DatabaseHelper customerDB;
    private Button btnSaveAll, btnViewData;
    private EditText etNameText,etEmail,etPhoneNumber,etZipCode;
            //etCity,etState,etStreetAddress;
    //private Context mContext;
    //private SQLiteDatabase mDatabase;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.customer_new_activity);
        customerDB = new DatabaseHelper(this);

        btnSaveAll = (Button) findViewById(R.id.btnSaveAll);
        btnViewData = (Button) findViewById(R.id.newBillingInformation);
        etNameText = (EditText) findViewById(R.id.newNameText);
        etEmail = (EditText) findViewById(R.id.newEmailAddress);
        etPhoneNumber = (EditText) findViewById(R.id.newPhoneNumber);
        etZipCode = (EditText) findViewById(R.id.newZipCode);
//        etCity = (EditText) findViewById(R.id.newCity);
//        etState = (EditText) findViewById(R.id.newState);
//        etStreetAddress = (EditText) findViewById(R.id.newStreetAddress);

        AddData();

    }



    public void AddData(){

        btnSaveAll.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
               boolean isInserted = customerDB.addData(
                       etNameText.getText().toString(), etPhoneNumber.getText().toString(), etEmail.getText().toString(), etZipCode.getText().toString());
                       //etStreetAddress.getText().toString(), etCity.getText().toString(), etState.getText().toString());

                if(isInserted == true) {
                    Toast.makeText(NewCustomer.this, "Data entered!",Toast.LENGTH_LONG).show();

                } else {
                    Toast.makeText(NewCustomer.this, "Something goofed",Toast.LENGTH_LONG).show();
                }
            }

        });

//       btnViewData.setOnClickListener(new View.OnClickListener() {
//           @Override
//           public void onClick(View v) {
//               String newEntry = etNameText.getText().toString();
//               if (etNameText.length() != 0) {
//                   AddData(newEntry);
//                   etNameText.setText("");
//                   } else {
//                   toastMessage("You must enter a name!"); }
//                   }
//       });



    }



    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.activity_home, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()) {
            case R.id.logout_option:
                startActivity(new Intent(this, LoginActivity.class));
                return true;
            case R.id.home_option:
                startActivity(new Intent(this, HomeActivity.class));
                return true;


            default:
                return super.onOptionsItemSelected(item);
        }
    }


  //  private void toastMessage(String message) {
    //  Toast.makeText(this,message, Toast.LENGTH_SHORT).show();
   //}




}
