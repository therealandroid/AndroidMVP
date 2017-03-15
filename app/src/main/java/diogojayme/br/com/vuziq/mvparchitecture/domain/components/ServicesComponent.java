package diogojayme.br.com.vuziq.mvparchitecture.domain.components;

import javax.inject.Singleton;

import dagger.Component;
import diogojayme.br.com.vuziq.mvparchitecture.domain.module.NetworkModule;
import diogojayme.br.com.vuziq.mvparchitecture.domain.module.ServicesModule;
import diogojayme.br.com.vuziq.mvparchitecture.presenter.AuthenticationPresenter;

/**
 * Created by diogojayme on 3/13/17.
 */

@Singleton
@Component(modules = { NetworkModule.class, ServicesModule.class })
public interface ServicesComponent {
    void inject(AuthenticationPresenter presenter);
}
