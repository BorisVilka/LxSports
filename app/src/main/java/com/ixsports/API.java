package com.ixsports;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface API {

    @GET("/api/en/get.php")
    Call<Answer> getAns(@Query("login") String login, @Query("token") String token, @Query("task") String task, @Query("sport") String sport);

    @GET("/api/en/get.php")
    Call<TeamList> getTeam(@Query("login") String login, @Query("token") String token, @Query("task") String task, @Query("team") String sport);


    @GET("/api/team_img/sport_name/team_id.png")
    Call<Object> getUrl();
}
