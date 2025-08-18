package guru.qa.rococo.jupiter.extension;

import guru.qa.rococo.data.jpa.EntityManagerFactoryProvider;
import jakarta.persistence.EntityManagerFactory;

public class JpaExtension implements SuiteExtension {
    @Override
    public void afterSuite() {
        EntityManagerFactoryProvider.INSTANCE.allStoredEntityManagerFactories()
                .forEach(EntityManagerFactory::close);
    }
}
