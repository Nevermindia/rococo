package guru.qa.rococo.jupiter.extension;

import guru.qa.rococo.data.model.AuthUserEntity;
import guru.qa.rococo.data.repo.UserRepositoryHibernate;
import guru.qa.rococo.jupiter.annotation.ApiLogin;
import guru.qa.rococo.jupiter.annotation.User;
import guru.qa.rococo.model.UserJson;
import org.junit.jupiter.api.extension.*;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

import static guru.qa.rococo.data.model.AuthUserEntity.fillAuthUserEntity;
import static guru.qa.rococo.utils.RandomDataUtils.randomUsername;


@ParametersAreNonnullByDefault
public class UserExtension implements BeforeEachCallback, ParameterResolver {

    public static final ExtensionContext.Namespace NAMESPACE = ExtensionContext.Namespace.create(UserExtension.class);
    private static final String DEFAULT_PW = "12345";

    private final UserRepositoryHibernate userRepositoryHibernate = new UserRepositoryHibernate();

    @Override
    public void beforeEach(ExtensionContext context) throws Exception {
        User userAnnotation = context.getRequiredTestMethod().getAnnotation(User.class);
        ApiLogin apiLoginAnnotation = context.getRequiredTestMethod().getAnnotation(ApiLogin.class);

        if (apiLoginAnnotation != null) {
            final String username = "".equals(apiLoginAnnotation.user().username()) ?
                    randomUsername() : apiLoginAnnotation.user().username();
            createAndSetUser(username);

        } else if (userAnnotation != null) {
            final String username = "".equals(userAnnotation.username()) ?
                    randomUsername() : userAnnotation.username();
            createAndSetUser(username);
        }
    }

    private void createAndSetUser(String username) {
        AuthUserEntity user = fillAuthUserEntity(username, DEFAULT_PW);
        userRepositoryHibernate.createUser(user);
        setUser(UserJson.fromEntity(user));
    }

    @Override
    public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        return parameterContext.getParameter().getType().isAssignableFrom(UserJson.class);
    }

    @Override
    public UserJson resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        return createdUser();
    }

    @Nullable
    public static UserJson createdUser() {
        final ExtensionContext context = TestMethodContextExtension.context();
        return context.getStore(NAMESPACE).get(
                context.getUniqueId(),
                UserJson.class
        );
    }

    public static void setUser(UserJson testUser) {
        final ExtensionContext context = TestMethodContextExtension.context();
        context.getStore(NAMESPACE).put(
                context.getUniqueId(),
                testUser
        );
    }
}
