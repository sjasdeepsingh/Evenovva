package com.deepu.user.dsa;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.HashMap;




/**
 * Created by User on 11/23/2017.
 */

public class hirerick extends Activity implements AdapterView.OnItemSelectedListener {
    String[] source = {"Main Gate", "55,56"};
    String[] destination = {"Main Gate", "34", "55,56"};
    HashMap<String, String> map = new HashMap<String, String>();

    public static String s,d;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hire_rick);

        Spinner from = (Spinner) findViewById(R.id.from);
        ArrayAdapter<String> aa = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, source);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        from.setAdapter(aa);
        from.setOnItemSelectedListener(this);
        Spinner to = (Spinner) findViewById(R.id.to);
        ArrayAdapter<String> bb = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, destination);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        to.setAdapter(bb);
        to.setOnItemSelectedListener(this);
    }

    public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {
        Spinner from = (Spinner) parent;
        Spinner to = (Spinner) parent;
        if (from.getId() == R.id.from) {
            s = from.getSelectedItem().toString();
        }
        if (to.getId() == R.id.to) {
            d = to.getSelectedItem().toString();
        }

    }

    public void onNothingSelected(AdapterView<?> parent) {
        //  Toast.makeText(this, "select any source", Toast.LENGTH_SHORT).show();
    }

    public void Book(View v) {


        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
        Toast.makeText(this, d, Toast.LENGTH_SHORT).show();
        Intent i = new Intent(hirerick.this, bookform.class);
        startActivity(i);

    }



}
