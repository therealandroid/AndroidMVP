package diogojayme.br.com.vuziq.mvparchitecture.application;

import android.app.Application;

import diogojayme.br.com.vuziq.mvparchitecture.domain.components.DaggerRepositoryComponent;
import diogojayme.br.com.vuziq.mvparchitecture.domain.components.DaggerServicesComponent;
import diogojayme.br.com.vuziq.mvparchitecture.domain.components.RepositoryComponent;
import diogojayme.br.com.vuziq.mvparchitecture.domain.components.ServicesComponent;
import diogojayme.br.com.vuziq.mvparchitecture.domain.module.NetworkModule;
import diogojayme.br.com.vuziq.mvparchitecture.domain.module.ServicesModule;

/**
 * Created by diogojayme on 3/13/17.
 */

public class AndroidApplication extends Application {
    private ServicesComponent servicesComponent;
    private RepositoryComponent repositoryComponent;

    public static AndroidApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;

        servicesComponent = DaggerServicesComponent
                .builder()
                .networkModule(new NetworkModule())
                .servicesModule(new ServicesModule())
                .build();

        repositoryComponent = DaggerRepositoryComponent
                .builder()
                .build();
    }

    public static ServicesComponent Api() {
        try {
            if(instance == null || instance.servicesComponent == null){
                throw new NullPointerException("ServicesComponent is null");
            }

        }catch (Exception e){
            e.printStackTrace();
        }


        return instance.servicesComponent;
    }


    public static RepositoryComponent Repository() {
        try {
            if(instance == null || instance.repositoryComponent == null){
                throw new NullPointerException("repositoryComponent is null");
            }

        }catch (Exception e){
            e.printStackTrace();
        }


        return instance.repositoryComponent;
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        instance = null;
    }
}
