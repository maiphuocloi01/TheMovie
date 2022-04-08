package com.testing.themovie.view.fragment;

import static com.testing.themovie.viewmodel.LoginViewModel.KEY_API_CREATE_SESSION_ID;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.testing.themovie.CommonUtils;
import com.testing.themovie.api.res.SessionRes;
import com.testing.themovie.databinding.FragmentLoginBinding;
import com.testing.themovie.viewmodel.LoginViewModel;

public class LoginFragment extends BaseFragment<FragmentLoginBinding, LoginViewModel> {
    public static final String TAG = LoginFragment.class.getName();
    public static final String KEY_SESSION_ID = "KEY_SESSION_ID";

    @Override
    protected void initViews() {
        binding.btLogin.setOnClickListener(view -> viewModel.getAuthen(
                binding.etUsername.getText().toString(),
                binding.etPassword.getText().toString()));
    }

    @Override
    protected Class<LoginViewModel> getClassVM() {
        return LoginViewModel.class;
    }

    @Override
    protected FragmentLoginBinding initViewBinding(@NonNull LayoutInflater inflater, @Nullable ViewGroup container) {
        return FragmentLoginBinding.inflate(inflater, container, false);
    }

    @Override
    public void apiError(String key, int code, Object data) {
        if (code == 401) {
            Toast.makeText(context, "Tài khoản hoặc mật khẩu không đúng!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Error: " + code + ", " + data, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void apiSuccess(String key, Object data) {
        if (key.equals(KEY_API_CREATE_SESSION_ID)) {
            SessionRes session = (SessionRes) data;
            CommonUtils.getInstance().savePref(KEY_SESSION_ID, session.sessionId);
            Toast.makeText(context, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
        }
    }
}
