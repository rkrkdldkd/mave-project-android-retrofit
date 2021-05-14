package com.example.retrofit.api;

import android.util.Log;
import android.view.View;
import com.example.retrofit.dto.AnswerDto.AllAnswerRequest;
import com.example.retrofit.dto.AnswerDto.AllAnswerResponse;
import com.example.retrofit.dto.AnswerDto.RegistAnswerRequest;
import com.example.retrofit.dto.AnswerDto.RegistAnswerResponse;
import com.example.retrofit.service.AnswerRetrofitService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.List;

public class AllAnswerApi {

    static final String TAG = "Mave";


    public void onClick(View v) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.37.101:8080/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        AnswerRetrofitService answerRetrofitService = retrofit.create(AnswerRetrofitService.class);
        AllAnswerRequest request = new AllAnswerRequest(3l);
        Call<List<AllAnswerResponse>> call = answerRetrofitService.allAnswer(1l,request);

        call.enqueue(new Callback<List<AllAnswerResponse>>() {
            @Override
            public void onResponse(Call<List<AllAnswerResponse>> call, Response<List<AllAnswerResponse>> response) {
                if (response.isSuccessful()) {
                    List<AllAnswerResponse> body = response.body();
                    Log.d(TAG, "response 성공!!");
//                            textTest.setText(body.getUserId().toString());
                } else {
                    Log.d(TAG, "response 실패 ㅠㅠ");

                }
            }

            @Override
            public void onFailure(Call<List<AllAnswerResponse>> call, Throwable t) {
                Log.d(TAG, "onFailure => " + t.getMessage());
            }
        });


    }
}
