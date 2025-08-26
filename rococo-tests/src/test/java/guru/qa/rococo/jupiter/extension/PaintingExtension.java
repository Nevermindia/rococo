package guru.qa.rococo.jupiter.extension;

import guru.qa.rococo.data.model.PaintingEntity;
import guru.qa.rococo.data.repo.PaintingRepositoryHibernate;
import guru.qa.rococo.jupiter.annotation.Artist;
import guru.qa.rococo.jupiter.annotation.Museum;
import guru.qa.rococo.jupiter.annotation.Painting;
import guru.qa.rococo.model.ArtistJson;
import guru.qa.rococo.model.MuseumJson;
import guru.qa.rococo.model.PaintingJson;
import guru.qa.rococo.utils.ImageUtil;
import io.qameta.allure.Step;
import org.junit.jupiter.api.extension.*;
import org.junit.platform.commons.support.AnnotationSupport;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

import static guru.qa.rococo.utils.DefaultData.PAINTING_IMAGE_PATH;
import static guru.qa.rococo.utils.RandomDataUtils.randomPaintingDescription;
import static guru.qa.rococo.utils.RandomDataUtils.randomPaintingName;

@ParametersAreNonnullByDefault
public class PaintingExtension implements BeforeEachCallback, ParameterResolver, AfterEachCallback {

    public static final ExtensionContext.Namespace NAMESPACE = ExtensionContext.Namespace.create(PaintingExtension.class);
    private final PaintingRepositoryHibernate paintingRepository = new PaintingRepositoryHibernate();

    @Override
    @Step("<БД> Создать картину")
    public void beforeEach(ExtensionContext context) throws Exception {
        AnnotationSupport.findAnnotation(context.getRequiredTestMethod(), Painting.class)
                .ifPresent(paintingAnno -> {

                    if (AnnotationSupport.findAnnotation(context.getRequiredTestMethod(), Museum.class).isEmpty()) {
                        throw new IllegalStateException("@Museum should be present in case of @Painting");
                    }

                    if (AnnotationSupport.findAnnotation(context.getRequiredTestMethod(), Artist.class).isEmpty()) {
                        throw new IllegalStateException("@Artist should be present in case of @Painting");
                    }

                    final String title = "".equals(paintingAnno.title()) ?
                            randomPaintingName() : paintingAnno.title();
                    final String description = "".equals(paintingAnno.description()) ?
                            randomPaintingDescription() : paintingAnno.description();
                    final String path = "".equals(paintingAnno.path()) ?
                            PAINTING_IMAGE_PATH : paintingAnno.path();
                    final MuseumJson museum = MuseumExtension.getMuseum();
                    final ArtistJson artist = ArtistExtension.getArtist();
                    String photoBase64 = ImageUtil.convertImageToBase64(path);
                    PaintingEntity painting = new PaintingEntity();
                    painting.setTitle(title);
                    painting.setDescription(description);
                    painting.setContent(photoBase64.getBytes());
                    painting.setMuseumId(museum.getId());
                    painting.setArtistId(artist.getId());

                    paintingRepository.createPainting(painting);

                    context.getStore(NAMESPACE).put(context.getUniqueId(), PaintingJson.fromEntity(painting));
                });
    }

    @Override
    @Step("<БД> Удалить картину")
    public void afterEach(ExtensionContext context) throws Exception {
        AnnotationSupport.findAnnotation(context.getRequiredTestMethod(), Painting.class)
                .ifPresent(paintingAnno -> paintingRepository.deletePaintingById(getPainting().getId()));
    }

    @Nullable
    public static PaintingJson getPainting() {
        final ExtensionContext context = TestMethodContextExtension.context();
        return context.getStore(NAMESPACE).get(
                context.getUniqueId(), PaintingJson.class
        );
    }

    @Override
    public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        return parameterContext.getParameter().getType().isAssignableFrom(PaintingJson.class);
    }

    @Override
    public PaintingJson resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        return extensionContext.getStore(NAMESPACE).get(extensionContext.getUniqueId(), PaintingJson.class);
    }
}
