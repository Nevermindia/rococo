package guru.qa.rococo.data.repo;

import guru.qa.rococo.config.Config;
import guru.qa.rococo.data.model.ArtistEntity;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

public class ArtistRepositoryHibernate extends BaseRepository {

    public ArtistRepositoryHibernate() {
        super(Config.getInstance().rococoJdbcUrl());
    }

    @Transactional
    public void createArtist(ArtistEntity artist) {
        tx.execute(() -> em.persist(artist));
    }
}