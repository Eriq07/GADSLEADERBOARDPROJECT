package com.example.leaderboard.model;

import com.google.gson.annotations.SerializedName;

public class StudentSkill {
    //{"name":"Perry Oluwatobi",
    // "score":187,
    // "country":"Nigeria",
    // "badgeUrl":"https://res.cloudinary.com/mikeattara/image/upload/v1596700835/skill-IQ-trimmed.png"}
//
//    {
//        "id":"9",
//            "image":"http://velmm.com/images/bottom_navigationview/borg_mcenroe.jpg",
//            "title":"Borg McEnroe"
//    },
//    {
//        "id":"10",
//            "image":"http://velmm.com/images/bottom_navigationview/wonder.jpg",
//            "title":"Wonder"
//    }

    //SAMPLE DATA
    // class Movie {
    //
    //    @SerializedName("title")
    //    private String title;
    //
    //    @SerializedName("image")
    //    private String imageUrl;
    //
    //    public Movie(String title, String imageUrl) {
    //        this.title = title;
    //        this.imageUrl = imageUrl;
    //    }
    //
    //    public String getTitle() {
    //        return title;
    //    }
    //
    //    public void setTitle(String title) {
    //        this.title = title;
    //    }
    //
    //    public String getImageUrl() {
    //        return imageUrl;
    //    }
    //
    //    public void setImageUrl(String imageUrl) {
    //        this.imageUrl = imageUrl;
    //    }
    //}
    @SerializedName("name")
    public String name;
    @SerializedName("score")
    public String score;
    @SerializedName("country")
    public String country;
    @SerializedName("badgeUrl")
    public String badgeUrl;

    public StudentSkill(String name, String score, String country, String badgeUrl) {
        this.name = name;
        this.score = score;
        this.country = country;
        this.badgeUrl = badgeUrl;
    }


}
