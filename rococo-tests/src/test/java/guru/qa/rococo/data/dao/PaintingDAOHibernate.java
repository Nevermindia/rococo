package guru.qa.rococo.data.dao;

import guru.qa.rococo.data.DataBase;
import guru.qa.rococo.data.jpa.EntityManagerFactoryProvider;
import guru.qa.rococo.data.jpa.JpaService;
import guru.qa.rococo.data.model.PaintingEntity;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

public class PaintingDAOHibernate extends JpaService {
    public PaintingDAOHibernate() {
        super(EntityManagerFactoryProvider.INSTANCE.getDataSource(DataBase.PAINTING).createEntityManager());
    }

    @Transactional
    public void createPainting(PaintingEntity painting) {
        persist(painting);
    }

    @Transactional
    public void deletePaintingById(UUID paintingId) {
        tx(em -> {
            PaintingEntity painting = em.find(PaintingEntity.class, paintingId);
            if (painting != null) {
                em.remove(painting);
            }
        });
    }
}
