package guru.qa.rococo.data.dao;

import guru.qa.rococo.data.DataBase;
import guru.qa.rococo.data.jpa.EntityManagerFactoryProvider;
import guru.qa.rococo.data.jpa.JpaService;
import guru.qa.rococo.data.model.MuseumEntity;

public class MuseumDAOHibernate extends JpaService {
    public MuseumDAOHibernate() {
        super(EntityManagerFactoryProvider.INSTANCE.getDataSource(DataBase.MUSEUM).createEntityManager());
    }

    public void createMuseum(MuseumEntity museum) {
        persist(museum);
    }


    public void deleteMuseum(MuseumEntity museum) {
        remove(museum);
    }
}