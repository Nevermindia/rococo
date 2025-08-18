package guru.qa.rococo.data.repository;

import guru.qa.rococo.data.dao.PaintingDAOHibernate;
import guru.qa.rococo.data.model.PaintingEntity;

public class PaintingRepositoryHibernate {
    private final PaintingDAOHibernate paintingDAO = new PaintingDAOHibernate();

    public void createPaintingForTest(PaintingEntity painting) {
        paintingDAO.createPainting(painting);
    }

    public void deletePainting(PaintingEntity painting) {
        paintingDAO.deletePainting(painting);
    }
}
