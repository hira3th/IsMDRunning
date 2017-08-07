package com.example.mathias.ismdrunning;

import android.util.Log;

import com.example.mathias.ismdrunning.json_objects.show_request.Broadcast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;

import static com.example.mathias.ismdrunning.Home.getStationName;


/**
 * Created by Mathias on 14.07.2017.
 */

public class BroadcastsContainer extends ArrayList<Broadcast> {
    public BroadcastsContainer() {
    }

    public void sort(){
        Collections.sort(this, new Comparator<Broadcast>() {
            @Override
            public int compare(Broadcast b2, Broadcast b1)
            {
                return  b1.compareTo(b2);
            }
        });

        int startingIndex = size() >= 25 ? 25 : size();
        this.removeRange(startingIndex, this.size());
    }

    @Override
    public String toString(){
        String result = "";
        String date;

        for(Broadcast b : this){
            long timeStamp = (long) (b.getStartTime())*1000;
            date = new Date(timeStamp).toString().substring(0,19);
            result += String.format("%s, auf %s\n", date, getStationName(b.getStationID()));
        }

        return result;
    }

}
