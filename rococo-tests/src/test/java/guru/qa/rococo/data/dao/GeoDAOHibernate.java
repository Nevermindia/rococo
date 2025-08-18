package guru.qa.rococo.data.dao;

import guru.qa.rococo.data.DataBase;
import guru.qa.rococo.data.jpa.EntityManagerFactoryProvider;
import guru.qa.rococo.data.jpa.JpaService;
import guru.qa.rococo.data.model.CountryEntity;

import java.util.List;
import java.util.UUID;

public class GeoDAOHibernate extends JpaService {

    public GeoDAOHibernate() {
        super(EntityManagerFactoryProvider.INSTANCE.getDataSource(DataBase.GEO).createEntityManager());
    }


    public CountryEntity getCountryById(UUID countryId) {
        return em.createQuery("select country from CountryEntity country where country.id=:countryId", CountryEntity.class)
                .setParameter("countryId", countryId)
                .getSingleResult();
    }


    public CountryEntity getCountryName(String countryName) {
        return em.createQuery("select country from CountryEntity country where country.name=:countryName", CountryEntity.class)
                .setParameter("countryName", countryName)
                .getSingleResult();
    }

    public List<CountryEntity> getAllCountry() {
        return em.createQuery("select c from CountryEntity c", CountryEntity.class)
                .getResultList();
    }
}
