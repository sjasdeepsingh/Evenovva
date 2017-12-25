package com.deepu.user.dsa;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

/**
 * Created by User on 10/19/2017.
 */

public class homepage extends Activity {
    ImageView imageView7,imageView,imageView2,imageView3,imageView4,ImageView5,imageView6;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homepage);
        imageView= (ImageView) findViewById(R.id.imageView);
        imageView4= (ImageView) findViewById(R.id.imageView4);

        imageView2= (ImageView) findViewById(R.id.imageView2);
        imageView3= (ImageView) findViewById(R.id.imageView3);
        ImageView5= (ImageView) findViewById(R.id.imageView5);
        imageView6= (ImageView) findViewById(R.id.imageView6);


        imageView.setImageResource(R.drawable.events);
        imageView4.setImageResource(R.drawable.online);
        imageView2.setImageResource(R.drawable.auto);
        imageView3.setImageResource(R.drawable.gallery);
        ImageView5.setImageResource(R.drawable.cu);
        imageView6.setImageResource(R.drawable.check);

    }
    public void upcomingevents(View v){
        Intent i=new Intent(homepage.this,registerevents.class);
        startActivity(i);
    }
    public void register(View v)
    {
        Intent i=new Intent(homepage.this,activityreg.class);
        startActivity(i);
    }
    public void enquiry(View v){
        Intent i=new Intent(homepage.this,enquiry.class);
        startActivity(i);

    }
    public void hirericks(View v){
        Intent i=new Intent(homepage.this,hirerick.class);
        startActivity(i);
    }
    public void events(View v){
        Intent i=new Intent(homepage.this,events.class);
        startActivity(i);
    }
    public void gallery(View v){
        Intent i=new Intent(homepage.this,gallery.class);
        startActivity(i);
    }

    public void contactus(View v){
        Intent i=new Intent(homepage.this,contact.class);
        startActivity(i);
    }
}
