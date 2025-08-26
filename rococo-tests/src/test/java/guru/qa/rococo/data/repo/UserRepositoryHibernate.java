package guru.qa.rococo.data.repo;

import guru.qa.rococo.data.model.AuthUserEntity;
import guru.qa.rococo.data.model.UserDataEntity;

public class UserRepositoryHibernate {
    private final AuthUserRepositoryHibernate authUserDAO;
    private final UserDataRepositoryHibernate userDataDAO;

    public UserRepositoryHibernate() {
        this(new AuthUserRepositoryHibernate(), new UserDataRepositoryHibernate());
    }

    public UserRepositoryHibernate(AuthUserRepositoryHibernate authUserDAO, UserDataRepositoryHibernate userDataDAO) {
        this.authUserDAO = authUserDAO;
        this.userDataDAO = userDataDAO;
    }

    public void createUser(AuthUserEntity user) {
        this.authUserDAO.createUser(user);
        this.userDataDAO.createUserInUserData(fromAuthUser(user));
    }

    private UserDataEntity fromAuthUser(AuthUserEntity user) {
        UserDataEntity userData = new UserDataEntity();
        userData.setUsername(user.getUsername());
        return userData;
    }
}
