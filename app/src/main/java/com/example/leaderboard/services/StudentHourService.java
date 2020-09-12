package com.example.leaderboard.services;

import com.example.leaderboard.model.StudentHour;
import com.example.leaderboard.model.StudentSkill;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface StudentHourService {
    @GET("/api/hours")
    Call<List<StudentHour>> getStudentHours();
}
