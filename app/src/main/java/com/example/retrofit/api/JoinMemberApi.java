package com.example.retrofit.api;

import android.util.Log;
import android.view.View;
import com.example.retrofit.dto.memberDto.JoinMemberRequest;
import com.example.retrofit.dto.memberDto.JoinMemberResponse;
import com.example.retrofit.service.MemberRetrofitService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class JoinMemberApi {
    static final String TAG = "Mave";


    public void onClick(View v) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.37.101:8080/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        MemberRetrofitService memberJoinService = retrofit.create(MemberRetrofitService.class);
        JoinMemberRequest member = new JoinMemberRequest("첫 번째 유저");
        Call<JoinMemberResponse> call = memberJoinService.joinMember(member);

        call.enqueue(new Callback<JoinMemberResponse>() {
            @Override
            public void onResponse(Call<JoinMemberResponse> call, Response<JoinMemberResponse> response) {
                if (response.isSuccessful()) {
                    JoinMemberResponse body = response.body();
                    Log.d(TAG,"response 성공!!");
//                            textTest.setText(body.getUserId().toString());
                }else{
                    Log.d(TAG,"response 실패 ㅠㅠ");

                }
            }

            @Override
            public void onFailure(Call<JoinMemberResponse> call, Throwable t) {
                    Log.d(TAG,"onFailure => " + t.getMessage());
            }
        });


    }
}