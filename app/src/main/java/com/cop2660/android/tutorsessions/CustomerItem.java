package com.cop2660.android.tutorsessions;

import android.support.v7.app.AppCompatActivity;

public class CustomerItem extends AppCompatActivity {
    private String head;
    private String descr;

    public CustomerItem(String head, String desc) {
        this.head = head;
        this.descr = desc;
    }


    public String getHead() {
        return head;
    }


    public String getDesc() {
        return descr;
    }

}
