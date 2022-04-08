package com.testing.themovie.viewmodel;

import android.util.Log;

import com.testing.themovie.api.req.AccountReq;
import com.testing.themovie.api.req.RequestToken;
import com.testing.themovie.api.res.AuthenRes;

public class LoginViewModel extends BaseViewModel {
    public static final String TAG = LoginViewModel.class.getName();
    private static final String KEY_API_AUTHEN = "KEY_API_AUTHEN";
    private static final String KEY_API_CREATE_SESSION = "KEY_API_CREATE_SESSION";
    public static final String KEY_API_CREATE_SESSION_ID = "KEY_API_CREATE_SESSION_ID";
    private String username, password;

    public void getAuthen(String username, String password) {
        this.username = username;
        this.password = password;
        getAPI().getAuthen().enqueue(initHandleResponse(KEY_API_AUTHEN));
    }

    private void createSession(String requestToken) {
        getAPI().createSession(new AccountReq(username, password, requestToken))
                .enqueue(initHandleResponse(KEY_API_CREATE_SESSION));
    }

    private void createSessionId(String requestToken) {
        getAPI().createSessionId(new RequestToken(requestToken))
                .enqueue(initHandleResponse(KEY_API_CREATE_SESSION_ID));
    }

    @Override
    protected void handleSuccess(String key, Object body) {
        Log.i(TAG, "handleSuccess: " + key);
        Log.i(TAG, "handleSuccess: " + body);
        switch (key) {
            case KEY_API_AUTHEN:
                createSession(((AuthenRes) body).requestToken);
                break;
            case KEY_API_CREATE_SESSION:
                createSessionId(((AuthenRes) body).requestToken);
                break;
            case KEY_API_CREATE_SESSION_ID:
                callBack.apiSuccess(key, body);
                break;
        }
    }

}
