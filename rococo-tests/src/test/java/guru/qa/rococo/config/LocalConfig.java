package guru.qa.rococo.config;

import com.codeborne.selenide.Configuration;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;

enum LocalConfig implements Config {
    INSTANCE;

    static {
        Configuration.browserSize = "1920x1080";
    }

    @Override
    public String databaseAddress() {
        return "localhost:3306";
    }

    @Override
    public String frontUrl() {
        return "http://127.0.0.1:3000/";
    }

    @Nonnull
    @Override
    public String gatewayUrl() {
        return "http://127.0.0.1:8080/";
    }

    @Override
    public String authUrl() {
        return "http://127.0.0.1:9000/";
    }

    @Override
    public String userdataGrpcAddress() {
        return "127.0.0.1";
    }

    @Override
    public String artistGrpcAddress() {
        return "127.0.0.1";
    }

    @Override
    public String museumGrpcAddress() {
        return "127.0.0.1";
    }

    @Override
    public String geoGrpcAddress() {
        return "127.0.0.1";
    }

    @Override
    public String paintingGrpcAddress() {
        return "127.0.0.1";
    }

    @NotNull
    @Override
    public String screenshotBaseDir() {
        return "screenshots/local/";
    }

    @NotNull
    @Override
    public String allureDockerUrl() {
        return "http://127.0.0.1:5050/";
    }
}

