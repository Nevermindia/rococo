package guru.qa.rococo.data.repository;

import guru.qa.rococo.data.dao.MuseumDAOHibernate;
import guru.qa.rococo.data.model.MuseumEntity;

public class MuseumRepositoryHibernate {
    private final MuseumDAOHibernate museumDAO = new MuseumDAOHibernate();


    public void createMuseumForTest(MuseumEntity museum) {
        museumDAO.createMuseum(museum);
    }

    public void deleteMuseum(MuseumEntity museum) {
        museumDAO.deleteMuseum(museum);
    }
}
