package diogojayme.br.com.vuziq.mvparchitecture.domain.module;

import java.util.Map;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import diogojayme.br.com.vuziq.mvparchitecture.domain.mapper.Mapper;
import diogojayme.br.com.vuziq.mvparchitecture.domain.respository.UserRepository;

/**
 * Created by diogojayme on 3/15/17.
 */

@Module
public class RepositoryModule {

    @Singleton
    @Provides
    public UserRepository provideUserRepository(Mapper mapper){
        return new UserRepository(mapper);
    }
}
