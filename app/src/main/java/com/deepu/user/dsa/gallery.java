package com.deepu.user.dsa;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;

/**
 * Created by User on 12/22/2017.
 */

public class gallery extends Activity {
ImageView iv1,iv2,iv3,iv4,iv5,iv6,iv7,iv8,iv9,iv10,iv11,iv12,iv13,iv14,iv15,iv16;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gallery);
        iv1= (ImageView) findViewById(R.id.iv1);
        iv2= (ImageView) findViewById(R.id.iv2);
        iv4= (ImageView) findViewById(R.id.iv4);
        iv6= (ImageView) findViewById(R.id.iv6);
        iv7= (ImageView) findViewById(R.id.iv7);
        iv8= (ImageView) findViewById(R.id.iv8);




        iv1.setImageResource(R.drawable.i1);
        iv2.setImageResource(R.drawable.i5);
        iv4.setImageResource(R.drawable.i4);
        iv6.setImageResource(R.drawable.i6);
      iv7.setImageResource(R.drawable.i7);
        iv8.setImageResource(R.drawable.i8);


    }
}