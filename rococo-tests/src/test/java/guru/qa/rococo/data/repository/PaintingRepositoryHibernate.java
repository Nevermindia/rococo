package guru.qa.rococo.data.repository;

import guru.qa.rococo.data.dao.PaintingDAOHibernate;
import guru.qa.rococo.data.model.PaintingEntity;

import java.util.UUID;

public class PaintingRepositoryHibernate {
    private final PaintingDAOHibernate paintingDAO = new PaintingDAOHibernate();

    public void createPaintingForTest(PaintingEntity painting) {
        paintingDAO.createPainting(painting);
    }

    public void deletePaintingById(UUID paintingId) {
        paintingDAO.deletePaintingById(paintingId);
    }
}
