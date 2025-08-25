package guru.qa.rococo.tests.grpc;

import guru.qa.grpc.rococo.grpc.*;
import guru.qa.rococo.jupiter.annotation.Artist;
import guru.qa.rococo.jupiter.annotation.Museum;
import guru.qa.rococo.jupiter.annotation.Painting;
import guru.qa.rococo.model.ArtistJson;
import guru.qa.rococo.model.MuseumJson;
import guru.qa.rococo.model.PaintingJson;
import io.grpc.Channel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import io.qameta.allure.grpc.AllureGrpc;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static com.google.protobuf.ByteString.copyFromUtf8;
import static guru.qa.rococo.model.PaintingJson.fromGrpcMessage;
import static guru.qa.rococo.utils.DefaultData.PAINTING_IMAGE_PATH;
import static guru.qa.rococo.utils.DefaultData.PAINTING_IMAGE_PATH_NEW;
import static guru.qa.rococo.utils.ImageUtil.convertImageToBase64;
import static guru.qa.rococo.utils.RandomDataUtils.randomPaintingName;
import static guru.qa.rococo.utils.RandomDataUtils.randomSentence;
import static io.qameta.allure.Allure.step;
import static java.util.UUID.fromString;
import static java.util.UUID.randomUUID;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("GRPC: Картины")
public class PaintingGrpcTest extends BaseGrpcTest {

    private static final Channel paintingChannel;

    static {
        paintingChannel = ManagedChannelBuilder
                .forAddress(CFG.paintingGrpcAddress(), CFG.paintingGrpcPort())
                .intercept(new AllureGrpc())
                .usePlaintext()
                .build();
    }

    protected final RococoPaintingServiceGrpc.RococoPaintingServiceBlockingStub paintingStub = RococoPaintingServiceGrpc.newBlockingStub(paintingChannel);

    @Test
    @DisplayName("GRPC: Получение информации о картине из rococo-painting")
    @Museum
    @Artist
    @Painting
    void getArtistDataTest(PaintingJson createdPainting) {
        String createdPaintingId = createdPainting.getId().toString();
        PaintingRequest request = PaintingRequest.newBuilder()
                .setId(copyFromUtf8(createdPaintingId))
                .build();

        PaintingResponse paintingResponse = paintingStub.getPainting(request);

        step("Проверить ответ", () -> assertEquals(createdPainting, fromGrpcMessage(paintingResponse)));
    }

    @Test
    @DisplayName("GRPC: Ошибка при запросе картины из rococo-painting по несуществующему ID")
    void notExistingPaintingIdErrorTest() {
        String notExistingId = randomUUID().toString();
        PaintingRequest request = PaintingRequest.newBuilder()
                .setId(copyFromUtf8(notExistingId))
                .build();

        StatusRuntimeException exception = assertThrows(StatusRuntimeException.class, () -> paintingStub.getPainting(request));

        assertEquals(Status.NOT_FOUND.getCode(), exception.getStatus().getCode());
        assertEquals("Painting not found by id: " + notExistingId, exception.getStatus().getDescription());
    }

    @Test
    @Museum
    @Artist
    @Painting
    @DisplayName("GRPC: Фильтрация списка картин по названию")
    void filterByTitleTest(PaintingJson createdPainting) {
        String paintingTitle = createdPainting.getTitle();
        AllPaintingRequest request = AllPaintingRequest.newBuilder()
                .setTitle(paintingTitle)
                .setPage(0)
                .setSize(10)
                .build();

        final PaintingResponse paintingResponse = paintingStub.getAllPainting(request).getPainting(0);

        step("Проверить ответ", () -> assertEquals(createdPainting, fromGrpcMessage(paintingResponse)));
    }

    @Test
    @DisplayName("GRPC: Фильтрация списка картин по названию: результаты отсутствуют")
    void filterByTitleEmptyResultsTest() {
        String paintingTitle = randomPaintingName();
        AllPaintingRequest request = AllPaintingRequest.newBuilder()
                .setTitle(paintingTitle)
                .setPage(0)
                .setSize(10)
                .build();

        AllPaintingResponse response = paintingStub.getAllPainting(request);

        step("Проверить, что в ответе получен пустой список", () -> {
            assertEquals(0, response.getPaintingCount());
            assertEquals(0, response.getTotalCount());
        });
    }

    @Test
    @DisplayName("GRPC: Создание новой картины в rococo-painting")
    @Museum
    @Artist
    void addNewPaintingTest(MuseumJson createdMuseum, ArtistJson createdArtist) {
        String title = randomPaintingName();
        String description = randomSentence(30);

        AddPaintingRequest addPaintingRequest = AddPaintingRequest.newBuilder()
                .setTitle(title)
                .setDescription(description)
                .setContent(copyFromUtf8(convertImageToBase64(PAINTING_IMAGE_PATH)))
                .setArtistId(ArtistId.newBuilder().setId(copyFromUtf8(createdArtist.getId().toString())))
                .setMuseumId(MuseumId.newBuilder().setId(copyFromUtf8(createdMuseum.getId().toString())))
                .build();

        final PaintingResponse response = paintingStub.addPainting(addPaintingRequest);

        step("Проверить, что в ответе содержится id созданной картины", () ->
                assertTrue(response.getId().toStringUtf8().matches(ID_REGEXP))
        );
    }

    @Test
    @DisplayName("GRPC: Обновление картины в rococo-artist")
    @Museum
    @Artist
    @Painting
    void updatePaintingTest(PaintingJson createdPainting, MuseumJson createdMuseum, ArtistJson createdArtist) {
        String newTitle = randomPaintingName();
        String newDescription = randomSentence(30);

        AddPaintingRequest paintingData = AddPaintingRequest.newBuilder()
                .setTitle(newTitle)
                .setDescription(newDescription)
                .setContent(copyFromUtf8(convertImageToBase64(PAINTING_IMAGE_PATH_NEW)))
                .setArtistId(ArtistId.newBuilder().setId(copyFromUtf8(createdArtist.getId().toString())))
                .setMuseumId(MuseumId.newBuilder().setId(copyFromUtf8(createdMuseum.getId().toString())))
                .build();

        UpdatePaintingRequest updatePaintingRequest = UpdatePaintingRequest.newBuilder()
                .setId(copyFromUtf8(createdPainting.getId().toString()))
                .setPaintingData(paintingData)
                .build();

        final PaintingResponse response = paintingStub.updatePainting(updatePaintingRequest);

        step("Проверить, что в ответе получен обновленный id", () ->
                assertEquals(createdPainting.getId(), fromString(response.getId().toStringUtf8()))
        );
        step("Проверить, что в ответе получен обновленное название", () ->
                assertEquals(newTitle, response.getTitle())
        );
        step("Проверить, что в ответе получен обновленное описание", () ->
                assertEquals(newDescription, response.getDescription())
        );
        step("Проверить, что в ответе получен обновленное фото", () ->
                assertEquals(convertImageToBase64(PAINTING_IMAGE_PATH_NEW), response.getContent().toStringUtf8())
        );
        step("Проверить, что в ответе получен обновленное id художника", () ->
                assertEquals(createdArtist.getId(), UUID.fromString(response.getArtistId().getId().toStringUtf8()))
        );
        step("Проверить, что в ответе получен обновленное id музея", () ->
                assertEquals(createdMuseum.getId(), UUID.fromString(response.getMuseumId().getId().toStringUtf8()))
        );
    }
}
