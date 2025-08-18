package guru.qa.rococo.data.dao;

import guru.qa.rococo.data.DataBase;
import guru.qa.rococo.data.jpa.EntityManagerFactoryProvider;
import guru.qa.rococo.data.jpa.JpaService;
import guru.qa.rococo.data.model.PaintingEntity;

public class PaintingDAOHibernate extends JpaService {
    public PaintingDAOHibernate() {
        super(EntityManagerFactoryProvider.INSTANCE.getDataSource(DataBase.PAINTING).createEntityManager());
    }

    public void createPainting(PaintingEntity painting) {
        persist(painting);
    }

    public void deletePainting(PaintingEntity painting) {
        remove(painting);
    }
}
