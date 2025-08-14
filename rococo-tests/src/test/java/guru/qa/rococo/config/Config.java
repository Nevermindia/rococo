package guru.qa.rococo.config;

import javax.annotation.Nonnull;

public interface Config {

    static @Nonnull Config getInstance() {
        return "docker".equals(System.getProperty("test.env"))
                ? DockerConfig.instance
                : LocalConfig.instance;
    }
    @Nonnull
    String frontUrl();

    @Nonnull
    String authUrl();

    @Nonnull
    String authJdbcUrl();

    @Nonnull
    String gatewayUrl();

    @Nonnull
    String userdataUrl();

    @Nonnull
    String userdataJdbcUrl();

    @Nonnull
    String artistUrl();

    @Nonnull
    String artistJdbcUrl();

    @Nonnull
    String geoJdbcUrl();

    @Nonnull
    String geoUrl();

    @Nonnull
    String museumJdbcUrl();

    @Nonnull
    String museumUrl();

    @Nonnull
    String paintingJdbcUrl();

    @Nonnull
    String paintingUrl();

    default int currencyGrpcPort(){
        return 8092;
    }

    @Nonnull
    String allureDockerServiceUrl();
}
