package diogojayme.br.com.vuziq.mvparchitecture.presenter;

import javax.inject.Inject;

import diogojayme.br.com.vuziq.mvparchitecture.application.AndroidApplication;
import diogojayme.br.com.vuziq.mvparchitecture.domain.models.User;
import diogojayme.br.com.vuziq.mvparchitecture.domain.services.AuthenticationNetworkService;
import diogojayme.br.com.vuziq.mvparchitecture.view.LoginView;

/**
 * Created by diogojayme on 3/9/17.
 */

public class AuthenticationPresenter {

    private LoginView loginView;

    @Inject AuthenticationNetworkService authenticationService;

    public AuthenticationPresenter(LoginView loginView){
        AndroidApplication.Api().inject(this);
        this.loginView = loginView;
    }

    public void login(final String username, final String password) {
        loginView.showLoginLoading();

        RxRequest<User> rxRequest = new RxRequest<User>() {
            @Override
            public void onSuccess(User user) {
                loginView.onAuthenticated(user);
            }

            @Override
            public void onError(String message) {
                loginView.onAuthenticationFailed();
            }

            @Override
            public void onComplete() {
                loginView.hideLoginLoading();
            }
        };

        rxRequest.responseOnMainThread(authenticationService.login(username, password));
    }
}

