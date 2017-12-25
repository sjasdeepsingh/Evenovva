package com.deepu.user.dsa;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;

import static com.deepu.user.dsa.activityreg.act;


/**
 * Created by User on 10/25/2017.
 */

public class activityregform extends Activity {
    EditText name,regno,email,mobile,activity;
    HashMap<String, String> map=new HashMap<String, String>();
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activityregform);
        name= (EditText) findViewById(R.id.name);
        regno= (EditText) findViewById(R.id.regno);
        email= (EditText) findViewById(R.id.email);
        mobile= (EditText) findViewById(R.id.mobile);
        activity= (EditText) findViewById(R.id.activity);
        activity.setText(act);


    }
    public void register(View v){
        if (name.getText().toString().trim().length() == 0) {

            Toast.makeText(getApplicationContext(), "Please Enter name", Toast.LENGTH_LONG).show();
        } else if (regno.getText().toString().trim().length() == 0) {

            Toast.makeText(getApplicationContext(), "Please Enter registration number", Toast.LENGTH_LONG).show();
        } else if (email.getText().toString().trim().length() == 0) {

            Toast.makeText(getApplicationContext(), "Please Enter email", Toast.LENGTH_LONG).show();
        } else if (mobile.getText().toString().trim().length() == 0) {

            Toast.makeText(getApplicationContext(), "Please Enter mobile number", Toast.LENGTH_LONG).show();
        } else if (activity.getText().toString().trim().length() == 0) {

            Toast.makeText(getApplicationContext(), "Please select activity", Toast.LENGTH_LONG).show();
        } else
            {

                map.put("name", name.getText().toString());
                map.put("regno", regno.getText().toString());
                map.put("email", email.getText().toString());
                map.put("mobile", mobile.getText().toString());
                map.put("activity", activity.getText().toString());
                map.put("action", "register");
                new RegisterActivity().execute();
        }
    }
    class RegisterActivity extends AsyncTask<String, String, String> {
        ProgressDialog progressDialog;
        @Override
        protected void onPreExecute() {
            progressDialog=new ProgressDialog(activityregform.this);
            progressDialog.setTitle("Loading....");
            progressDialog.show();

        }

        @Override
        protected String doInBackground(String... params) {
            RequestHandler handler=new RequestHandler();
            return handler.sendPostRequest(" http://192.168.1.40:80/android/register.php ", map);
        }

        @Override
        protected void onPostExecute(String s) {
            progressDialog.dismiss();

            if(s==null)
                Toast.makeText(activityregform.this, "Please Contact To Administer", Toast.LENGTH_SHORT).show();
            else if(s.equals("1"))
            {
                Toast.makeText(getApplicationContext(), "Activity registered Successfully ", Toast.LENGTH_LONG).show();

            }else

                Toast.makeText(getApplicationContext(), "Activity not registered", Toast.LENGTH_LONG).show();
        }
    }
}


