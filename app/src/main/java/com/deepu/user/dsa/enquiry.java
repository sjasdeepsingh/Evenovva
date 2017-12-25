package com.deepu.user.dsa;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;

/**
 * Created by User on 10/28/2017.
 */

public class enquiry extends Activity {
    EditText enq_person, enq_mobile, enq_sub, enq_desc,enq_phone;
    HashMap<String, String> map = new HashMap<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.enquiry);
        enq_person = (EditText) findViewById(R.id.enq_person);
        enq_mobile = (EditText) findViewById(R.id.enq_mobile);
        enq_phone = (EditText) findViewById(R.id.enq_phone);
        enq_sub = (EditText) findViewById(R.id.enq_sub);
        enq_desc = (EditText) findViewById(R.id.enq_desc);


    }

    public void enqsubmit(View v)

    {
        if (enq_person.getText().toString().trim().length() == 0)

            Toast.makeText(getApplicationContext(), "please Enter Name", Toast.LENGTH_LONG).show();


        else if (enq_mobile.getText().toString().trim().length() == 0)

            Toast.makeText(getApplicationContext(), "please Enter Mobile", Toast.LENGTH_LONG).show();
        else  if (enq_phone.getText().toString().trim().length() == 0)

            Toast.makeText(getApplicationContext(), "please Enter alternate number", Toast.LENGTH_LONG).show();

        else if (enq_sub.getText().toString().trim().length() == 0)

            Toast.makeText(getApplicationContext(), "please Enter Subject", Toast.LENGTH_LONG).show();

        else if (enq_desc.getText().toString().trim().length() == 0)

            Toast.makeText(getApplicationContext(), "please Enter Description", Toast.LENGTH_LONG).show();

        else {
            map.put("enq_person", enq_person.getText().toString());
            map.put("enq_mobile", enq_mobile.getText().toString());
            map.put("enq_sub", enq_sub.getText().toString());
            map.put("enq_phone", enq_phone.getText().toString());
            map.put("enq_desc", enq_desc.getText().toString());
            map.put("action", "submit");
            new Enqsubmit().execute();
        }
    }
    class Enqsubmit extends AsyncTask<String, String, String> {
        ProgressDialog progressDialog;

        @Override
        protected void onPreExecute() {
            progressDialog = new ProgressDialog(enquiry.this);
            progressDialog.setTitle("Loading....");
            progressDialog.show();
        }

        @Override
        protected String doInBackground(String... strings) {
            RequestHandler handler = new RequestHandler();
            return handler.sendPostRequest(" http://192.168.1.40:80/android/enquiry.php", map);
        }

        @Override
        protected void onPostExecute(String s) {
            progressDialog.dismiss();
            if (s==null) {
                Toast.makeText(enquiry.this, "Please Contact To Adminstration", Toast.LENGTH_LONG).show();
            } else if (s.equals("1"))
            {
                Toast.makeText(getApplicationContext(), "Enquiry Added Successfully", Toast.LENGTH_LONG).show();
                startActivity(new Intent(enquiry.this, homepage.class));
            }else
            {
                Toast.makeText(getApplicationContext(), "Enquiry  Not Added Successfully", Toast.LENGTH_LONG).show();
            }
        }


    }
}


