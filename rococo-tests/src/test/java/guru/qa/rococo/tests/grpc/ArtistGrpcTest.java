package guru.qa.rococo.tests.grpc;

import guru.qa.grpc.rococo.grpc.*;
import guru.qa.rococo.jupiter.annotation.Artist;
import guru.qa.rococo.model.ArtistJson;
import io.grpc.Channel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import io.qameta.allure.grpc.AllureGrpc;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static com.google.protobuf.ByteString.copyFromUtf8;
import static guru.qa.rococo.model.ArtistJson.fromGrpcMessage;
import static guru.qa.rococo.utils.DefaultData.ARTIST_IMAGE_PATH;
import static guru.qa.rococo.utils.ImageUtil.convertImageToBase64;
import static guru.qa.rococo.utils.RandomDataUtils.*;
import static io.qameta.allure.Allure.step;
import static java.util.UUID.fromString;
import static org.junit.jupiter.api.Assertions.*;

public class ArtistGrpcTest extends BaseGrpcTest {

    private static final Channel artistChannel;

    static {
        artistChannel = ManagedChannelBuilder
                .forAddress(CFG.artistGrpcAddress(), CFG.artistGrpcPort())
                .intercept(new AllureGrpc())
                .usePlaintext()
                .build();
    }

    private final RococoArtistServiceGrpc.RococoArtistServiceBlockingStub artistStub = RococoArtistServiceGrpc.newBlockingStub(artistChannel);

    @Test
    @DisplayName("GRPC: Получение информации о художнике из rococo-artist")
    @Artist
    void returnArtistDataFromDBTest(ArtistJson createdArtist) {
        String createdArtistId = createdArtist.getId().toString();
        ArtistRequest request = ArtistRequest.newBuilder()
                .setId(createdArtistId)
                .build();

        ArtistResponse artistResponse = artistStub.getArtist(request);

        step("Проверить ответ", () -> assertEquals(createdArtist, fromGrpcMessage(artistResponse)));
    }

    @Test
    @DisplayName("GRPC: Ошибка при запросе художника из rococo-artist по несуществующему ID")
    void notExistingArtistIdErrorTest() {
        String notExistingId = UUID.randomUUID().toString();
        ArtistRequest request = ArtistRequest.newBuilder()
                .setId(notExistingId)
                .build();

        StatusRuntimeException exception = assertThrows(StatusRuntimeException.class, () -> artistStub.getArtist(request));

        assertEquals(Status.NOT_FOUND.getCode(), exception.getStatus().getCode());
        assertEquals("Artist not found by id: " + notExistingId, exception.getStatus().getDescription());
    }

    @Test
    @Artist
    @DisplayName("GRPC: Фильтрация списка художников по имени")
    void filterArtistByNameTest(ArtistJson createdArtist) {
        String artistName = createdArtist.getName();
        AllArtistRequest request = AllArtistRequest.newBuilder()
                .setName(artistName)
                .setPage(0)
                .setSize(10)
                .build();

        ArtistResponse artistResponse = artistStub.getAllArtist(request).getArtists(0);

        step("Проверить ответ", () -> assertEquals(createdArtist, fromGrpcMessage(artistResponse)));
    }

    @Test
    @DisplayName("GRPC: Фильтрация списка художников по имени: результаты отсутствуют")
    void filterArtistByNameEmptySearchResult() {
        String artistName = randomName();
        AllArtistRequest request = AllArtistRequest.newBuilder()
                .setName(artistName)
                .setPage(0)
                .setSize(10)
                .build();

        AllArtistResponse response = artistStub.getAllArtist(request);

        step("Проверить, что вернулся пустой ответ", () -> {
            assertEquals(0, response.getArtistsList().size());
            assertEquals(0, response.getTotalCount());
        });
    }

    @Test
    @DisplayName("GRPC: Создание нового художника в rococo-artist")
    void addNewArtistTest() {
        String name = randomName();
        String biography = randomSentence(30);

        AddArtistRequest addArtistRequest = AddArtistRequest.newBuilder()
                .setName(name)
                .setBiography(biography)
                .setPhoto(copyFromUtf8(convertImageToBase64(ARTIST_IMAGE_PATH)))
                .build();

        ArtistResponse response = artistStub.addArtist(addArtistRequest);

        step("Проверить, что в ответе вернулся id созданного художника", () ->
                assertTrue(response.getId().matches(ID_REGEXP))
        );
    }

    @Test
    @Artist
    @DisplayName("GRPC: Обновление художника в rococo-artist")
    void updateArtistTest(ArtistJson createdArtist) {
        String newName = randomMuseumTitle();
        String newBiography = randomSentence(30);

        AddArtistRequest artistData = AddArtistRequest.newBuilder()
                .setName(newName)
                .setBiography(newBiography)
                .setPhoto(copyFromUtf8(convertImageToBase64(ARTIST_IMAGE_PATH)))
                .build();


        UpdateArtistRequest updateArtistRequest = UpdateArtistRequest.newBuilder()
                .setId(createdArtist.getId().toString())
                .setArtistData(artistData)
                .build();

        ArtistResponse response = artistStub.updateArtist(updateArtistRequest);

        step("Проверить, что в ответе получен обновленный id", () ->
                assertEquals(createdArtist.getId(), fromString(response.getId()))
        );
        step("Проверить, что в ответе получен обновленное имя", () ->
                assertEquals(newName, response.getName())
        );
        step("Проверить, что в ответе получен обновленная биография", () ->
                assertEquals(newBiography, response.getBiography())
        );
        step("Проверить, что в ответе получен обновленное фото", () ->
                assertEquals(convertImageToBase64(ARTIST_IMAGE_PATH), response.getPhoto().toStringUtf8())
        );
    }
}