package com.example.retrofit.service;

import com.example.retrofit.dto.memberDto.JoinMemberRequest;
import com.example.retrofit.dto.memberDto.JoinMemberResponse;
import com.example.retrofit.dto.memberDto.LoginRequest;
import com.example.retrofit.dto.memberDto.LoginResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface MemberRetrofitService {


    @POST("api/members")
    Call<JoinMemberResponse> joinMember(@Body JoinMemberRequest request);

    @GET("api/members/login")
    Call<LoginResponse>login(@Body LoginRequest request);
}
