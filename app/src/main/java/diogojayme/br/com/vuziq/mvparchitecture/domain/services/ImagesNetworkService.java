package diogojayme.br.com.vuziq.mvparchitecture.domain.services;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Response;
import retrofit2.http.GET;

public interface ImagesNetworkService {

    @GET("images")
    Observable<Response<List<String>>> images();
}

