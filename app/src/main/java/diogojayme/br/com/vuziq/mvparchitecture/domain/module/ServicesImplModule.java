package diogojayme.br.com.vuziq.mvparchitecture.domain.module;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import diogojayme.br.com.vuziq.mvparchitecture.domain.services.AuthenticationNetworkService;

/**
 * Created by diogojayme on 3/13/17.
 */

@Module
public class ServicesImplModule {

    @Provides
    @Singleton
    public AuthenticationService provideLoginServiceImpl(AuthenticationNetworkService authenticationNetworkService){
        return new AuthenticationService(authenticationNetworkService);
    }
}
