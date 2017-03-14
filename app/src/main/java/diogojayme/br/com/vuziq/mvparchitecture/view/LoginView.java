package diogojayme.br.com.vuziq.mvparchitecture.view;

import diogojayme.br.com.vuziq.mvparchitecture.domain.models.User;

/**
 * Created by diogojayme on 3/9/17.
 */

public interface LoginView {
    void onAuthenticated(User user);
    void onAuthenticationFailed();
    void showLoginLoading();
    void hideLoginLoading();
}
