package guru.qa.rococo.config;

import javax.annotation.Nonnull;

enum LocalConfig implements Config {
    instance;

    @Nonnull
    @Override
    public String frontUrl() {
        return "http://127.0.0.1:3000/";
    }

    @Nonnull
    @Override
    public String authUrl() {
        return "http://127.0.0.1:9000/";
    }

    @Nonnull
    @Override
    public String authJdbcUrl() {
        return "";
    }

    @Nonnull
    @Override
    public String gatewayUrl() {
        return "http://127.0.0.1:8090/";
    }

    @Nonnull
    @Override
    public String userdataUrl() {
        return "http://127.0.0.1:8091/";
    }

    @Nonnull
    @Override
    public String userdataJdbcUrl() {
        return "";
    }

    @Nonnull
    @Override
    public String artistUrl() {
        return "";
    }

    @Nonnull
    @Override
    public String artistJdbcUrl() {
        return "";
    }

    @Nonnull
    @Override
    public String geoJdbcUrl() {
        return "";
    }

    @Nonnull
    @Override
    public String geoUrl() {
        return "";
    }

    @Nonnull
    @Override
    public String museumJdbcUrl() {
        return "";
    }

    @Nonnull
    @Override
    public String museumUrl() {
        return "";
    }

    @Nonnull
    @Override
    public String paintingJdbcUrl() {
        return "";
    }

    @Nonnull
    @Override
    public String paintingUrl() {
        return "";
    }

    @Nonnull
    @Override
    public String allureDockerServiceUrl() {
        return "http://127.0.0.1:5050/";
    }
}

