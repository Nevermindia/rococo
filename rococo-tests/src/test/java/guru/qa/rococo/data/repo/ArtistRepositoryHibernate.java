package guru.qa.rococo.data.repo;

import guru.qa.rococo.config.Config;
import guru.qa.rococo.data.model.ArtistEntity;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

public class ArtistRepositoryHibernate extends BaseRepository {

    public ArtistRepositoryHibernate() {
        super(Config.getInstance().artistJdbcUrl());
    }

    @Transactional
    public void createArtist(ArtistEntity artist) {
        tx.execute(() -> em.persist(artist));
    }

    @Transactional
    public void deleteArtistById(UUID artistId) {
        tx.execute(() -> {
            ArtistEntity artist = em.find(ArtistEntity.class, artistId);
            if (artist != null) {
                em.remove(artist);
            }
        });
    }
}