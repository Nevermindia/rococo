package guru.qa.rococo.data.repo;

import guru.qa.rococo.config.Config;
import guru.qa.rococo.data.model.UserDataEntity;
import org.springframework.transaction.annotation.Transactional;

public class UserDataRepositoryHibernate extends BaseRepository {

    public UserDataRepositoryHibernate() {
        super(Config.getInstance().userdataJdbcUrl());
    }

    @Transactional
    public void createUserInUserData(UserDataEntity user) {
        tx.execute(() -> em.persist(user));
    }
}
