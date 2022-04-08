package com.testing.themovie.api;

import com.testing.themovie.api.req.AccountReq;
import com.testing.themovie.api.req.RequestToken;
import com.testing.themovie.api.res.AuthenRes;
import com.testing.themovie.api.res.SessionRes;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface API {

    String API_KEY = "5941024e8620246ad84260d2dfdac7ce";

    @GET("authentication/token/new?api_key=" + API_KEY)
    @Headers("Content-type: application/json")
    Call<AuthenRes> getAuthen();

    @POST("authentication/token/validate_with_login?api_key=" + API_KEY)
    @Headers("Content-type: application/json")
    Call<AuthenRes> createSession(@Body AccountReq acc);

    @POST("authentication/session/new?api_key=" + API_KEY)
    @Headers("Content-type: application/json")
    Call<SessionRes> createSessionId(@Body RequestToken requestToken);
}
