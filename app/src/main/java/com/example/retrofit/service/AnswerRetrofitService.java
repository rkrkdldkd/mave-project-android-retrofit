package com.example.retrofit.service;

import com.example.retrofit.dto.AnswerDto.AllAnswerRequest;
import com.example.retrofit.dto.AnswerDto.AllAnswerResponse;
import com.example.retrofit.dto.AnswerDto.RegistAnswerRequest;
import com.example.retrofit.dto.AnswerDto.RegistAnswerResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Path;

import java.util.List;

public interface AnswerRetrofitService {

    @POST("api/answer/{questionNumber}")
    Call<RegistAnswerResponse> registAnswer(@Path("questionNumber") Long questionNumber,
                                            @Body RegistAnswerRequest request);

    @POST("api/allAnswer/{questionNumber}")
    Call<List<AllAnswerResponse>> allAnswer(@Path("questionNumber") Long questionNumber,
                                            @Body AllAnswerRequest request);
}
