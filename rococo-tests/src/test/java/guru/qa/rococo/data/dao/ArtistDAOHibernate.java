package guru.qa.rococo.data.dao;

import guru.qa.rococo.data.DataBase;
import guru.qa.rococo.data.jpa.EntityManagerFactoryProvider;
import guru.qa.rococo.data.jpa.JpaService;
import guru.qa.rococo.data.model.ArtistEntity;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

public class ArtistDAOHibernate extends JpaService {
    public ArtistDAOHibernate() {
        super(EntityManagerFactoryProvider.INSTANCE.getDataSource(DataBase.ARTIST).createEntityManager());
    }

    @Transactional(readOnly = true)
    public void createArtist(ArtistEntity artist) {
        persist(artist);
    }

    @Transactional(readOnly = true)
    public void deleteArtistById(UUID artistId) {
        tx(em -> {
            ArtistEntity artist = em.find(ArtistEntity.class, artistId);
            if (artist != null) {
                em.remove(artist);
            }
        });
    }
}