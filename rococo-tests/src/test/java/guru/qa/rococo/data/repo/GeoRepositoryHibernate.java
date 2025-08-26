package guru.qa.rococo.data.repo;

import guru.qa.rococo.config.Config;
import guru.qa.rococo.data.model.CountryEntity;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

public class GeoRepositoryHibernate extends BaseRepository {

    public GeoRepositoryHibernate() {
        super(Config.getInstance().geoJdbcUrl());
    }

    @Transactional
    public CountryEntity getCountryById(UUID countryId) {
        return em.createQuery("select country from CountryEntity country where country.id=:countryId", CountryEntity.class)
                .setParameter("countryId", countryId)
                .getSingleResult();
    }


    @Transactional
    public CountryEntity getCountryByName(String countryName) {
        return em.createQuery("select country from CountryEntity country where country.name=:countryName", CountryEntity.class)
                .setParameter("countryName", countryName)
                .getSingleResult();
    }

    @Transactional
    public List<CountryEntity> getAllCountry() {
        return em.createQuery("select c from CountryEntity c", CountryEntity.class)
                .getResultList();
    }
}
