package diogojayme.br.com.vuziq.mvparchitecture.domain.respository;

import java.util.Map;

import javax.inject.Inject;

import diogojayme.br.com.vuziq.mvparchitecture.application.AndroidApplication;
import diogojayme.br.com.vuziq.mvparchitecture.domain.mapper.Mapper;
import diogojayme.br.com.vuziq.mvparchitecture.domain.models.User;
import diogojayme.br.com.vuziq.mvparchitecture.domain.realm.UserRealm;

/**
 * Created by diogojayme on 3/14/17.
 */

public class UserRepository extends GenericRepository<UserRealm> {

    private Mapper mapper;

    @Inject
    public UserRepository(Mapper mapper){
        AndroidApplication.Repository().inject(this);
    }

    public User isUserLogged() {
        UserRealm userRealm = findByFieldName("logged", true);
        return mapper.transform(userRealm, User.class);
    }

}
