package com.testing.themovie.view.fragment;

import static com.testing.themovie.view.fragment.LoginFragment.KEY_SESSION_ID;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.testing.themovie.CommonUtils;
import com.testing.themovie.databinding.FragmentSplashBinding;
import com.testing.themovie.viewmodel.CommonViewModel;

public class SplashFragment extends BaseFragment<FragmentSplashBinding, CommonViewModel> {

    public static final String TAG = SplashFragment.class.getName();

    @Override
    protected void initViews() {

        String sessionId = CommonUtils.getInstance().getPref(KEY_SESSION_ID);
        if (sessionId == null) {

        }
        new Handler().postDelayed(() -> {
            String sessionId1 = CommonUtils.getInstance().getPref(KEY_SESSION_ID);
            if (sessionId1 == null) {
                callBack.showFragment(LoginFragment.TAG, null, false);
            } else {
                callBack.showFragment(HomeFragment.TAG, null, false);
            }

        }, 2000);
    }

    @Override
    protected Class<CommonViewModel> getClassVM() {
        return CommonViewModel.class;
    }

    @Override
    protected FragmentSplashBinding initViewBinding(@NonNull LayoutInflater inflater, @Nullable ViewGroup container) {
        return FragmentSplashBinding.inflate(inflater, container, false);
    }

}
