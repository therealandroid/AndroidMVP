package diogojayme.br.com.vuziq.mvparchitecture.domain.respository;

import javax.inject.Inject;

import diogojayme.br.com.vuziq.mvparchitecture.application.AndroidApplication;
import diogojayme.br.com.vuziq.mvparchitecture.domain.mapper.Mapper;
import diogojayme.br.com.vuziq.mvparchitecture.domain.models.User;
import diogojayme.br.com.vuziq.mvparchitecture.domain.realm.UserRealm;
import io.realm.Realm;

/**
 * Created by diogojayme on 3/14/17.
 */

public class UserRepository extends GenericRepository<UserRealm> {

    private Mapper mapper;

    @Inject
    public UserRepository(Mapper mapper){
        AndroidApplication.AppComponent().inject(this);
    }

    public boolean isUserLogged(User user) {
        Realm realm = getDefaultInstance();
        UserRealm userRealm = realm.where(UserRealm.class).equalTo("id", user.getId()).findFirst();

        return userRealm != null;
    }

}
