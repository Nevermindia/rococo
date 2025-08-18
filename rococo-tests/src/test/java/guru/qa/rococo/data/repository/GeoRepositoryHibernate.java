package guru.qa.rococo.data.repository;

import guru.qa.rococo.data.dao.GeoDAOHibernate;
import guru.qa.rococo.data.model.CountryEntity;

import java.util.List;
import java.util.UUID;

public class GeoRepositoryHibernate {
    private final GeoDAOHibernate geoDAO = new GeoDAOHibernate();

    public CountryEntity getCountryById(UUID countryId) {
        return geoDAO.getCountryById(countryId);
    }

    public CountryEntity getCountryByName(String countryName) {
        return geoDAO.getCountryName(countryName);
    }

    public List<CountryEntity> getAllCountry() {
        return geoDAO.getAllCountry();
    }
}
