package com.testing.themovie.api.req;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class RequestToken implements Serializable {

    @SerializedName("request_token")
    public String requestToken;

    public RequestToken(String requestToken) {
        this.requestToken = requestToken;
    }
}
