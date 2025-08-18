package guru.qa.rococo.data.repository;

import guru.qa.rococo.data.dao.ArtistDAOHibernate;
import guru.qa.rococo.data.model.ArtistEntity;

public class ArtistRepositoryHibernate {

    private final ArtistDAOHibernate artistDAO = new ArtistDAOHibernate();

    public void createArtistForTest(ArtistEntity artist) {
        artistDAO.createArtist(artist);
    }

    public void deleteArtist(ArtistEntity artist) {
        artistDAO.deleteArtist(artist);
    }
}