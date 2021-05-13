package com.example.retrofit.dto.groupDto;

import com.google.gson.annotations.SerializedName;

public class CreateGroupRequest {

    @SerializedName("userId")
    private Long userId;

    @SerializedName("groupName")
    private String groupName;

    public CreateGroupRequest() {
    }

    public CreateGroupRequest(Long userId, String groupName) {
        this.userId = userId;
        this.groupName = groupName;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
}
