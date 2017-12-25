package com.deepu.user.dsa;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;

/**
 * Created by User on 10/19/2017.
 */

public class Login extends AppCompatActivity {
    EditText userid, pwd;
    HashMap<String, String> map = new HashMap<String, String>();
   public static String id;

    protected void onCreate(Bundle savedIntanceState) {

        super.onCreate(savedIntanceState);
        setContentView(R.layout.login);

        userid = (EditText) findViewById(R.id.userid);
        pwd = (EditText) findViewById(R.id.pwd);
    }

    public void login(View v) {

        if (userid.getText().toString().trim().length() == 0) {

            Toast.makeText(getApplicationContext(), "Please Enter id", Toast.LENGTH_LONG).show();
        } else if (pwd.getText().toString().trim().length() == 0) {

            Toast.makeText(getApplicationContext(), "Please Enter password", Toast.LENGTH_LONG).show();
        } else if(userid.getText().toString().equals("admin") && (pwd.getText().toString().equals("pwd")))
        {
            Intent i = new Intent(Login.this, admin.class);
            startActivity(i);
        }
        else if(userid.getText().toString().equals("11401951") && (pwd.getText().toString().equals("pwd")))
        {
            Intent i = new Intent(Login.this, homepage.class);
            startActivity(i);
        } if(userid.getText().toString().equals("11400664") && (pwd.getText().toString().equals("pwd")))
        {
            Intent i = new Intent(Login.this, homepage.class);
            startActivity(i);
        }
        else{

            new CheckLogin().execute();
            id = userid.getText().toString();

        }
    }

 class CheckLogin extends AsyncTask<String, String, String> {
        ProgressDialog progressDialog;

        @Override
        protected void onPreExecute() {
            progressDialog = new ProgressDialog(Login.this);
            progressDialog.setTitle("Loading....");
            progressDialog.show();
        }

        @Override
        protected String doInBackground(String... params) {
            RequestHandler handler = new RequestHandler();


            map.put("action", "login");
            return handler.sendPostRequest(" http://192.168.0.18:80/android/login.php", map);


        }

        @Override
        protected void onPostExecute(String s) {
            progressDialog.dismiss();
            Toast.makeText(Login.this, "" + s, Toast.LENGTH_SHORT).show();
            if(s==null)
                Toast.makeText(Login.this, "" + s, Toast.LENGTH_SHORT).show();

            else if(s.equals("1")) {
                Intent i = new Intent(Login.this, homepage.class);
                startActivity(i);

            } else
                Toast.makeText(Login.this, "incorrect username and password", Toast.LENGTH_LONG).show();
        }

    }
}


