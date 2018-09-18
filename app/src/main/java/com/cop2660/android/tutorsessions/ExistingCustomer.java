package com.cop2660.android.tutorsessions;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.cop2660.android.tutorsessions.database.DatabaseHelper;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class ExistingCustomer extends AppCompatActivity {
    //private Button mUpcomingSession;

    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mImages = new ArrayList<>();
    DatabaseHelper customerDBView;
    TextView customerNameView;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choosecustomerlist);
        customerDBView = new DatabaseHelper(this);
        customerNameView = (TextView) findViewById(R.id.customer_name);

        initImageBitmaps();


    }
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.activity_home, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
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

    private void initImageBitmaps(){
        TextView e = (TextView) findViewById(R.id.customer_name_test);

        Cursor result = customerDBView.getAllData();
        //ArrayList<String> mNames = new ArrayList<>();
        if(result.getCount() == 0){
            Toast.makeText(this,"The Database was empty :(",Toast.LENGTH_LONG).show();
        }else { if(result.getCount() != 0){

        }

        while (result.moveToNext()) {
            mNames.add(result.getString(1));
        }
        }

        initRecyclerView();

//
//
//
//        mNames.add("Name", buffer.toString());
//
//        //mImages.add("http://www.suttonsilver.co.uk/wp-content/uploads/blog-harold-02.jpg");
//
//        mNames.add("Hailey Coprp");
//        //mImages.add("http://www.suttonsilver.co.uk/wp-content/uploads/blog-harold-02.jpg");
//
//        mNames.add("Jeepers Creeeps");
//        //mImages.add("http://www.suttonsilver.co.uk/wp-content/uploads/blog-harold-02.jpg");
//
//        mNames.add("caloiys jones");
//        //mImages.add("http://www.suttonsilver.co.uk/wp-content/uploads/blog-harold-02.jpg");
//
//        mNames.add("Whilds Joe");
//        //mImages.add("http://www.suttonsilver.co.uk/wp-content/uploads/blog-harold-02.jpg");
//
//        mNames.add("Steven");



    }



    private void initRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.existing_cRecycler);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, mNames, mImages);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


    }


}

