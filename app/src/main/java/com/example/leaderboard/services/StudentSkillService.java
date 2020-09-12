package com.example.leaderboard.services;

import com.example.leaderboard.model.StudentSkill;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface StudentSkillService {
    @GET("/api/skilliq")
    Call<List<StudentSkill>>getStudentSkillIQ();

//    //POST TO https://docs.google.com/forms/d/e/1FAIpQLSf9d1TcNU6zc6KR8bSEM41Z1g1zl35cwZr2xyjIhaMAz8WChQ/formResponse
//
//    Entries IDs:
//    Email Address = entry.1824927963
//    Name = entry.1877115667
//    Last Name = entry.2006916086
//    Link to project = entry.284483984

    @FormUrlEncoded
    @POST("1FAIpQLSf9d1TcNU6zc6KR8bSEM41Z1g1zl35cwZr2xyjIhaMAz8WChQ/formResponse")
    Call<ResponseBody>projectSubmission(@Field("entry.1824927963")String emailAddress,
                                        @Field("entry.1877115667")String firstName,
                                        @Field("entry.2006916086")String lastName,
                                        @Field("entry.284483984")String projectLink);



//    Call<Void>projectSubmission(@Field("entry.1824927963")emailAddress:,
//                            @Field("entry.1877115667")firstName:String,
//                            @Field("entry.2006916086")lastName:String,
//                            @Field("entry.284483984")projectLink:String);

}
