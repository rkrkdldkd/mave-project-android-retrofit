package com.example.retrofit.api;

import android.util.Log;
import android.view.View;
import com.example.retrofit.dto.groupDto.CreateGroupRequest;
import com.example.retrofit.dto.groupDto.CreateGroupResponse;
import com.example.retrofit.dto.questionDto.TakeQuestionRequest;
import com.example.retrofit.dto.questionDto.TakeQuestionResponse;
import com.example.retrofit.service.GroupRetrofitService;
import com.example.retrofit.service.QuestionRetrofitService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class TakeQuestionApi {

    static final String TAG = "Mave";


    public void onClick(View v) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.37.101:8080/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        QuestionRetrofitService questionRetrofitService = retrofit.create(QuestionRetrofitService.class);
        TakeQuestionRequest request = new TakeQuestionRequest(3l);
        Call<TakeQuestionResponse> call = questionRetrofitService.takeQuestion(1l,request);

        call.enqueue(new Callback<TakeQuestionResponse>() {
            @Override
            public void onResponse(Call<TakeQuestionResponse> call, Response<TakeQuestionResponse> response) {
                if (response.isSuccessful()) {
                    TakeQuestionResponse body = response.body();
                    Log.d(TAG, "response 성공!!");
//                            textTest.setText(body.getUserId().toString());
                } else {
                    Log.d(TAG, "response 실패 ㅠㅠ");

                }
            }

            @Override
            public void onFailure(Call<TakeQuestionResponse> call, Throwable t) {
                Log.d(TAG, "onFailure => " + t.getMessage());
            }
        });


    }
}
