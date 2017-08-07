package com.example.mathias.ismdrunning;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by Mathias on 14.07.2017.
 */

public class MySingleton {

    private static MySingleton mySingleton;
    private RequestQueue requestQueue;
    private static Context mctx;

    private MySingleton(Context context) {
        this.mctx = context;
        this.requestQueue = getRequestQueue();

    }

    public RequestQueue getRequestQueue() {
        if (requestQueue == null) {
            requestQueue = Volley.newRequestQueue(mctx.getApplicationContext());
        }
        return requestQueue;
    }

    public static synchronized MySingleton getInstance(Context context) {
        if (mySingleton == null) {
            mySingleton = new MySingleton(context);
        }
        return mySingleton;
    }

    public <T> void addToRequestQueue(Request<T> request) {
        Log.d("test", "Adding Request To RequestQueue...");
        requestQueue.add(request);
        Log.d("test", "Done!");
    }
}

