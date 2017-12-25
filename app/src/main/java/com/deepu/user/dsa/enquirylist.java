package com.deepu.user.dsa;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by User on 11/1/2017.
 */

public class enquirylist extends Activity {
    ArrayList<String> enq_person = new ArrayList<String>();
    ArrayList<String> enq_mobile = new ArrayList<String>();
    ArrayList<String> enq_phone = new ArrayList<String>();
    ArrayList<String> enq_sub = new ArrayList<String>();
    ArrayList<String> enq_desc = new ArrayList<String>();
    HashMap<String, String> map = new HashMap<String, String>();

    ListView lv;


    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list);
        lv = (ListView) findViewById(R.id.list);
        new getEnquiry().execute();
    }
    class getEnquiry extends AsyncTask<String, String, String> {
        ProgressDialog progressDialog;
        @Override
        protected void onPreExecute() {
            progressDialog=new ProgressDialog(enquirylist.this);
            progressDialog.setTitle("Loading....");
            progressDialog.show();
        }

        @Override
        protected String doInBackground(String... params) {
            HashMap<String, String> map=new HashMap<String, String>();
            RequestHandler handler=new RequestHandler();
            map.put("action", "list");
            return handler.sendPostRequest(" http://192.168.1.40:80/android/enquiry.php ", map);
        }

        @Override
        protected void onPostExecute(String s) {
            progressDialog.dismiss();
            try{
                JSONObject jsonObject =new JSONObject(s);
                JSONArray jsonArray=jsonObject.getJSONArray("Data");
                for(int i=0; i<jsonArray.length(); i++)
                {
                    JSONObject obj=jsonArray.getJSONObject(i);
                    enq_person.add(obj.getString("enq_person"));
                    enq_mobile.add(obj.getString("enq_mobile"));
                    enq_phone.add(obj.getString("enq_phone"));
                    enq_sub.add(obj.getString("enq_sub"));
                    enq_desc.add(obj.getString("enq_desc"));
                }
            }
            catch (JSONException e){
                Toast.makeText(enquirylist.this, ""+e.getMessage(), Toast.LENGTH_SHORT).show();
            }
            lv.setAdapter(new Data());

        }
    }
    class Data extends BaseAdapter {

        LayoutInflater inf=getLayoutInflater();
        @Override
        public int getCount() {
            return enq_person.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            convertView=inf.inflate(R.layout.enquirylist, null);
            TextView name=(TextView)convertView.findViewById(R.id.eql_person);
            TextView mobile=(TextView)convertView.findViewById(R.id.eql_mobile);
            TextView phone=(TextView)convertView.findViewById(R.id.eql_phone);
            TextView sub=(TextView)convertView.findViewById(R.id.eql_subject);
            TextView desc=(TextView)convertView.findViewById(R.id.eql_desc);

            name.setText(enq_person.get(position));
            mobile.setText(enq_mobile.get(position));
            phone.setText(enq_phone.get(position));
            sub.setText(enq_sub.get(position));
            desc.setText(enq_desc.get(position));
            return convertView;
        }
    }

}
