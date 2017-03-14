package diogojayme.br.com.vuziq.mvparchitecture.view;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import diogojayme.br.com.vuziq.mvparchitecture.R;
import diogojayme.br.com.vuziq.mvparchitecture.domain.models.User;
import diogojayme.br.com.vuziq.mvparchitecture.presenter.AuthenticationPresenter;

/**
 * Created by diogojayme on 3/13/17.
 */


public class FragmentLogin extends Fragment implements LoginView {

    public interface LoginSuccessListener {
        void onLoginSuccess();
    }

    private LoginSuccessListener loginSuccessListener;

    @BindView(R.id.submit) Button submit;
    @BindView(R.id.username) EditText username;
    @BindView(R.id.password) EditText password;
    @BindView(R.id.login_loading) ProgressBar loading;

    AuthenticationPresenter authenticationPresenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        ButterKnife.bind(this, view);
        authenticationPresenter = new AuthenticationPresenter(this);
        return view;
    }

    @OnClick(R.id.submit) public void onLoginClick() {
        authenticationPresenter.login(username.getText().toString(), password.getText().toString());
    }

    @Override
    public void onAuthenticated(User user) {
        //Redirect the user to somewhere
        //Don't do anything here, like persistence or logical stuffs
        submit.setEnabled(false);
        submit.setText("logado");
        Toast.makeText(getActivity(), "Welcome" + user.getUsername(), Toast.LENGTH_SHORT).show();

        loginSuccessListener.onLoginSuccess();
    }

    @Override
    public void onAuthenticationFailed() {
        submit.setEnabled(true);
        submit.setText("Tente de novo");
        Toast.makeText(getActivity(), "Authentincation failed", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showLoginLoading() {
        submit.setText("Conectando");
        loading.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoginLoading() {
        loading.setVisibility(View.INVISIBLE);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            loginSuccessListener = (LoginSuccessListener) context;
        }catch (ClassCastException e){
            e.printStackTrace();
        }

    }
}
