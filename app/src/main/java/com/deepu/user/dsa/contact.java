package com.deepu.user.dsa;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;

/**
 * Created by User on 12/23/2017.
 */


    public class contact extends Activity {
        ImageView iv1,iv2,iv3;
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.contact);

           iv1= (ImageView) findViewById(R.id.iv1);
           iv2= (ImageView) findViewById(R.id.iv2);
            iv3= (ImageView) findViewById(R.id.iv3);

           iv1.setImageResource(R.drawable.i1);
            iv2.setImageResource(R.drawable.i4);
            iv3.setImageResource(R.drawable.i5);

        }

    }
