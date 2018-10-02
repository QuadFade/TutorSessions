package com.cop2660.android.tutorsessions;

import android.content.Context;
import android.content.Intent;
import android.provider.MediaStore;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import static android.support.v4.app.ActivityCompat.startActivityForResult;


public class RecyclerViewAdapter extends  RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private static final String TAG = "RecyclerViewAdapter";
    private static final int CAMERA_REQUEST = 1;

    public ArrayList<String> mCustomerNames = new ArrayList<>();
    public ArrayList<String> mImages = new ArrayList<>();
    public Context mContext;


    public RecyclerViewAdapter(Context context, ArrayList<String> customerNames, ArrayList<String> images) {
        mCustomerNames = customerNames;
        mImages = images;
        mContext = context;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.customer_list, viewGroup, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int i) {
        Log.d(TAG, "onBindViewGHolder: called");

        holder.customerName.setText(mCustomerNames.get(i));
        //holder.image.setImageBitmap(mImages.get(i));


    }

    @Override
    public int getItemCount() {
        return mCustomerNames.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView customerName;
        RelativeLayout parentLayout;

        public ViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            customerName = itemView.findViewById(R.id.customer_name);
            parentLayout = itemView.findViewById(R.id.parent_layout);

            parentLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ((ExistingCustomer) mContext).userCustomerClick(getAdapterPosition());


                }
            });
        }
    }

}