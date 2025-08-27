package guru.qa.rococo.jupiter.extension;

import guru.qa.rococo.data.repo.ArtistRepositoryHibernate;
import guru.qa.rococo.data.model.ArtistEntity;
import guru.qa.rococo.jupiter.annotation.Artist;
import guru.qa.rococo.model.ArtistJson;
import guru.qa.rococo.utils.ImageUtil;
import io.qameta.allure.Step;
import org.junit.jupiter.api.extension.*;
import org.junit.platform.commons.support.AnnotationSupport;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

import java.util.Optional;

import static guru.qa.rococo.utils.DefaultData.ARTIST_IMAGE_PATH;
import static guru.qa.rococo.utils.RandomDataUtils.randomArtistBio;
import static guru.qa.rococo.utils.RandomDataUtils.randomArtistName;

@ParametersAreNonnullByDefault
public class ArtistExtension implements BeforeEachCallback, ParameterResolver {

    public static final ExtensionContext.Namespace NAMESPACE = ExtensionContext.Namespace.create(ArtistExtension.class);
    private final ArtistRepositoryHibernate artistRepository = new ArtistRepositoryHibernate();

    @Override
    @Step("<БД> Создать художника")
    public void beforeEach(ExtensionContext context) throws Exception {
        AnnotationSupport.findAnnotation(context.getRequiredTestMethod(), Artist.class)
                .ifPresent(artistAnno -> {
                    final String name = "".equals(artistAnno.name()) ?
                            randomArtistName() : artistAnno.name();
                    final String bio = "".equals(artistAnno.bio()) ?
                            randomArtistBio() : artistAnno.bio();
                    String photoBase64 = ImageUtil.convertImageToBase64(ARTIST_IMAGE_PATH);
                    ArtistEntity artist = new ArtistEntity();
                    artist.setName(name);
                    artist.setBiography(bio);
                    artist.setPhoto(photoBase64.getBytes());

                    artistRepository.createArtist(artist);
                    setArtist(ArtistJson.fromEntity(artist));
                });
    }

    @Override
    public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        return parameterContext.getParameter().getType().isAssignableFrom(ArtistJson.class);
    }

    @Override
    public ArtistJson resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        return getArtist();
    }

    @Nullable
    public static ArtistJson getArtist() {
        final ExtensionContext context = TestMethodContextExtension.context();
        return context.getStore(NAMESPACE).get(
                context.getUniqueId(), ArtistJson.class
        );
    }

    public static void setArtist(ArtistJson artist) {
        final ExtensionContext context = TestMethodContextExtension.context();
        context.getStore(NAMESPACE).put(
                context.getUniqueId(),
                artist
        );
    }
}
