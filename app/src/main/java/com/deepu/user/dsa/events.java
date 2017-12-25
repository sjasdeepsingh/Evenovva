package com.deepu.user.dsa;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by User on 10/26/2017.
 */

public class events extends Activity{
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.event);





    }
    public void youthvibe(View v){
        Intent i=new Intent(events.this,youthvibe.class);
        startActivity(i);
    }
    public void oneindia(View v){
        Intent i=new Intent(events.this,oneindia.class);
        startActivity(i);
    }
    public void oneworld(View v){
        Intent i=new Intent(events.this,oneworld.class);
        startActivity(i);
    }
}
