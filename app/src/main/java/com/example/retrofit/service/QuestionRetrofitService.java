package com.example.retrofit.service;

import com.example.retrofit.dto.questionDto.TakeQuestionRequest;
import com.example.retrofit.dto.questionDto.TakeQuestionResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface QuestionRetrofitService {

    @POST("api/question/{questionNumber}")
    Call<TakeQuestionResponse> takeQuestion(@Path("questionNumber") Long questionNumber,
                                            @Body TakeQuestionRequest request);
}
