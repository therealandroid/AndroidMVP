package diogojayme.br.com.vuziq.mvparchitecture.domain.components;

import javax.inject.Singleton;

import dagger.Component;
import diogojayme.br.com.vuziq.mvparchitecture.domain.module.ApplicationModule;
import diogojayme.br.com.vuziq.mvparchitecture.domain.module.RepositoryModule;
import diogojayme.br.com.vuziq.mvparchitecture.domain.respository.UserRepository;

/**
 * Created by diogojayme on 3/15/17.
 */

@Singleton
@Component(modules = { ApplicationModule.class, RepositoryModule.class })
public interface RepositoryComponent {
    void inject(UserRepository repository);
}
