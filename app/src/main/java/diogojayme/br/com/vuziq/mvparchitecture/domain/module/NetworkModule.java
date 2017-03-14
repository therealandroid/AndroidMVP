package diogojayme.br.com.vuziq.mvparchitecture.domain.module;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import diogojayme.br.com.vuziq.mvparchitecture.application.Config;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by diogojayme on 3/13/17.
 *
 * Important: adding RxJavaCallAdapterFactory to support version 2 of Retrofit to use Observable instead Call
 * Use https://github.com/square/retrofit/tree/master/retrofit-adapters/rxjava2
 */

@Module
public class NetworkModule {


    @Provides
    @Singleton
    public Retrofit provideRetrofit(){

        return new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(Config.BASE_URL).build();
    }

}
