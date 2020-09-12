package com.example.leaderboard.model;

import com.google.gson.annotations.SerializedName;

public class StudentHour {
    //{"name":"Kojo Yeboah",
    // "hours":92,
    // "country":"Ghana",
    // "badgeUrl":"https://res.cloudinary.com/mikeattara/image/upload/v1596700848/Top-learner.png"}
    @SerializedName("name")
    public String name;
    @SerializedName("hours")
    public String hours;
    @SerializedName("country")
    public String country;
    @SerializedName("badgeUrl")
    public String badgeUrl;

    public StudentHour(String name, String hours, String country, String badgeUrl) {
        this.name = name;
        this.hours = hours;
        this.country = country;
        this.badgeUrl = badgeUrl;
    }

}
