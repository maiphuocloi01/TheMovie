package com.testing.themovie.api.req;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class AccountReq implements Serializable {
    @SerializedName("username")
    public String username;
    @SerializedName("password")
    public String password;
    @SerializedName("request_token")
    public String requestToken;

    public AccountReq(String username, String password, String requestToken) {
        this.username = username;
        this.password = password;
        this.requestToken = requestToken;
    }
}
