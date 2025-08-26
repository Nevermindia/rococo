package guru.qa.rococo.data.repo;

import guru.qa.rococo.config.Config;
import guru.qa.rococo.data.model.MuseumEntity;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

public class MuseumRepositoryHibernate extends BaseRepository {

    public MuseumRepositoryHibernate() {
        super(Config.getInstance().museumJdbcUrl());
    }

    @Transactional
    public MuseumEntity createMuseum(MuseumEntity museum) {
        tx.execute(() -> em.persist(museum));
        return museum;
    }

    @Transactional
    public void deleteMuseumById(UUID museumId) {
        tx.execute(() -> {
            MuseumEntity museum = em.find(MuseumEntity.class, museumId);
            if (museum != null) {
                em.remove(museum);
            }
        });
    }
}