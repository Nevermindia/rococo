package guru.qa.rococo.data.dao;

import guru.qa.rococo.data.DataBase;
import guru.qa.rococo.data.jpa.EntityManagerFactoryProvider;
import guru.qa.rococo.data.jpa.JpaService;
import guru.qa.rococo.data.model.UserDataEntity;
import org.springframework.transaction.annotation.Transactional;

public class UserDataDAOHibernate extends JpaService {
    public UserDataDAOHibernate() {
        super(EntityManagerFactoryProvider.INSTANCE.getDataSource(DataBase.USERDATA).createEntityManager());
    }

    @Transactional
    public void createUserInUserData(UserDataEntity user) {
        this.persist(user);
    }

    @Transactional
    public void deleteUserInUserData(UserDataEntity user) {
        this.remove(user);
    }
}
