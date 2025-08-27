package guru.qa.rococo.jupiter.extension;

import guru.qa.rococo.data.model.MuseumEntity;
import guru.qa.rococo.data.repo.GeoRepositoryHibernate;
import guru.qa.rococo.data.repo.MuseumRepositoryHibernate;
import guru.qa.rococo.jupiter.annotation.Museum;
import guru.qa.rococo.model.MuseumJson;
import guru.qa.rococo.utils.ImageUtil;
import io.qameta.allure.Step;
import org.junit.jupiter.api.extension.*;
import org.junit.platform.commons.support.AnnotationSupport;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.UUID;

import static guru.qa.rococo.model.Countries.RUSSIA;
import static guru.qa.rococo.utils.DefaultData.CITY;
import static guru.qa.rococo.utils.DefaultData.MUSEUM_IMAGE_PATH;
import static guru.qa.rococo.utils.RandomDataUtils.randomMuseumDescription;
import static guru.qa.rococo.utils.RandomDataUtils.randomMuseumTitle;


@ParametersAreNonnullByDefault
public class MuseumExtension implements BeforeEachCallback, ParameterResolver {

    public static final ExtensionContext.Namespace NAMESPACE = ExtensionContext.Namespace.create(MuseumExtension.class);
    private final MuseumRepositoryHibernate museumRepository = new MuseumRepositoryHibernate();
    private final GeoRepositoryHibernate geoRepository = new GeoRepositoryHibernate();

    @Override
    @Step("<БД> Создать музей")
    public void beforeEach(ExtensionContext context) throws Exception {
        AnnotationSupport.findAnnotation(context.getRequiredTestMethod(), Museum.class)
                .ifPresent(museumAnno -> {
                    final String title = "".equals(museumAnno.title()) ?
                            randomMuseumTitle() : museumAnno.title();
                    final String description = "".equals(museumAnno.description()) ?
                            randomMuseumDescription() : museumAnno.description();
                    final String photoPath = "".equals(museumAnno.path()) ?
                            MUSEUM_IMAGE_PATH : museumAnno.path();
                    final String city = "".equals(museumAnno.city()) ?
                            CITY : museumAnno.city();
                    final UUID countryId = RUSSIA.equals(museumAnno.country()) ?
                            geoRepository.getCountryByName(RUSSIA.getName()).getId()
                            : geoRepository.getCountryByName(museumAnno.country().getName()).getId();
                    String photoBase64 = ImageUtil.convertImageToBase64(photoPath);
                    MuseumEntity museum = new MuseumEntity();
                    museum.setTitle(title);
                    museum.setDescription(description);
                    museum.setCity(city);
                    museum.setPhoto(photoBase64.getBytes());
                    museum.setGeoId(countryId);

                    MuseumEntity museumForTest = museumRepository.createMuseum(museum);
                    museum.setId(museumForTest.getId());
                    setMuseum(MuseumJson.fromEntity(museum));
                });
    }

    @Override
    public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        return parameterContext.getParameter().getType().isAssignableFrom(MuseumJson.class);
    }

    @Override
    public MuseumJson resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        return getMuseum();
    }

    public static void setMuseum(MuseumJson museum) {
        ExtensionContext context = TestMethodContextExtension.context();
        context.getStore(NAMESPACE).put(
                context.getUniqueId(),
                museum
        );
    }

    @Nullable
    public static MuseumJson getMuseum() {
        ExtensionContext context = TestMethodContextExtension.context();
        return context.getStore(NAMESPACE).get(
                context.getUniqueId(), MuseumJson.class
        );
    }
}
