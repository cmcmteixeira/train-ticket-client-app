package com.railway.railway.business.api.entity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Leonel on 24/10/2015.
 */
public class Connection {
    private String departureStation;
    private String arrivalStation;
    private int length;
    private ArrayList<String> schedule;

    public Connection(JSONObject con) throws JSONException {
        this.departureStation = con.get("dStation").toString();
        this.arrivalStation = con.get("aStation").toString();
        this.length = (int) con.get("length");

        JSONArray scheduleInfo = con.getJSONArray("schedule");
        if (scheduleInfo != null) {
            for (int i=0;i<scheduleInfo.length();i++){
                this.schedule.add(scheduleInfo.get(i).toString());
            }
        }

    }

    public String getDepartureStation() {
        return this.departureStation;
    }

    public String getArrivalStation() {
        return this.arrivalStation;
    }

    public int getLength() {
        return this.length;
    }

    public ArrayList<String> getSchedule() {
        return this.schedule;
    }

}
