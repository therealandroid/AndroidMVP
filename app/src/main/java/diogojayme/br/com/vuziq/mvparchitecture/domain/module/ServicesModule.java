package diogojayme.br.com.vuziq.mvparchitecture.domain.module;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import diogojayme.br.com.vuziq.mvparchitecture.domain.services.ImagesNetworkService;
import diogojayme.br.com.vuziq.mvparchitecture.domain.services.AuthenticationNetworkService;
import retrofit2.Retrofit;

/**
 * Created by diogojayme on 3/13/17.
 */

@Module
public class ServicesModule {

    @Provides
    @Singleton
    public AuthenticationNetworkService provideLoginService(Retrofit retrofit) {
        return retrofit.create(AuthenticationNetworkService.class);
    }

    @Provides
    @Singleton
    public ImagesNetworkService provideImagesService(Retrofit retrofit) {
        return retrofit.create(ImagesNetworkService.class);
    }
}
