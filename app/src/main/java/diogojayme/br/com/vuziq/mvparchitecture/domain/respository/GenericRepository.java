package diogojayme.br.com.vuziq.mvparchitecture.domain.respository;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import diogojayme.br.com.vuziq.mvparchitecture.domain.mapper.Mapper;
import io.realm.Realm;
import io.realm.RealmObject;

/**
 * Created by diogojayme on 2/10/17.
 */

public abstract class GenericRepository<T extends RealmObject> {
    private Class<T> beanClass;
    public Mapper mapper;

    public Realm getDefaultInstance(){
        return Realm.getDefaultInstance();
    }

    protected GenericRepository() {
        this.mapper = new Mapper();

        Type genericSuperClass = getClass().getGenericSuperclass();

        if (genericSuperClass != null && !(genericSuperClass instanceof Class)) {
            this.beanClass = (Class<T>) ((ParameterizedType) genericSuperClass).getActualTypeArguments()[0];
        }
    }

    public T findByFieldName(String fieldName, String value){
        Realm realm = Realm.getDefaultInstance();
        return realm.copyFromRealm(realm.where(beanClass).equalTo(fieldName, value).findFirst());
    }

    public T findById(long id){
        Realm realm = Realm.getDefaultInstance();
        return realm.copyFromRealm(realm.where(beanClass).equalTo("id", id).findFirst());
    }

    public List<T> findAll(){
        Realm realm = Realm.getDefaultInstance();
        return realm.copyFromRealm(realm.where(beanClass).findAll());
    }

    public T insertOrUpdate(T realmObject){
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        realmObject = realm.copyToRealmOrUpdate(realmObject);
        realm.commitTransaction();

        return realm.copyFromRealm(realmObject);
    }
}
