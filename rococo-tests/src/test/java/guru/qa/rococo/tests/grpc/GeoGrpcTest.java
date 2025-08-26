package guru.qa.rococo.tests.grpc;

import com.google.protobuf.ByteString;
import guru.qa.grpc.rococo.grpc.*;
import guru.qa.rococo.config.Config;
import guru.qa.rococo.jupiter.annotation.GrpcTest;
import guru.qa.rococo.model.CountryJson;
import io.grpc.Channel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import io.qameta.allure.grpc.AllureGrpc;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static com.google.protobuf.ByteString.copyFromUtf8;
import static guru.qa.rococo.utils.DefaultData.ID_REGEXP;
import static guru.qa.rococo.utils.RandomDataUtils.getRandomCountry;
import static guru.qa.rococo.utils.RandomDataUtils.randomName;
import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.api.Assertions.*;

@GrpcTest
public class GeoGrpcTest {

    private static final Config CFG = Config.getInstance();
    private static final Channel geoChannel;

    static {
        geoChannel = ManagedChannelBuilder
                .forAddress(CFG.geoGrpcAddress(), CFG.geoGrpcPort())
                .intercept(new AllureGrpc())
                .usePlaintext()
                .build();
    }

    private final RococoGeoServiceGrpc.RococoGeoServiceBlockingStub geoStub = RococoGeoServiceGrpc.newBlockingStub(geoChannel);

    @Test
    @DisplayName("GRPC: Получение информации о стране из rococo-geo по id")
    void getCountryDataByIdTest() {
        CountryJson country = getRandomCountry();
        CountryId request = CountryId.newBuilder()
                .setId(copyFromUtf8(country.id().toString()))
                .build();

        CountryResponse countryResponse = geoStub.getCountry(request);

        step("Проверить название страны в ответе", () -> assertEquals(country.name(), countryResponse.getName()));
        step("Проверить id страны в ответе", () -> assertEquals(country.id(), UUID.fromString(countryResponse.getId().toStringUtf8())));
    }

    @Test
    @DisplayName("GRPC: Получение информации о стране из rococo-geo по названию страны")
    void getCountryDataByNameTest() {
        CountryJson country = getRandomCountry();
        CountryName request = CountryName.newBuilder()
                .setName(country.name())
                .build();

        CountryResponse countryResponse = geoStub.getCountryByName(request);

        step("Проверить название страны в ответе", () -> assertEquals(country.name(), countryResponse.getName()));
        step("Проверить id страны в ответе", () -> assertEquals(country.id(), UUID.fromString(countryResponse.getId().toStringUtf8())));
    }

    @Test
    @DisplayName("GRPC: Ошибка при запросе страны из rococo-geo по несуществующему ID")
    void notExistingCountryIdErrorTest() {
        String notExistingId = UUID.randomUUID().toString();
        CountryId request = CountryId.newBuilder()
                .setId(ByteString.copyFromUtf8(notExistingId))
                .build();

        StatusRuntimeException exception = assertThrows(StatusRuntimeException.class, () -> geoStub.getCountry(request));

        assertEquals(Status.NOT_FOUND.getCode(), exception.getStatus().getCode());
        assertEquals("Country not found by id: " + notExistingId, exception.getStatus().getDescription());
    }

    @Test
    @DisplayName("GRPC: Ошибка при запросе страны из rococo-geo по несуществующему имени")
    void notExistingCountryNameErrorTest() {
        String notExistingCountryName = randomName();
        CountryName request = CountryName.newBuilder()
                .setName(notExistingCountryName)
                .build();

        StatusRuntimeException exception = assertThrows(StatusRuntimeException.class, () -> geoStub.getCountryByName(request));

        assertEquals(Status.NOT_FOUND.getCode(), exception.getStatus().getCode());
        assertEquals("Country not found by name: " + notExistingCountryName, exception.getStatus().getDescription());
    }

    @Test
    @DisplayName("GRPC: Получение списка всех стран")
    void getAllCountriesTest() {
        AllCountryRequest request = AllCountryRequest.newBuilder()
                .setPage(0)
                .setSize(20)
                .build();

        AllCountryResponse response = geoStub.getAllCountry(request);
        assertEquals(20, response.getCountryCount());

        CountryResponse country = response.getCountry(0);
        assertEquals("Австралия", country.getName());
        assertTrue(country.getId().toStringUtf8().matches(ID_REGEXP));
    }

}
