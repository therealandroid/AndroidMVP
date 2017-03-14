package diogojayme.br.com.vuziq.mvparchitecture.domain.services;

import diogojayme.br.com.vuziq.mvparchitecture.domain.models.User;
import io.reactivex.Observable;
import retrofit2.Response;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface AuthenticationNetworkService {

    @POST("auth/login")
    Observable<Response<User>> login(@Query("username") String login, @Query("password") String password);

    @POST("auth/register")
    Observable<Response<User>> register(@Query("username") String login, @Query("password") String password);
}

