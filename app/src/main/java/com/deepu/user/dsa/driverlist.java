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

public class driverlist extends Activity {
    ArrayList<String> dr_name = new ArrayList<String>();
    ArrayList<String> dr_id = new ArrayList<String>();
    ArrayList<String> dr_mob = new ArrayList<String>();
    ArrayList<String> dr_rickno = new ArrayList<String>();
    ArrayList<String> dr_pwd = new ArrayList<String>();

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
            progressDialog=new ProgressDialog(driverlist.this);
            progressDialog.setTitle("Loading....");
            progressDialog.show();
        }

        @Override
        protected String doInBackground(String... params) {
            HashMap<String, String> map=new HashMap<String, String>();
            RequestHandler handler=new RequestHandler();
            map.put("action", "list");
            return handler.sendPostRequest(" http://192.168.1.40:80/android/driver.php ", map);
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
                    dr_name.add(obj.getString("dr_name"));
                    dr_id.add(obj.getString("dr_id"));
                    dr_mob.add(obj.getString("dr_mob"));
                    dr_rickno.add(obj.getString("dr_rickno"));
                    dr_pwd.add(obj.getString("dr_pwd"));
                }
            }
            catch (JSONException e){
                Toast.makeText(driverlist.this, ""+e.getMessage(), Toast.LENGTH_SHORT).show();
            }
            lv.setAdapter(new Data());

        }
    }
    class Data extends BaseAdapter {

        LayoutInflater inf=getLayoutInflater();
        @Override
        public int getCount() {
            return dr_name.size();
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
            convertView=inf.inflate(R.layout.driverlist, null);
            TextView name=(TextView)convertView.findViewById(R.id.drl_name);
            TextView mobile=(TextView)convertView.findViewById(R.id.drl_mob);
            TextView id=(TextView)convertView.findViewById(R.id.drl_id);
            TextView rickno=(TextView)convertView.findViewById(R.id.dr_rickno);

            name.setText(dr_name.get(position));
            id.setText(dr_id.get(position));
            mobile.setText(dr_mob.get(position));
            rickno.setText(dr_rickno.get(position));
            return convertView;
        }
    }

}
