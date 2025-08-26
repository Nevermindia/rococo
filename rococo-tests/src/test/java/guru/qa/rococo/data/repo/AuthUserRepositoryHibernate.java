package guru.qa.rococo.data.repo;

import guru.qa.rococo.config.Config;
import guru.qa.rococo.data.model.AuthUserEntity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

public class AuthUserRepositoryHibernate extends BaseRepository {
    private static final PasswordEncoder pe = PasswordEncoderFactories.createDelegatingPasswordEncoder();

    public AuthUserRepositoryHibernate() {
        super(Config.getInstance().authJdbcUrl());
    }

    @Transactional
    public void createUser(AuthUserEntity user) {
        user.setPassword(pe.encode(user.getPassword()));
        tx.execute(() -> em.persist(user));
    }
}
