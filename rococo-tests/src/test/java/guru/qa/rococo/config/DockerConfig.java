package guru.qa.rococo.config;

import com.codeborne.selenide.Configuration;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.chrome.ChromeOptions;

import javax.annotation.Nonnull;
import java.util.Objects;

enum DockerConfig implements Config {
    INSTANCE;

    static {
        Configuration.remote = "http://selenoid:4444/wd/hub";
        Configuration.browserSize = "1920x1080";
        Configuration.browserCapabilities = new ChromeOptions()
                .addArguments("--no-sandbox");
    }

    @Override
    public String databaseAddress() {
        return "rococo-all-db:3306";
    }

    @Override
    public String frontUrl() {
        return "http://client.rococo.dc/";
    }

    @Override
    public String authUrl() {
        return "http://auth.rococo.dc:9000/";
    }

    @Override
    public String gatewayUrl() {
        return "http://gateway.rococo.dc:8090/";
    }

    @Override
    public String userdataGrpcAddress() {
        return "userdata.rococo.dc";
    }

    @Override
    public String artistGrpcAddress() {
        return "artist.rococo.dc";
    }

    @Override
    public String museumGrpcAddress() {
        return "museum.rococo.dc";
    }

    @Override
    public String geoGrpcAddress() {
        return "geo.rococo.dc";
    }

    @Override
    public String paintingGrpcAddress() {
        return "painting.rococo.dc";
    }

    @NotNull
    @Override
    public String screenshotBaseDir() {
        return "screenshots/selenoid/";
    }

    @Nonnull
    @Override
    public String allureDockerUrl() {
        final String url = System.getenv("ALLURE_DOCKER_API");
        return url == null
                ? "http://allure:5050/"
                : url;
    }
}
