package com.cop2660.android.tutorsessions;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;


public class HomeActivity extends AppCompatActivity {
    private FragmentActivity mFragmentActivity;
    private Button mNewCustomer;
    private Button mExistingCustomer;
    private Button mNewSession;
    private Button mUpcomingSession;
    //private Button mLogout;
   // private Fragment mNewCustomerFrag = new NewCustomer();
    //private FragmentManager fragmentManager = getSupportFragmentManager();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
            mNewCustomer = (Button) findViewById(R.id.new_customer);
            mExistingCustomer = (Button) findViewById(R.id.existing_customer);
            mNewSession = (Button) findViewById(R.id.new_session);
            mUpcomingSession = (Button) findViewById(R.id.upcoming_session);
           // mNewCustomerFrag = (Fragment) findFragmentByTag(Tag, "NewFrag");

        mNewCustomer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent intent = new Intent(HomeActivity.this, NewCustomer.class);
                startActivity(intent);

                }

        });
        mExistingCustomer.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(HomeActivity.this, ExistingCustomer.class);
                startActivity(intent);

            }

        });
        mNewSession.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(HomeActivity.this, NewCustomer.class);
                startActivity(intent);

            }
        });
        mUpcomingSession.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(HomeActivity.this, NewCustomer.class);
                startActivity(intent);

            }
        });
}
}
