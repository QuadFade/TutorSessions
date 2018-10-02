package com.cop2660.android.tutorsessions;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.cop2660.android.tutorsessions.database.DatabaseHelper;

public class NewCustomer extends AppCompatActivity {
    DatabaseHelper customerDB;
    private Button btnSaveAll, btnViewData, btnAddImage;
    private EditText etNameText, etEmail, etPhoneNumber, etZipCode, etCity, etState, etStreetAddress;
    private static final int CAMERA_REQUEST = 1337;
    private ImageView imageView;
    private static final int MY_CAMERA_PERMISSION_CODE = 100;
    byte[] imageName;
    int imageId;
    static final int REQUEST_IMAGE_CAPTURE = 1;
    Bitmap theImage;

    //private Context mContext;
    //private SQLiteDatabase mDatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.customer_new_activity);
        customerDB = new DatabaseHelper(this);

        btnSaveAll = (Button) findViewById(R.id.btnSaveAll);
        btnViewData = (Button) findViewById(R.id.newBillingInformation);
        btnAddImage = (Button) findViewById(R.id.newImgButton);
        etNameText = (EditText) findViewById(R.id.nameTextView);
        etEmail = (EditText) findViewById(R.id.newEmailAddress);
        etPhoneNumber = (EditText) findViewById(R.id.newPhoneNumber);
        etZipCode = (EditText) findViewById(R.id.newZipCode);
        etCity = (EditText) findViewById(R.id.newCity);
        etState = (EditText) findViewById(R.id.newState);
        etStreetAddress = (EditText) findViewById(R.id.newStreetAddress);



        btnAddImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, CAMERA_REQUEST);

            }
        });


        AddData();

    }


    public void AddData() {

        btnSaveAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isInserted = customerDB.addData(etNameText.getText().toString(), etPhoneNumber.getText().toString(), etEmail.getText().toString(), etZipCode.getText().toString(),
                        etStreetAddress.getText().toString(), etCity.getText().toString(), etState.getText().toString(), btnAddImage.getText().toString());

                if (isInserted == true) {
                    Toast.makeText(NewCustomer.this, "Customer Entry Saved!", Toast.LENGTH_LONG).show();

                } else {
                    Toast.makeText(NewCustomer.this, "oof", Toast.LENGTH_LONG).show();
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
                return true;


            default:
                return super.onOptionsItemSelected(item);
        }
    }

//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        if (requestCode == CAMERA_REQUEST) {
//            Bitmap image = (Bitmap) data.getExtras().get("data");
//            ImageView imageview = (ImageView) findViewById(R.id.existingCustomerImage); //sets imageview as the bitmap
//            imageview.setImageBitmap(image);
//        }


        //  private void toastMessage(String message) {
        //  Toast.makeText(this,message, Toast.LENGTH_SHORT).show();
        //}



    public void callCamera(View view) {

            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            if(intent.resolveActivity(getPackageManager()) != null) {
                startActivityForResult(intent, REQUEST_IMAGE_CAPTURE);
            }
            startActivity(intent);
        }
    }
