package diogojayme.br.com.vuziq.mvparchitecture.domain.components;

import javax.inject.Singleton;

import dagger.Component;
import diogojayme.br.com.vuziq.mvparchitecture.domain.module.ApplicationModule;
import diogojayme.br.com.vuziq.mvparchitecture.domain.module.NetworkModule;
import diogojayme.br.com.vuziq.mvparchitecture.domain.module.RepositoryModule;
import diogojayme.br.com.vuziq.mvparchitecture.domain.module.ServicesModule;
import diogojayme.br.com.vuziq.mvparchitecture.domain.respository.UserRepository;
import diogojayme.br.com.vuziq.mvparchitecture.presenter.AuthenticationPresenter;

/**
 * Created by diogojayme on 3/13/17.
 */

@Singleton
@Component(modules = {ApplicationModule.class, NetworkModule.class, ServicesModule.class, RepositoryModule.class})
public interface ApplicationComponent {
    void inject(AuthenticationPresenter presenter);
    void inject(UserRepository repository);
}
