package diogojayme.br.com.vuziq.mvparchitecture.application;

import android.app.Application;

import diogojayme.br.com.vuziq.mvparchitecture.domain.components.ApplicationComponent;
import diogojayme.br.com.vuziq.mvparchitecture.domain.components.DaggerApplicationComponent;
import diogojayme.br.com.vuziq.mvparchitecture.domain.module.ApplicationModule;
import diogojayme.br.com.vuziq.mvparchitecture.domain.module.NetworkModule;
import diogojayme.br.com.vuziq.mvparchitecture.domain.module.RepositoryModule;
import diogojayme.br.com.vuziq.mvparchitecture.domain.module.ServicesModule;
import io.realm.Realm;

/**
 * Created by diogojayme on 3/13/17.
 */

public class AndroidApplication extends Application {
    private ApplicationComponent servicesComponent;

    public static AndroidApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        Realm.init(this);

        servicesComponent = DaggerApplicationComponent
                .builder()
                .networkModule(new NetworkModule())
                .servicesModule(new ServicesModule())
                .repositoryModule(new RepositoryModule())
                .applicationModule(new ApplicationModule())
                .build();
    }

    public static ApplicationComponent AppComponent() {
        try {
            if(instance == null || instance.servicesComponent == null){
                throw new NullPointerException("ApplicationComponent is null");
            }

        }catch (Exception e){
            e.printStackTrace();
        }


        return instance.servicesComponent;
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        instance = null;
    }
}
