package com.testing.themovie.view.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.testing.themovie.OnMainCallBack;
import com.testing.themovie.R;
import com.testing.themovie.view.fragment.BaseFragment;
import com.testing.themovie.view.fragment.SplashFragment;

import java.lang.reflect.Constructor;

public class MainActivity extends AppCompatActivity implements OnMainCallBack {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        SplashFragment frg = new SplashFragment();
        frg.setCallBack(this);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.ln_main, frg, SplashFragment.class.getName())
                .commit();
    }

    @Override
    public void showFragment(String tag, Object data, boolean isBack) {
        try {
            Class<?> clazz = Class.forName(tag);
            Constructor<?> cons = clazz.getConstructor();
            BaseFragment<?,?> frg = (BaseFragment<?, ?>) cons.newInstance();
            frg.setData(data);
            frg.setCallBack(this);
            FragmentTransaction trans = getSupportFragmentManager()
                    .beginTransaction();
            if(isBack){
                trans.addToBackStack(null);
            }
            trans.replace(R.id.ln_main, frg, tag).commit();
        } catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public void backToPrev() {
        onBackPressed();
    }
}