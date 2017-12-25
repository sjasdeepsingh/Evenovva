package com.deepu.user.dsa;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;


import static com.deepu.user.dsa.hirerick.d;
import static com.deepu.user.dsa.hirerick.s;
import static com.deepu.user.dsa.Login.id;

/**
 * Created by User on 12/23/2017.
 */

public class bookform extends Activity {
    EditText src, des, mob, seats, regno;
    HashMap<String, String> map = new HashMap<String, String>();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bookform);
        src = (EditText) findViewById(R.id.source);
        regno = (EditText) findViewById(R.id.regn);
        des = (EditText) findViewById(R.id.destination);
        mob = (EditText) findViewById(R.id.mobile);
        seats = (EditText) findViewById(R.id.seats);
        src.setText(s);
        des.setText(d);
        regno.setText(id);

    }

    public void book(View v) {
        if (src.getText().toString().trim().length() == 0) {

            Toast.makeText(getApplicationContext(), "Please Enter source", Toast.LENGTH_LONG).show();
        } else if (regno.getText().toString().trim().length() == 0) {

            Toast.makeText(getApplicationContext(), "Please Enter registration number", Toast.LENGTH_LONG).show();
        } else if (seats.getText().toString().trim().length() == 0) {

            Toast.makeText(getApplicationContext(), "Please Enter seats", Toast.LENGTH_LONG).show();
        } else if (mob.getText().toString().trim().length() == 0) {

            Toast.makeText(getApplicationContext(), "Please Enter mobile number", Toast.LENGTH_LONG).show();
        } else if (des.getText().toString().trim().length() == 0) {

            Toast.makeText(getApplicationContext(), "Please select destination", Toast.LENGTH_LONG).show();
        } else {
            map.put("source", src.getText().toString());
            map.put("destination", des.getText().toString());
            map.put("seats", seats.getText().toString());
            map.put("regno", regno.getText().toString());
            map.put("mobile", mob.getText().toString());
            map.put("action", "book");
            new bookrick().execute();
        }
    }

    class bookrick extends AsyncTask<String, String, String> {
        ProgressDialog progressDialog;

        @Override
        protected void onPreExecute() {
            progressDialog = new ProgressDialog(bookform.this);
            progressDialog.setTitle("Loading....");
            progressDialog.show();

        }

        @Override
        protected String doInBackground(String... params) {
            RequestHandler handler = new RequestHandler();
            return handler.sendPostRequest(" http://192.168.1.40:80/android/hirerick.php", map);
        }

        @Override
        protected void onPostExecute(String s) {
            progressDialog.dismiss();

            if (s == null)
                Toast.makeText(bookform.this, "Please Contact To Administer", Toast.LENGTH_SHORT).show();
            else if (s.equals("1")) {
                Toast.makeText(getApplicationContext(), "booked Successfully ", Toast.LENGTH_LONG).show();

            } else

                Toast.makeText(getApplicationContext(), " not booked", Toast.LENGTH_LONG).show();
        }
    }
}




