package guru.qa.rococo.api.grpc;

import com.github.javafaker.Artist;
import com.google.protobuf.ByteString;
import guru.qa.grpc.rococo.grpc.*;
import guru.qa.rococo.model.ArtistJson;
import io.qameta.allure.Step;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.Base64;
import java.util.List;


@ParametersAreNonnullByDefault
public class ArtistGrpcClient extends GrpcClient {

    public ArtistGrpcClient() {
        super(CFG.artistGrpcAddress(), CFG.artistGrpcPort());
    }

    private final RococoArtistServiceGrpc.RococoArtistServiceBlockingStub artistStub =
            RococoArtistServiceGrpc.newBlockingStub(channel);



    @Step("Add new artist with Artist Grpc service")
    public @Nonnull ArtistJson addArtist(@Nonnull ArtistJson artistJson) {
        byte[] photoBytes = convertDataUrlToBytes(artistJson.getPhoto());
        return ArtistJson.fromGrpcMessage(
                artistStub.addArtist(
                        AddArtistRequest.newBuilder()
                                .setName(artistJson.getName())
                                .setBiography(artistJson.getBiography())
                                .setPhoto(ByteString.copyFrom(photoBytes))
                                .build()
                ));
    }

    private byte[] convertDataUrlToBytes(String dataUrl) {
        if (dataUrl == null || dataUrl.isEmpty()) {
            return new byte[0];
        }

        // Извлекаем чистую base64 часть из Data URL
        String base64Data;
        if (dataUrl.startsWith("data:")) {
            int base64Index = dataUrl.indexOf("base64,");
            if (base64Index > 0) {
                base64Data = dataUrl.substring(base64Index + 7); // +7 чтобы пропустить "base64,"
            } else {
                // Если нет "base64,", но есть запятая
                int commaIndex = dataUrl.indexOf(",");
                if (commaIndex > 0) {
                    base64Data = dataUrl.substring(commaIndex + 1);
                } else {
                    base64Data = dataUrl;
                }
            }
        } else {
            base64Data = dataUrl;
        }

        // Декодируем base64 в байты
        return Base64.getDecoder().decode(base64Data);
    }

    @Step("Update an artist with Artist Grpc service")
    public @Nonnull ArtistJson updateArtist(@Nonnull ArtistJson artistJson) {
        byte[] photoBytes = convertDataUrlToBytes(artistJson.getPhoto());
        return ArtistJson.fromGrpcMessage(
                artistStub.updateArtist(
                        UpdateArtistRequest.newBuilder()
                                .setId(String.valueOf(artistJson.getId()))
                                .setArtistData(AddArtistRequest.newBuilder()
                                        .setName(artistJson.getName())
                                        .setBiography(artistJson.getBiography())
                                        .setPhoto(ByteString.copyFrom(photoBytes))
                                ).build()));
    }

    @Step("Find artist by ID with Artist Grpc service")
    public @Nonnull ArtistJson getArtist(@Nonnull String artistId) {
        return ArtistJson.fromGrpcMessage(
                artistStub.getArtist(
                        ArtistRequest.newBuilder()
                                .setId(artistId)
                                .build()
                )
        );
    }

    @Step("Get all artists with rococo-artist Grpc service")
    public @Nonnull List<ArtistJson> getAll(int page, int size, @Nullable String name) {
        AllArtistResponse response = artistStub.getAllArtist(
                AllArtistRequest.newBuilder()
                        .setName(name == null ? "" : name)
                        .setPage(page)
                        .setSize(size)
                        .build()
        );

        return response.getArtistsList()
                .stream()
                .map(ArtistJson::fromGrpcMessage)
                .toList();
    }
}
