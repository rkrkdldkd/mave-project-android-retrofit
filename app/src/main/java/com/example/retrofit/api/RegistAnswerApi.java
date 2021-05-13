package com.example.retrofit.api;

import android.util.Log;
import android.view.View;
import com.example.retrofit.dto.AnswerDto.RegistAnswerRequest;
import com.example.retrofit.dto.AnswerDto.RegistAnswerResponse;
import com.example.retrofit.dto.groupDto.CreateGroupRequest;
import com.example.retrofit.dto.groupDto.CreateGroupResponse;
import com.example.retrofit.service.AnswerRetrofitService;
import com.example.retrofit.service.GroupRetrofitService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RegistAnswerApi {

    static final String TAG = "Mave";


    public void onClick(View v) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.37.101:8080/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        AnswerRetrofitService answerRetrofitService = retrofit.create(AnswerRetrofitService.class);
        RegistAnswerRequest request = new RegistAnswerRequest(2l, 3l, "답변했다!");
        Call<RegistAnswerResponse> call = answerRetrofitService.registAnswer(1l,request);

        call.enqueue(new Callback<RegistAnswerResponse>() {
            @Override
            public void onResponse(Call<RegistAnswerResponse> call, Response<RegistAnswerResponse> response) {
                if (response.isSuccessful()) {
                    RegistAnswerResponse body = response.body();
                    Log.d(TAG, "response 성공!!");
//                            textTest.setText(body.getUserId().toString());
                } else {
                    Log.d(TAG, "response 실패 ㅠㅠ");

                }
            }

            @Override
            public void onFailure(Call<RegistAnswerResponse> call, Throwable t) {
                Log.d(TAG, "onFailure => " + t.getMessage());
            }
        });


    }
}
