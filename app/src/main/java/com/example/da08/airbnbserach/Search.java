package com.example.da08.airbnbserach;

/**
 * Created by Da08 on 2017. 7. 27..
 */

public class Search {
    public static final int TYPE_ONE    = 10;
    public static final int TYPE_TWO    = 20;
    public static final int TYPE_EXTIRE = 30;

    public static final String AM_WIFI        = "wifi";
    public static final String AM_REFRIGERATOR = "refrigerator";
    public static final String AM_PARKING     = "parking";
    public static final String AM_ELEVATOR    = "elevator";
    public static final String AM_HAIR        = "hair dryer";
    public static final String AM_BED         = "bed";

    public String checkInDate = null;
    public String checkOutDate = null;
    public int guests =1;
    public void setGuests(int count){
            if(count > 1) guests = count;
        }
    public int getGuests(){
        return guests;
    }
    public int type;
    public int price_min;
    public int price_max;
    public String amenities[];
}
