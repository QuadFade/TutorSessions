package com.cop2660.android.tutorsessions;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class ExistingCustomer extends AppCompatActivity{
    //private Button mUpcomingSession;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.customer_existing_activity);
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


            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
