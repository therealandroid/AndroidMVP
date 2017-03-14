package diogojayme.br.com.vuziq.mvparchitecture.domain.mapper;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.lang.reflect.Type;

import io.realm.Realm;

/**
 * Created by diogojayme on 3/14/17.
 */

public class Mapper {
    private Gson gson;

    public Mapper(){
        gson = new GsonBuilder()
                .setExclusionStrategies(new ExclusionStrategy() {
                    @Override
                    public boolean shouldSkipField(FieldAttributes f) {
                        return f.getDeclaringClass().equals(Realm.class);
                    }

                    @Override
                    public boolean shouldSkipClass(Class<?> clazz) {
                        return false;
                    }
                }).create();
    }

    public <T> T transform(Object from, Class<T> to) {
        String modelString = gson.toJson(from);
        return gson.fromJson(modelString, to);
    }

    //For lists
    public <T> T transform(Object from, Type to) {
        String modelString = gson.toJson(from);
        return gson.fromJson(modelString, to);
    }

}
