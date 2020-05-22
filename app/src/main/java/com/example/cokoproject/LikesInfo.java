package com.example.cokoproject;

import com.google.firebase.database.Exclude;

import java.util.HashMap;
import java.util.Map;

public class LikesInfo {

    private String placePic;
    private String placeName;
    private String placeLocation;

    public LikesInfo(){}

    public String getPlacePic() {
        return placePic;
    }

    public void setPlacePic(String placePic) {
        this.placePic = placePic;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public String getPlaceLocation() {
        return placeLocation;
    }

    public void setPlaceLocation(String placeLocation) {
        this.placeLocation = placeLocation;
    }
}
