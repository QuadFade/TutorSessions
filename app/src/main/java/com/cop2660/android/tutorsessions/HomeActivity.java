package com.cop2660.android.tutorsessions;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;


public class HomeActivity extends AppCompatActivity {
    private FragmentActivity mFragmentActivity;
    private Button mNewCustomer;
    private Button mExistingCustomer;
    private Button mNewSession;
    private Button mUpcomingSession;
    private Button mLoginbtn;
    private Button mLogoutbtn;
    private Fragment mNewCustomerFrag;

    //private TextView mFrag;

    //private Button mLogout;
    // private Fragment mNewCustomerFrag = new NewCustomer();
    //private FragmentManager fragmentManager = getSupportFragmentManager();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        mNewCustomer = (Button) findViewById(R.id.new_customer);
        mExistingCustomer = (Button) findViewById(R.id.existing_customer);
        mNewSession = (Button) findViewById(R.id.new_session);
        mUpcomingSession = (Button) findViewById(R.id.upcoming_session);
        mLoginbtn = (Button) findViewById(R.id.login_btn);
        mLogoutbtn = (Button) findViewById(R.id.logout_btn);

        mNewCustomer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, NewCustomer.class);
                startActivity(intent);

            }

        });
        mExistingCustomer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, ExistingCustomer.class);
                startActivity(intent);

            }

        });
        mNewSession.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, NewSession.class);
                startActivity(intent);

            }
        });
        mUpcomingSession.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, UpcomingSessions.class);
                startActivity(intent);

            }
        });

        }

    public void selectFrag (View view){
        Fragment fr = new Fragment();
        if (view == findViewById(R.id.login_btn))
            fr = new UserFragment();
        else if (view == findViewById(R.id.logout_btn))
            fr = new GuestFragment();


        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.fragment, fr);
        transaction.commit();

    }


}
