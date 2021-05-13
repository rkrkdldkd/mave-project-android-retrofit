package com.example.retrofit.service;

import com.example.retrofit.dto.memberDto.JoinMemberRequest;
import com.example.retrofit.dto.memberDto.JoinMemberResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface MemberRetrofitService {


    @POST("api/members")
    Call<JoinMemberResponse> joinMember(@Body JoinMemberRequest request);

}
