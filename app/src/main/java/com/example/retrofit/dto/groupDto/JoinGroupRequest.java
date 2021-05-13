package com.example.retrofit.dto.groupDto;

import com.google.gson.annotations.SerializedName;

public class JoinGroupRequest {

    @SerializedName("userId")
    private Long userId;

    public JoinGroupRequest() {
    }

    public JoinGroupRequest(Long userId) {
        this.userId = userId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
