package com.cop2660.android.tutorsessions;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.Delayed;


public class HomeActivity extends AppCompatActivity {
    private FragmentActivity mFragmentActivity;
    private Button mNewCustomer;
    private Button mExistingCustomer;
    private Button mNewSession;
    private Button mUpcomingSession;
    private Button mLoginbtn;
    private Button mLogoutbtn;
    private Fragment mNewCustomerFrag;



    private TextView mEmail;

    //private TextView mFrag;

    //private Button mLogout;
    // private Fragment mNewCustomerFrag = new NewCustomer();
    //private FragmentManager fragmentManager = getSupportFragmentManager();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        setHasOptionsMenu(true);
        TextView e = (TextView) findViewById(R.id.email_address);
        Bundle bu;
        bu = getIntent().getExtras();
        e.setText(bu.getString("emailReci"));

        mNewCustomer = (Button) findViewById(R.id.new_customer);
        mExistingCustomer = (Button) findViewById(R.id.existing_customer);
        mNewSession = (Button) findViewById(R.id.new_session);
        mUpcomingSession = (Button) findViewById(R.id.upcoming_session);



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

    @Override
    protected void onResume() {
        super.onResume();
        setHasOptionsMenu(true);
        TextView e = (TextView) findViewById(R.id.email_address);
        Bundle bu;
        bu = getIntent().getExtras();
        e.setText(bu.getString("emailReci"));
    }

    private void setHasOptionsMenu(boolean b) {



    }


    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.activity_home, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()) {
            case R.id.logout_option:
                Toast.makeText(this, "Logging You Off", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this, LoginActivity.class));
                return true;
                default:
                    return super.onOptionsItemSelected(item);

        }
    }

    }




