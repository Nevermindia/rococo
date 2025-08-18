package guru.qa.rococo.data.dao;

import guru.qa.rococo.data.DataBase;
import guru.qa.rococo.data.jpa.EntityManagerFactoryProvider;
import guru.qa.rococo.data.jpa.JpaService;
import guru.qa.rococo.data.model.UserDataEntity;

public class UserDataDAOHibernate extends JpaService {
    public UserDataDAOHibernate() {
        super(EntityManagerFactoryProvider.INSTANCE.getDataSource(DataBase.USERDATA).createEntityManager());
    }

    public void createUserInUserData(UserDataEntity user) {
        this.persist(user);
    }

    public void deleteUserInUserData(UserDataEntity user) {
        this.remove(user);
    }
}
