package com.cop2660.android.tutorsessions;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

public class UpcomingSessions extends AppCompatActivity  {
   /* private RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.customer_recycler);
    private RecyclerView.Adapter mAdapter = new MyAdapter.(myDataset);
    private RecyclerView.LayoutManager mLayoutManager;
            */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sessions);

       /* mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
        */



        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Schedule a New Session", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

            }
        });






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

}
