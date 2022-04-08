package com.testing.themovie;

public interface OnAPICallBack {
    void apiSuccess(String key, Object data);
    void apiError(String key, int code, Object data);
}
