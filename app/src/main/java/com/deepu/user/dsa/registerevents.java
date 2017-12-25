package com.deepu.user.dsa;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import static com.deepu.user.dsa.R.id.event_name;


/**
 * Created by User on 11/12/2017.
 */

public class registerevents extends Activity implements AdapterView.OnItemSelectedListener {

    String[] name = {"Zakir Show", "Quiz", "spectra"};
    String[] role = {"as a participant", "as a co-ordinator"};
    String event;
   public String n,r;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registerevents);

        Spinner event_name = (Spinner) findViewById(R.id.event_name);
        ArrayAdapter<String> aa = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, name);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        event_name.setAdapter(aa);
        event_name.setOnItemSelectedListener(this);

        Spinner event_role = (Spinner) findViewById(R.id.event_role);
        ArrayAdapter<String> bb = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, role);
        bb.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        event_role.setAdapter(bb);
        event_role.setOnItemSelectedListener(this);


    }

    public void onItemSelected(AdapterView<?> parent, View v, int position, long id ) {

        Spinner event_name = (Spinner)parent;
        Spinner event_role = (Spinner)parent;
       if(event_name.getId() == R.id.event_name)
        {
            n = event_name.getSelectedItem().toString();
        }
        if(event_role.getId() == R.id.event_role)
        {
            r = event_role.getSelectedItem().toString();
        }


    }

    public void onNothingSelected(AdapterView<?> parent){
        Toast.makeText(this, "select any event", Toast.LENGTH_SHORT).show();
    }

    public void evregister(View v)
    {

        Toast.makeText(this, n, Toast.LENGTH_SHORT).show();
        Toast.makeText(this,r, Toast.LENGTH_SHORT).show();


    }
}