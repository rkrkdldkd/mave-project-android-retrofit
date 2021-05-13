package com.example.retrofit.dto.AnswerDto;

import com.google.gson.annotations.SerializedName;

public class RegistAnswerRequest {

    @SerializedName("userId")
    private Long userId;

    @SerializedName("groupId")
    private Long groupId;

    @SerializedName("answer")
    private String answer;

    public RegistAnswerRequest() {
    }

    public RegistAnswerRequest(Long userId, Long groupId, String answer) {
        this.userId = userId;
        this.groupId = groupId;
        this.answer = answer;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
