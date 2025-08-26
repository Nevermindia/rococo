package guru.qa.rococo.data.repo;

import guru.qa.rococo.config.Config;
import guru.qa.rococo.data.jpa.EntityManagers;
import guru.qa.rococo.data.tpl.XaTransactionTemplate;
import jakarta.persistence.EntityManager;

public class BaseRepository {
    protected final Config CFG = Config.getInstance();
    protected final EntityManager em;
    protected final XaTransactionTemplate tx;

    protected BaseRepository(String jdbcUrl) {
        this.em = EntityManagers.em(jdbcUrl);
        this.tx = new XaTransactionTemplate(jdbcUrl);
    }
}
