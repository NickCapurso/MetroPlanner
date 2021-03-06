package com.example.nickcapurso.mapsapplication.pathfinding;

import java.util.ArrayList;

/**
 * Represents a metro station (its name, longitude, latitude, code, lines, etc.)
 */
public class StationInfo {
    /**
     * The name of the station (ex. "Foggy Bottom")
     */
    public String name;

    /**
     * Longitude of the station
     */
    public double longitude;

    /**
     * Latitude of the station
     */
    public double latitude;

    /**
     * The station code of the station (from the Metro API)
     */
    public String code;

    /**
     * Alternative codes for the station (used when a station has multiple lines/platforms)
     */
    public String altCode1, altCode2;

    /**
     * The lines that pass through this station
     */
    public ArrayList<String> lines;

    public StationInfo(){
        lines = new ArrayList<String>();
        name = "";
        altCode1 = "";
        altCode2 = "";
    }

    public StationInfo(String name, double latitude, double longitude, String code){
        this.name = name;
        this.longitude = longitude;
        this.latitude = latitude;
        this.code = code;
        altCode1 = "";
        altCode2 = "";
        lines = new ArrayList<String>();
    }

    public StationInfo(String name, double latitude, double longitude, String code, String altCode1, String altCode2){
        this.name = name;
        this.longitude = longitude;
        this.latitude = latitude;
        this.code = code;
        this.altCode1 = altCode1;
        this.altCode2 = altCode2;
        lines = new ArrayList<String>();
    }

    /**
     * Two StationInfo objects are equal if they have the same station name.
     * @param object
     * @return
     */
    @Override
    public boolean equals(Object object){
        if(object instanceof StationInfo){
            StationInfo station2 = (StationInfo)object;
            //Log.d("StationInfo", "Comparing station " + name + " [" + code + "," + altCode1 + "," + altCode2 + "] " +
            //"to station " + station2.name + " [" + station2.code + "," + station2.altCode1 + "," + station2.altCode2 + "] ");
            return code.equals(station2.code) || code.equals(station2.altCode1) || code.equals(station2.altCode2);
        }
        return false;
    }

    /**
     * Hash code of a station is the hash of its name (no two stations have the same name)
     * @return
     */
    @Override
    public int hashCode(){
        return name.hashCode();
    }
}
