package com.example.retrofit.dto.memberDto;

import com.google.gson.annotations.SerializedName;


public class JoinMemberRequest {

    @SerializedName("userName")
    private String userName;

    public JoinMemberRequest() {
    }

    public JoinMemberRequest(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
