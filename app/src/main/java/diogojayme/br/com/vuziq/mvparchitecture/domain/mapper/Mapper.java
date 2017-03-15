package diogojayme.br.com.vuziq.mvparchitecture.domain.mapper;

import com.google.gson.Gson;

import java.lang.reflect.Type;

import javax.inject.Inject;

/**
 * Created by diogojayme on 3/14/17.
 */

public class Mapper {
    private Gson gson;

    @Inject
    public Mapper(Gson gson){
        this.gson = gson;
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
