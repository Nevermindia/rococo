package guru.qa.rococo.data.dao;

import guru.qa.rococo.data.DataBase;
import guru.qa.rococo.data.jpa.EntityManagerFactoryProvider;
import guru.qa.rococo.data.jpa.JpaService;
import guru.qa.rococo.data.model.MuseumEntity;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

public class MuseumDAOHibernate extends JpaService {
    public MuseumDAOHibernate() {
        super(EntityManagerFactoryProvider.INSTANCE.getDataSource(DataBase.MUSEUM).createEntityManager());
    }

    @Transactional
    public MuseumEntity createMuseum(MuseumEntity museum) {
        tx(em -> em.persist(museum));
        return museum;
    }

    @Transactional
    public void deleteMuseumById(UUID museumId) {
        tx(em -> {
            MuseumEntity museum = em.find(MuseumEntity.class, museumId);
            if (museum != null) {
                em.remove(museum);
            }
        });
    }
}