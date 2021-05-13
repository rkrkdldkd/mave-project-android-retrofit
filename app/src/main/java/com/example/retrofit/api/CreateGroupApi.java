package com.example.retrofit.api;

import android.util.Log;
import android.view.View;
import com.example.retrofit.dto.groupDto.CreateGroupRequest;
import com.example.retrofit.dto.groupDto.CreateGroupResponse;
import com.example.retrofit.dto.memberDto.JoinMemberResponse;
import com.example.retrofit.service.GroupRetrofitService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CreateGroupApi {

    static final String TAG = "Mave";


    public void onClick(View v) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.37.101:8080/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        GroupRetrofitService groupRetrofitService = retrofit.create(GroupRetrofitService.class);
        CreateGroupRequest request = new CreateGroupRequest(1l, "첫 번째 그룹");
        Call<CreateGroupResponse> call = groupRetrofitService.createGroup(request);

        call.enqueue(new Callback<CreateGroupResponse>() {
            @Override
            public void onResponse(Call<CreateGroupResponse> call, Response<CreateGroupResponse> response) {
                if (response.isSuccessful()) {
                    CreateGroupResponse body = response.body();
                    Log.d(TAG, "response 성공!!");
//                            textTest.setText(body.getUserId().toString());
                } else {
                    Log.d(TAG, "response 실패 ㅠㅠ");

                }
            }

            @Override
            public void onFailure(Call<CreateGroupResponse> call, Throwable t) {
                Log.d(TAG, "onFailure => " + t.getMessage());
            }
        });


    }
}
