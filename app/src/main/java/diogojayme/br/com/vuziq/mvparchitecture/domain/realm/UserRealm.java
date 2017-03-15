package diogojayme.br.com.vuziq.mvparchitecture.domain.realm;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by diogojayme on 3/14/17.
 */

public class UserRealm extends RealmObject {
    @PrimaryKey
    private int id;

    public UserRealm() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
