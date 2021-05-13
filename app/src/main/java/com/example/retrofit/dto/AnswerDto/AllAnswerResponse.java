package com.example.retrofit.dto.AnswerDto;

import com.google.gson.annotations.SerializedName;

public class AllAnswerResponse {

    @SerializedName("userId")
    private Long userId;

    @SerializedName("answerContent")
    private String answerContent;

    public AllAnswerResponse() {
    }

    public AllAnswerResponse(Long userId, String answerContent) {
        this.userId = userId;
        this.answerContent = answerContent;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getAnswerContent() {
        return answerContent;
    }

    public void setAnswerContent(String answerContent) {
        this.answerContent = answerContent;
    }
}
