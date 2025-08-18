package guru.qa.rococo.data.repository;

import guru.qa.rococo.data.dao.AuthUserDAOHibernate;
import guru.qa.rococo.data.dao.UserDataDAOHibernate;
import guru.qa.rococo.data.model.AuthUserEntity;
import guru.qa.rococo.data.model.UserDataEntity;

public class UserRepositoryHibernate {
    private final AuthUserDAOHibernate authUserDAO;
    private final UserDataDAOHibernate userDataDAO;

    public UserRepositoryHibernate() {
        this(new AuthUserDAOHibernate(), new UserDataDAOHibernate());
    }

    public UserRepositoryHibernate(AuthUserDAOHibernate authUserDAO, UserDataDAOHibernate userDataDAO) {
        this.authUserDAO = authUserDAO;
        this.userDataDAO = userDataDAO;
    }

    public void createUserForTest(AuthUserEntity user) {
        this.authUserDAO.createUser(user);
        this.userDataDAO.createUserInUserData(fromAuthUser(user));
    }

    private UserDataEntity fromAuthUser(AuthUserEntity user) {
        UserDataEntity userData = new UserDataEntity();
        userData.setUsername(user.getUsername());
        return userData;
    }
}
