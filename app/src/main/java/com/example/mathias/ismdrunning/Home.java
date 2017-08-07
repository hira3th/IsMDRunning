package com.example.mathias.ismdrunning;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.mathias.ismdrunning.json_objects.show_request.Broadcast;
import com.example.mathias.ismdrunning.json_objects.show_request.TVStation;
import com.example.mathias.ismdrunning.json_objects.stationnames_request.Channel;
import com.example.mathias.ismdrunning.json_objects.stationnames_request.Overview;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Mathias on 14.07.2017.
 */

public class Home extends Activity {
    BroadcastsContainer broadcastContainer;
    static HashMap<Integer, String> stationNames = new HashMap<>();
    TextView txtDisplay;
    LinearLayout container;
    String md_get_url = "Kindly ask hoerzu.de for API.";
    String stations_get_url = "Kindly ask hoerzu.de for API.";
    String json;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        txtDisplay = (TextView) findViewById(R.id.txt_vTVProgram);
        container = (LinearLayout) findViewById(R.id.text_container);

        container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtDisplay.setText("");
                updateList();
            }
        });
        Log.d("test", "View Created!");
        txtDisplay.setText("Kurz warten...\n");
        getStationNames();
    }

    private void updateList() {
        broadcastContainer = new BroadcastsContainer();

        JsonArrayRequest jsObjRequest = new JsonArrayRequest
                (Request.Method.GET, md_get_url, null, new Response.Listener<JSONArray>() {

                    @Override
                    public void onResponse(JSONArray response) {
                        Log.d("test", "RESPONSE");
                        Log.d("test", response.toString());
                        json = response.toString();

                        Gson gson = new Gson();
                        Type collectionType = new TypeToken<List<TVStation>>() {
                        }.getType();
                        List<TVStation> tvStations = gson.fromJson(json, collectionType);

                        for (TVStation station : tvStations) {
                            int i = 0;
                            int broadcastCounter = 0;
                            while (i < 19) {
                                if (station.getBroadcasts().size() <= broadcastCounter)
                                    break;
                                Broadcast broadcast = station.getBroadcasts().get(broadcastCounter);
                                if (!broadcast.getTitle().contains("Medical")) {
                                    broadcastCounter++;
                                    continue;
                                }

                                broadcast.setStationID(station.getId());
                                broadcastContainer.add(broadcast);
                                broadcastCounter++;
                                i++;
                            }
                        }

                        tvStations.clear();
                        broadcastContainer.sort();
                        txtDisplay.setText(broadcastContainer.toString());
                        broadcastContainer = null;
                        json = null;
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("test", error.toString());
                    }
                });

        MySingleton.getInstance(this).addToRequestQueue(jsObjRequest);
    }

    private void getStationNames() {
        JsonObjectRequest jsObjRequest = new JsonObjectRequest
                (Request.Method.GET, stations_get_url, null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        txtDisplay.append("Einen Moment noch...\n");
                        json = response.toString();

                        Gson gson = new Gson();
                        Type objectType = new TypeToken<Overview>() {
                        }.getType();
                        Overview overview = gson.fromJson(json, objectType);

                        for(Channel channel : overview.getChannels()){
                            stationNames.put(channel.getId(), channel.getName());
                        }

                        overview = null;

                        updateList();
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("test", error.toString());
                    }
                });

        MySingleton.getInstance(this).addToRequestQueue(jsObjRequest);
    }

    public static String getStationName(int stationID){
        return stationNames.get(stationID);
    }
}
