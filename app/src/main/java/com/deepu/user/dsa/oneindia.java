package com.deepu.user.dsa;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;

/**
 * Created by User on 10/26/2017.
 */

public class oneindia extends Activity {

ImageView iv;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.oneindia);
        iv= (ImageView) findViewById(R.id.user);

        iv.setImageResource(R.drawable.oneindia11);

    }
}