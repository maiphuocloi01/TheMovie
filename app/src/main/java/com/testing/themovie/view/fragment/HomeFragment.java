package com.testing.themovie.view.fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.testing.themovie.databinding.FragmentHomeBinding;
import com.testing.themovie.viewmodel.CommonViewModel;

public class HomeFragment extends BaseFragment<FragmentHomeBinding, CommonViewModel>{

    public static final String TAG = HomeFragment.class.getName();

    @Override
    protected void initViews() {
    }


    @Override
    protected Class<CommonViewModel> getClassVM() {
        return CommonViewModel.class;
    }

    @Override
    protected FragmentHomeBinding initViewBinding(@NonNull LayoutInflater inflater, @Nullable ViewGroup container) {
        return FragmentHomeBinding.inflate(inflater, container, false);
    }

}
