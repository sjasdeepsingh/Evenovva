package com.deepu.user.dsa;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;

/**
 * Created by User on 11/12/2017.
 */

public class adddriver extends Activity {
    EditText dr_name, dr_id, dr_mob, dr_rickno,dr_pwd;
    HashMap<String, String> map = new HashMap<String, String>();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.adddriver);
        dr_name = (EditText) findViewById(R.id.userid);
        dr_id = (EditText) findViewById(R.id.pwd);
        dr_mob = (EditText) findViewById(R.id.dr_mob);
        dr_rickno = (EditText) findViewById(R.id.dr_rickno);
        dr_pwd = (EditText) findViewById(R.id.dr_pwd);

    }
    public void addrick(View v){
        if (dr_name.getText().toString().trim().length() == 0) {

            Toast.makeText(getApplicationContext(), "Please Enter name", Toast.LENGTH_LONG).show();
        } else if (dr_id.getText().toString().trim().length() == 0) {

            Toast.makeText(getApplicationContext(), "Please Enter id", Toast.LENGTH_LONG).show();
        } else if (dr_mob.getText().toString().trim().length() == 0) {

            Toast.makeText(getApplicationContext(), "Please Enter mobile no", Toast.LENGTH_LONG).show();
        } else if (dr_rickno.getText().toString().trim().length() == 0) {

            Toast.makeText(getApplicationContext(), "Please Enter rick number", Toast.LENGTH_LONG).show();
        }  else if (dr_pwd.getText().toString().trim().length() == 0) {

            Toast.makeText(getApplicationContext(), "Please Enter Password", Toast.LENGTH_LONG).show();
        }
        else
        {
            map.put("dr_name", dr_name.getText().toString());
            map.put("dr_mob", dr_mob.getText().toString());
            map.put("dr_id", dr_id.getText().toString());
            map.put("dr_rickno", dr_rickno.getText().toString());
            map.put("dr_pwd", dr_pwd.getText().toString());
            map.put("action", "add");
            new add_rick().execute();
        }
    }
    class add_rick extends AsyncTask<String, String, String> {
        ProgressDialog progressDialog;
        @Override
        protected void onPreExecute() {
            progressDialog=new ProgressDialog(adddriver.this);
            progressDialog.setTitle("Loading....");
            progressDialog.show();
        }

        @Override
        protected String doInBackground(String... params) {
            RequestHandler handler=new RequestHandler();
            return handler.sendPostRequest(" http://192.168.1.40:80/android/driver.php", map);
        }

        @Override
        protected void onPostExecute(String s) {
            progressDialog.dismiss();

            if(s==null)
                Toast.makeText(adddriver.this, "error occured", Toast.LENGTH_SHORT).show();
            else if(s.equals("1"))
            {
                Toast.makeText(getApplicationContext(), "registered Successfully ", Toast.LENGTH_LONG).show();

            }else

                Toast.makeText(getApplicationContext(), "not added ", Toast.LENGTH_LONG).show();
        }
    }
}

