package guru.qa.rococo.data.dao;

import guru.qa.rococo.data.DataBase;
import guru.qa.rococo.data.jpa.EntityManagerFactoryProvider;
import guru.qa.rococo.data.jpa.JpaService;
import guru.qa.rococo.data.model.ArtistEntity;

public class ArtistDAOHibernate extends JpaService {
    public ArtistDAOHibernate() {
        super(EntityManagerFactoryProvider.INSTANCE.getDataSource(DataBase.ARTIST).createEntityManager());
    }

    public void createArtist(ArtistEntity artist) {
        persist(artist);
    }

    public void deleteArtist(ArtistEntity artist) {
        remove(artist);
    }
}