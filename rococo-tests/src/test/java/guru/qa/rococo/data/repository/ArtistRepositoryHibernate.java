package guru.qa.rococo.data.repository;

import guru.qa.rococo.data.dao.ArtistDAOHibernate;
import guru.qa.rococo.data.model.ArtistEntity;

import java.util.UUID;

public class ArtistRepositoryHibernate {

    private final ArtistDAOHibernate artistDAO = new ArtistDAOHibernate();

    public void createArtistForTest(ArtistEntity artist) {
        artistDAO.createArtist(artist);
    }

    public void deleteArtistById(UUID artistId) {
        artistDAO.deleteArtistById(artistId);
    }
}