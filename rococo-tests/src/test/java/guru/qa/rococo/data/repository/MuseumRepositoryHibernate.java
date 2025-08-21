package guru.qa.rococo.data.repository;

import guru.qa.rococo.data.dao.MuseumDAOHibernate;
import guru.qa.rococo.data.model.MuseumEntity;

import java.util.UUID;

public class MuseumRepositoryHibernate {
    private final MuseumDAOHibernate museumDAO = new MuseumDAOHibernate();

    public MuseumEntity createMuseumForTest(MuseumEntity museum) {
        return museumDAO.createMuseum(museum);
    }

    public void deleteMuseumById(UUID museumId) {
        museumDAO.deleteMuseumById(museumId);
    }
}
