package com.deepu.user.dsa;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
/**
 * Created by User on 10/28/2017.
 */

public class admin extends Activity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.adminupdate);

    }
    public void add_driver(View v)
    {
        Intent i=new Intent(admin.this,adddriver.class);
        startActivity(i);
    }
    public void dr_list(View v)
    {
        Intent i=new Intent(admin.this,enquirylist.class);
        startActivity(i);
    }
    public void enq_list(View v)
    {
        Intent i=new Intent(admin.this,enquirylist.class);
        startActivity(i);
    }
}
