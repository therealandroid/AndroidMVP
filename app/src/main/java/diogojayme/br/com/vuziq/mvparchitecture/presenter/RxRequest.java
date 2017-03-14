package diogojayme.br.com.vuziq.mvparchitecture.presenter;


import android.accounts.NetworkErrorException;

import org.json.JSONException;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;

/**
 * Created by diogojayme on 3/10/17.
 */

public abstract class RxRequest<T> {
    public abstract void onSuccess(T t);
    public abstract void onError(String message);
    public abstract void onComplete();

    public void responseOnMainThread(Observable<Response<T>> observable) {
        observable.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Response<T>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Response<T> value) {
                        rawResponse(value);
                    }

                    @Override
                    public void onError(Throwable e) {
                        rawThrowable(e);
                    }

                    @Override
                    public void onComplete() {
                        complete();
                    }
                });
    }

    private void rawResponse(Response<T> response) {
        if(response.isSuccessful()) {
            ok(response.body());
        }else{
            onError(new RetrofitError(Kind.HTTP, response.code(), response.message()));
        }
    }

    private void rawThrowable(Throwable t) {
        if(t instanceof NetworkErrorException){
            onError(new RetrofitError(Kind.HTTP, 0, "No network available, please check your WiFi or Data connection"));
        }else if(t instanceof JSONException){
            onError(new RetrofitError(Kind.HTTP, 0, "Json parser failed"));
        }else{
            onError(new RetrofitError(Kind.HTTP, 0, "Unknown error"));
        }
    }

    private void onError(RetrofitError error) {
        switch (error.getKind()) {
            case NETWORK:
                network(error.getMessage());
                break;
            case UNEXPECTED:
                unexpected(error.getMessage());
                break;
            case HTTP:
                switch (error.getCode()) {
                    case 401:
                        unauthorized(error.getMessage());
                        break;
                    case 404:
                        badRequest(error.getMessage());
                        break;
                    default:
                        unexpected(error.getMessage());
                        break;
                }

                break;
            default:
                unexpected(error.getMessage());
                break;
        }
    }


    private void ok(T value){
        onSuccess(value);
    }

    private void unauthorized(String message){
        onError(message);
    }

    private void badRequest(String message){
        onError(message);
    }

    private void unexpected(String message){
        onError(message);
    }

    private void network(String message){
        onError(message);
    }

    private void complete(){
        onComplete();
    }

}
