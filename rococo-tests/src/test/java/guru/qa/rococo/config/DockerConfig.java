package guru.qa.rococo.config;

import javax.annotation.Nonnull;
import java.util.Objects;

enum DockerConfig implements Config{
    instance;

    @Nonnull
    @Override
    public String frontUrl() {
        return "";
    }

    @Nonnull
    @Override
    public String authUrl() {
        return "";
    }

    @Nonnull
    @Override
    public String authJdbcUrl() {
        return "";
    }

    @Nonnull
    @Override
    public String gatewayUrl() {
        return "";
    }

    @Nonnull
    @Override
    public String userdataUrl() {
        return "";
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
        String allureDockerApiUrl = System.getenv("ALLURE_DOCKER_API");
        return Objects.requireNonNullElse(allureDockerApiUrl, "http://allure:5050/");
    }
}
