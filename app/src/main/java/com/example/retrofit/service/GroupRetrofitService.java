package com.example.retrofit.service;


import com.example.retrofit.dto.groupDto.CreateGroupRequest;
import com.example.retrofit.dto.groupDto.CreateGroupResponse;
import com.example.retrofit.dto.groupDto.JoinGroupRequest;
import com.example.retrofit.dto.groupDto.JoinGroupResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface GroupRetrofitService {

    @POST("api/groups")
    Call<CreateGroupResponse> createGroup(@Body CreateGroupRequest request);

    @POST("api/groups/{groupId}")
    Call<JoinGroupResponse> joinGroup(@Path("groupId") Long id,
                                      @Body JoinGroupRequest request);
}
