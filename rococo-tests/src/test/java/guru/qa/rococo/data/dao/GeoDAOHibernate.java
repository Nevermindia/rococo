package guru.qa.rococo.data.dao;

import guru.qa.rococo.data.DataBase;
import guru.qa.rococo.data.jpa.EntityManagerFactoryProvider;
import guru.qa.rococo.data.jpa.JpaService;
import guru.qa.rococo.data.model.CountryEntity;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

public class GeoDAOHibernate extends JpaService {

    public GeoDAOHibernate() {
        super(EntityManagerFactoryProvider.INSTANCE.getDataSource(DataBase.GEO).createEntityManager());
    }


    @Transactional(readOnly = true)
    public CountryEntity getCountryById(UUID countryId) {
        return em.createQuery("select country from CountryEntity country where country.id=:countryId", CountryEntity.class)
                .setParameter("countryId", countryId)
                .getSingleResult();
    }


    @Transactional(readOnly = true)
    public CountryEntity getCountryName(String countryName) {
        return em.createQuery("select country from CountryEntity country where country.name=:countryName", CountryEntity.class)
                .setParameter("countryName", countryName)
                .getSingleResult();
    }

    @Transactional(readOnly = true)
    public List<CountryEntity> getAllCountry() {
        return em.createQuery("select c from CountryEntity c", CountryEntity.class)
                .getResultList();
    }
}
