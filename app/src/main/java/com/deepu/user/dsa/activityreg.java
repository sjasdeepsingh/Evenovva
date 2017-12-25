package com.deepu.user.dsa;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by User on 10/25/2017.
 */

public class activityreg extends Activity {
    public static String act;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activityreg);
    }
public void activityregform(View v)
{
    Button b = (Button)v;
     Intent i=new Intent(activityreg.this,activityregform.class);
    startActivity(i);
    act = b.getText().toString();

    Toast.makeText(this, act, Toast.LENGTH_SHORT).show();


}
}

