package guru.qa.rococo.tests.grpc;

import com.google.protobuf.ByteString;
import guru.qa.grpc.rococo.grpc.*;
import guru.qa.rococo.config.Config;
import guru.qa.rococo.jupiter.annotation.GrpcTest;
import guru.qa.rococo.jupiter.annotation.Museum;
import guru.qa.rococo.model.MuseumJson;
import io.grpc.Channel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import io.qameta.allure.grpc.AllureGrpc;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static com.google.protobuf.ByteString.copyFromUtf8;
import static guru.qa.rococo.model.MuseumJson.fromGrpcMessage;
import static guru.qa.rococo.utils.DefaultData.*;
import static guru.qa.rococo.utils.ImageUtil.convertImageToBase64;
import static guru.qa.rococo.utils.RandomDataUtils.*;
import static io.qameta.allure.Allure.step;
import static java.util.UUID.fromString;
import static org.junit.jupiter.api.Assertions.*;

@GrpcTest
public class MuseumGrpcTest {

    private static final Config CFG = Config.getInstance();
    private static final Channel museumChannel;

    static {
        museumChannel = ManagedChannelBuilder
                .forAddress(CFG.museumGrpcAddress(), CFG.museumGrpcPort())
                .intercept(new AllureGrpc())
                .usePlaintext()
                .build();
    }

    private final RococoMuseumServiceGrpc.RococoMuseumServiceBlockingStub museumStub = RococoMuseumServiceGrpc.newBlockingStub(museumChannel);

    @Test
    @DisplayName("GRPC: Получение информации о музее из rococo-museum")
    @Museum
    void getMuseumDataTest(MuseumJson createdMuseum) {
        String createdMuseumId = createdMuseum.getId().toString();
        MuseumRequest request = MuseumRequest.newBuilder()
                .setId(copyFromUtf8(createdMuseumId))
                .build();

        MuseumResponse museumResponse = museumStub.getMuseum(request);

        step("Проверить музей в ответе", () -> assertEquals(createdMuseum, fromGrpcMessage(museumResponse)));
    }

    @Test
    @DisplayName("GRPC: Ошибка при запросе музея из rococo-museum по несуществующему ID")
    void notExistingMuseumIdErrorTest() {
        String notExistingId = UUID.randomUUID().toString();
        MuseumRequest request = MuseumRequest.newBuilder()
                .setId(copyFromUtf8(notExistingId))
                .build();

        StatusRuntimeException exception = assertThrows(StatusRuntimeException.class, () -> museumStub.getMuseum(request));

        assertEquals(Status.NOT_FOUND.getCode(), exception.getStatus().getCode());
        assertEquals("Museum not found by id: " + notExistingId, exception.getStatus().getDescription());
    }

    @Test
    @Museum
    @DisplayName("GRPC: Фильтрация списка музеев по названию")
    void filterByTitleTest(MuseumJson createdMuseum) {
        String museumTitle = createdMuseum.getTitle();
        AllMuseumRequest request = AllMuseumRequest.newBuilder()
                .setTitle(museumTitle)
                .setPage(0)
                .setSize(10)
                .build();

        MuseumResponse museumResponse = museumStub.getAllMuseum(request).getMuseum(0);

        step("Check museum in response", () -> assertEquals(createdMuseum, fromGrpcMessage(museumResponse)));
    }

    @Test
    @DisplayName("GRPC: Фильтрация списка музеев по названию: результаты отсутствуют")
    void filterByTitleEmptyResultsTest() {
        String museumTitle = randomMuseumTitle();
        AllMuseumRequest request = AllMuseumRequest.newBuilder()
                .setTitle(museumTitle)
                .setPage(0)
                .setSize(10)
                .build();

        AllMuseumResponse response = museumStub.getAllMuseum(request);

        step("Проверить, что в ответе получен пустой список", () -> {
            assertEquals(0, response.getMuseumList().size());
            assertEquals(0, response.getTotalCount());
        });
    }

    @Test
    @DisplayName("GRPC: Создание нового музея в rococo-museum")
    void addNewMuseumTest() {
        String title = randomMuseumTitle();
        String description = randomSentence(30);
        Geo geo = Geo.newBuilder()
                .setCity(getRandomCityName())
                .setCountry(CountryId.newBuilder().setId(copyFromUtf8(getRandomCountry().id().toString())))
                .build();

        AddMuseumRequest addMuseumRequest = AddMuseumRequest.newBuilder()
                .setTitle(title)
                .setDescription(description)
                .setPhoto(copyFromUtf8(convertImageToBase64(MUSEUM_IMAGE_PATH)))
                .setGeo(geo)
                .build();

        MuseumResponse response = museumStub.addMuseum(addMuseumRequest);

        step("Проверить, что в ответе получен id созданного музея", () ->
                assertTrue(response.getId().toStringUtf8().matches(ID_REGEXP))
        );
    }

    @Test
    @Museum
    @DisplayName("GRPC: Обновление музея в rococo-museum")
    void updateMuseumTest(MuseumJson createdMuseum) {
        String newTitle = randomMuseumTitle();
        String newDescription = randomSentence(30);
        Geo newGeo = Geo.newBuilder()
                .setCity(getRandomCityName())
                .setCountry(CountryId.newBuilder().setId(copyFromUtf8(getRandomCountry().id().toString())))
                .build();
        AddMuseumRequest museumData = AddMuseumRequest.newBuilder()
                .setTitle(newTitle)
                .setDescription(newDescription)
                .setPhoto(copyFromUtf8(convertImageToBase64(MUSEUM_IMAGE_PATH_NEW)))
                .setGeo(newGeo)
                .build();

        UpdateMuseumRequest updateMuseumRequest = UpdateMuseumRequest.newBuilder()
                .setId(ByteString.copyFromUtf8(createdMuseum.getId().toString()))
                .setMuseumData(museumData)
                .build();

        MuseumResponse response = museumStub.updateMuseum(updateMuseumRequest);

        step("Проверить, что в ответе получен обновленный id", () ->
                assertEquals(createdMuseum.getId(), fromString(response.getId().toStringUtf8()))
        );
        step("Проверить, что в ответе получен обновленное название", () ->
                assertEquals(newTitle, response.getTitle())
        );
        step("Проверить, что в ответе получен обновленное описание", () ->
                assertEquals(newDescription, response.getDescription())
        );
        step("Проверить, что в ответе получен обновленное расположение", () ->
                assertEquals(newGeo, response.getGeo())
        );
        step("Проверить, что в ответе получен обновленное фото", () ->
                assertEquals(convertImageToBase64(MUSEUM_IMAGE_PATH_NEW), response.getPhoto().toStringUtf8())
        );
    }
}
