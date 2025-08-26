package guru.qa.rococo.data.dao;

import guru.qa.rococo.data.DataBase;
import guru.qa.rococo.data.jpa.EntityManagerFactoryProvider;
import guru.qa.rococo.data.jpa.JpaService;
import guru.qa.rococo.data.model.AuthUserEntity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

public class AuthUserDAOHibernate extends JpaService {
    private static final PasswordEncoder pe = PasswordEncoderFactories.createDelegatingPasswordEncoder();
    public AuthUserDAOHibernate() {
        super(EntityManagerFactoryProvider.INSTANCE.getDataSource(DataBase.AUTH).createEntityManager());
    }


    @Transactional(readOnly = true)
    public void createUser(AuthUserEntity user) {
        user.setPassword(pe.encode(user.getPassword()));
        persist(user);
    }

    @Transactional(readOnly = true)
    public AuthUserEntity getUserFromAuthUserById(UUID userId) {
        return em.createQuery("select u from AuthUserEntity u where u.id=:userId", AuthUserEntity.class)
                .setParameter("userId", userId)
                .getSingleResult();
    }


    @Transactional(readOnly = true)
    public void updateUser(AuthUserEntity user) {
        merge(user);
    }

    @Transactional(readOnly = true)
    public void deleteUser(AuthUserEntity user) {
        remove(user);
    }
}
