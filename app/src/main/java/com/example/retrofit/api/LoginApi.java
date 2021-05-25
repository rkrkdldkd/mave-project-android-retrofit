package com.example.retrofit.api;

import android.util.Log;
import android.view.View;
import com.example.retrofit.CreateRetrofit;
import com.example.retrofit.dto.memberDto.JoinMemberRequest;
import com.example.retrofit.dto.memberDto.JoinMemberResponse;
import com.example.retrofit.dto.memberDto.LoginRequest;
import com.example.retrofit.dto.memberDto.LoginResponse;
import com.example.retrofit.service.MemberRetrofitService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginApi {
    static final String TAG = "Mave";


    public void onClick(View v) {

        MemberRetrofitService memberRetrofitService = CreateRetrofit.createRetrofit().create(MemberRetrofitService.class);
        LoginRequest request = new LoginRequest("userId", "password");
        Call<LoginResponse> call = memberRetrofitService.login(request);

        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if (response.isSuccessful()) {
                    LoginResponse body = response.body();
                    Log.d(TAG, "response 성공!!");
//                            textTest.setText(body.getUserId().toString());
                } else {
                    Log.d(TAG, "response 실패 ㅠㅠ");

                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                Log.d(TAG, "onFailure => " + t.getMessage());
            }
        });


    }
}