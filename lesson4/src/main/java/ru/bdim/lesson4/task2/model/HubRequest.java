package ru.bdim.lesson4.task2.model;

import com.google.gson.annotations.SerializedName;

public class HubRequest {
    @SerializedName("login")
    private String login;
    @SerializedName("avatar_url")
    private String avatarUri;

    public String getAvatarUri() {
        return avatarUri;
    }
}
