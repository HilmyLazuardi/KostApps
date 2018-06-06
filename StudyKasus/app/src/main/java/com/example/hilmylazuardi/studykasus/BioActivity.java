package com.example.hilmylazuardi.studykasus;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.example.hilmylazuardi.studykasus.adapter.Adapter;
import com.example.hilmylazuardi.studykasus.app.AppController;
import com.example.hilmylazuardi.studykasus.data.Data;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BioActivity extends AppCompatActivity implements SwipeRefreshLayout.OnClickListener, SwipeRefreshLayout.OnRefreshListener {
    Toolbar toolbar;
    ListView list;
    SwipeRefreshLayout swipe;
    List<Data> itemlist = new ArrayList<Data>();
    Adapter adapter;
    int success;
    AlertDialog.Builder dialog;
    LayoutInflater inflater;
    View dialogView;
    EditText txt_id_users, txt_nama, txt_alamat, txt_status;
    String id_users, nama, alamat, status;

    private final String TAG = BioActivity.class.getSimpleName();
    private static String url_select     = Server.URL + "select.php";
    private static String url_edit       = Server.URL + "edit.php";
    private static String url_update     = Server.URL + "update.php";

    public static final String TAG_ID_USERS = "id_users";
    public static final String TAG_NAMA     = "nama";
    public static final String TAG_ALAMAT   = "alamat";
    public static final String TAG_STATUS   = "status";
    private static final String TAG_SUCCESS = "success";
    private static final String TAG_MESSAGE = "message";
    public static final String TAG_USERNAME = "username";

    String tag_json_obj="json_obj_req";
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bio);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        swipe = (SwipeRefreshLayout) findViewById(R.id.swipe_refresh_layout);
        list = (ListView) findViewById(R.id.list);
        adapter = new Adapter(BioActivity.this, itemlist);
        list.setAdapter(adapter);

        swipe.setOnRefreshListener(this);
        swipe.post(new Runnable() {
                       @Override
                       public void run() {
                           swipe.setRefreshing(true);
                           itemlist.clear();
                           adapter.notifyDataSetChanged();
                           callVolley();
                       }
                   }
        );

        list.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(final AdapterView<?> parent, View view,
                                           final int position, long id) {
                final String id_usersx = itemlist.get(position).getId_users();
                final CharSequence[] dialogitem = {"Edit"};
                dialog = new AlertDialog.Builder(BioActivity.this);
                dialog.setCancelable(true);
                dialog.setItems(dialogitem, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which){
                            case 0:
                                edit(id_usersx);
                                break;
                        }
                    }
                }).show();
                return false;
            }
        });
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void onRefresh() {
        itemlist.clear();
        adapter.notifyDataSetChanged();
        callVolley();
    }

    private void kosong(){
        txt_id_users.setText(null);
        txt_nama.setText(null);
        txt_alamat.setText(null);
        txt_status.setText(null);
    }

    private void DialogForm(final String id_usersx, String namax, String alamatx, String statusx, String button){
        dialog = new AlertDialog.Builder(BioActivity.this);
        inflater = getLayoutInflater();
        dialogView = inflater.inflate(R.layout.form_biodata, null);
        dialog.setView(dialogView);
        dialog.setCancelable(true);
        dialog.setIcon(R.mipmap.ic_launcher);
        dialog.setTitle("Form Biodata");

        txt_id_users = (EditText) dialogView.findViewById(R.id.txt_id_users);
        txt_nama = (EditText) dialogView.findViewById(R.id.txt_nama);
        txt_alamat = (EditText) dialogView.findViewById(R.id.txt_alamat);
        txt_status = (EditText) dialogView.findViewById(R.id.txt_status);

        if (!id_usersx.isEmpty()){
            txt_id_users.setText(id_usersx);
            txt_nama.setText(namax);
            txt_alamat.setText(alamatx);
            txt_status.setText(statusx);
        } else {
            kosong();
        }
        dialog.setPositiveButton(button, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                id_users = txt_id_users.getText().toString();
                nama = txt_nama.getText().toString();
                alamat = txt_alamat.getText().toString();
                status = txt_status.getText().toString();

                simpan_update();
                dialog.dismiss();
            }
        });
        dialog.setNegativeButton("BATAL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                kosong();
            }
        });
        dialog.show();
    }

    private void callVolley(){
        itemlist.clear();
        adapter.notifyDataSetChanged();
        swipe.setRefreshing(true);

        JsonArrayRequest jArr = new JsonArrayRequest(url_select, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                Log.d(TAG, response.toString());

                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject obj = response.getJSONObject(i);

                        Data item = new Data();

                        item.setId_users(obj.getString(TAG_ID_USERS));
                        item.setNama(obj.getString(TAG_NAMA));
                        item.setAlamat(obj.getString(TAG_ALAMAT));
                        item.setStatus(obj.getString(TAG_STATUS));
                        itemlist.add(item);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                adapter.notifyDataSetChanged();
                swipe.setRefreshing(false);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "Error:" + error.getMessage());
                swipe.setRefreshing(false);
            }
        });
        AppController.getInstance().addToRequestQueue(jArr);
    }
    private void simpan_update(){
        StringRequest strReq = new StringRequest(Request.Method.POST, url_update, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d(TAG, "Response:" + response.toString());

                try {
                    JSONObject jObj = new JSONObject(response);
                    success = jObj.getInt(TAG_SUCCESS);

                    if (success == 1) {
                        Log.d("Update", jObj.toString());
                        callVolley();
                        kosong();
                        Toast.makeText(BioActivity.this, jObj.getString(TAG_MESSAGE),
                                Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(BioActivity.this, jObj.getString(TAG_MESSAGE),
                                Toast.LENGTH_LONG).show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d(TAG, "Error:" +error.getMessage());
                Toast.makeText(BioActivity.this, error.getMessage(),
                        Toast.LENGTH_LONG).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams(){
                Map<String, String> params = new HashMap<String, String>();
                if (id_users.isEmpty()){
                    params.put("nama", nama);
                    params.put("alamat", alamat);
                    params.put("status", status);
                } else {
                    params.put("id_users", id_users);
                    params.put("nama", nama);
                    params.put("alamat", alamat);
                    params.put("status", status);
                }
                return params;
            }
        };
        AppController.getInstance().addToRequestQueue(strReq, tag_json_obj);
    }

    private void edit(final String id_usersx){
        StringRequest strReq = new StringRequest(Request.Method.POST, url_edit, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d(TAG, "Response:" + response.toString());

                try {
                    JSONObject jObj = new JSONObject(response);
                    success = jObj.getInt(TAG_SUCCESS);

                    if (success == 1) {
                        Log.d("get edit data", jObj.toString());
                        String id_usersx = jObj.getString(TAG_ID_USERS);
                        String namax = jObj.getString(TAG_NAMA);
                        String alamatx = jObj.getString(TAG_ALAMAT);
                        String statusx = jObj.getString(TAG_STATUS);

                        DialogForm(id_usersx, namax, alamatx, statusx, "UPDATE");

                        adapter.notifyDataSetChanged();
                    } else {
                        Toast.makeText(BioActivity.this, jObj.getString(TAG_MESSAGE), Toast.LENGTH_LONG).show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d(TAG, "Error" + error.getMessage());
                Toast.makeText(BioActivity.this, error.getMessage(), Toast.LENGTH_LONG).show();
            }
        }) {
            @Override
            protected Map<String,String> getParams(){
                Map<String,String> params = new HashMap<String, String>();
                params.put("id_users", id_usersx);
                return params;
            }
        };
        AppController.getInstance().addToRequestQueue(strReq, tag_json_obj);
    }
}