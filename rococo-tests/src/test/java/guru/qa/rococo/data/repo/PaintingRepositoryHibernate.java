package guru.qa.rococo.data.repo;

import guru.qa.rococo.config.Config;
import guru.qa.rococo.data.model.PaintingEntity;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

public class PaintingRepositoryHibernate extends BaseRepository {

    public PaintingRepositoryHibernate() {
        super(Config.getInstance().paintingJdbcUrl());
    }

    @Transactional
    public void createPainting(PaintingEntity painting) {
        tx.execute(() -> em.persist(painting));
    }

    @Transactional
    public void deletePaintingById(UUID paintingId) {
        tx.execute(() -> {
            PaintingEntity painting = em.find(PaintingEntity.class, paintingId);
            if (painting != null) {
                em.remove(painting);
            }
        });
    }
}
