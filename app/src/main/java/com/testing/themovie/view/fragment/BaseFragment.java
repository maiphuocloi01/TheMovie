package com.testing.themovie.view.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewbinding.ViewBinding;

import com.testing.themovie.OnAPICallBack;
import com.testing.themovie.OnMainCallBack;
import com.testing.themovie.viewmodel.BaseViewModel;

public abstract class BaseFragment<B extends ViewBinding, V extends BaseViewModel> extends Fragment
        implements View.OnClickListener, OnAPICallBack {
    protected B binding;
    protected V viewModel;
    public static final String TAG = BaseFragment.class.getName();
    protected Context context;
    protected OnMainCallBack callBack;
    protected Object mData;

    @Override
    public final void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Nullable
    @Override
    public final View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = initViewBinding(inflater, container);
        viewModel = new ViewModelProvider(this).get(getClassVM());
        viewModel.setCallBack(this);
        initViews();
        return binding.getRoot();
    }

    @Override
    public final void onClick(View view) {
        view.startAnimation(AnimationUtils.loadAnimation(context, androidx.appcompat.R.anim.abc_fade_in));
        clickView(view);
    }

    protected void clickView(View view){

    }

    public final void setCallBack(OnMainCallBack callBack) {
        this.callBack = callBack;
    }

    public void setData(Object mData) {
        this.mData = mData;
    }

    protected abstract void initViews();

    protected abstract Class<V> getClassVM();

    protected abstract B initViewBinding(@NonNull LayoutInflater inflater, @Nullable ViewGroup container);

    @Override
    public void apiSuccess(String key, Object data) {

    }

    @Override
    public void apiError(String key, int code, Object data) {
        if(code == 401){
            callBack.showFragment(LoginFragment.TAG, null, false);
            Toast.makeText(context, "Phiên đăng nhập hết hạn", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Error: " + code + ", " + data, Toast.LENGTH_SHORT).show();
        }
    }
}
