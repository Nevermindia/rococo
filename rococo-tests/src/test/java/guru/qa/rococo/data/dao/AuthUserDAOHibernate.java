package guru.qa.rococo.data.dao;

import guru.qa.rococo.data.DataBase;
import guru.qa.rococo.data.jpa.EntityManagerFactoryProvider;
import guru.qa.rococo.data.jpa.JpaService;
import guru.qa.rococo.data.model.AuthUserEntity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.UUID;

public class AuthUserDAOHibernate extends JpaService {
    private static final PasswordEncoder pe = PasswordEncoderFactories.createDelegatingPasswordEncoder();
    public AuthUserDAOHibernate() {
        super(EntityManagerFactoryProvider.INSTANCE.getDataSource(DataBase.AUTH).createEntityManager());
    }


    public void createUser(AuthUserEntity user) {
        user.setPassword(pe.encode(user.getPassword()));
        persist(user);
    }


    public AuthUserEntity getUserFromAuthUserById(UUID userId) {
        return em.createQuery("select u from AuthUserEntity u where u.id=:userId", AuthUserEntity.class)
                .setParameter("userId", userId)
                .getSingleResult();
    }


    public void updateUser(AuthUserEntity user) {
        merge(user);
    }


    public void deleteUser(AuthUserEntity user) {
        remove(user);
    }
}
