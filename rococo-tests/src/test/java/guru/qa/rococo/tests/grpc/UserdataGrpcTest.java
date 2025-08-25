package guru.qa.rococo.tests.grpc;

import guru.qa.grpc.rococo.grpc.RococoUserdataServiceGrpc;
import guru.qa.grpc.rococo.grpc.UpdateUserRequest;
import guru.qa.grpc.rococo.grpc.UserRequest;
import guru.qa.grpc.rococo.grpc.UserResponse;
import guru.qa.rococo.jupiter.annotation.User;
import guru.qa.rococo.model.UserJson;
import io.grpc.Channel;
import io.grpc.ManagedChannelBuilder;
import io.qameta.allure.grpc.AllureGrpc;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.google.protobuf.ByteString.copyFromUtf8;
import static guru.qa.rococo.utils.DefaultData.PROFILE_IMAGE_PATH;
import static guru.qa.rococo.utils.ImageUtil.convertImageToBase64;
import static guru.qa.rococo.utils.RandomDataUtils.randomName;
import static guru.qa.rococo.utils.RandomDataUtils.randomSurname;
import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("GRPC: Данные пользователя")
public class UserdataGrpcTest extends BaseGrpcTest {
    private static final Channel userdataChannel;

    static {
        userdataChannel = ManagedChannelBuilder
                .forAddress(CFG.userdataGrpcAddress(), CFG.userdataGrpcPort())
                .intercept(new AllureGrpc())
                .usePlaintext()
                .build();
    }

    private final RococoUserdataServiceGrpc.RococoUserdataServiceBlockingStub userdataStub = RococoUserdataServiceGrpc.newBlockingStub(userdataChannel);

    @Test
    @DisplayName("GRPC: Для нового пользователя должна возвращаться информация из rococo-userdata c пустыми значениями")
    @User
    void getUserdataForNewUserTest(UserJson createdUser) {
        UserRequest userRequest = UserRequest.newBuilder()
                .setUsername(createdUser.username())
                .build();
        UserResponse currentUserResponse = userdataStub.getUser(userRequest);

        step("Проверить, что в ответе содержится ID", () ->
                assertTrue(currentUserResponse.getId().matches(ID_REGEXP))
        );
        step("Проверить, что в ответе содержится никнейм", () ->
                assertEquals(createdUser.username(), currentUserResponse.getUsername())
        );
        step("Проверить, что в ответе не содержится имя", () ->
                assertTrue(currentUserResponse.getFirstname().isEmpty())
        );
        step("Проверить, что в ответе не содержится фамилия", () ->
                assertTrue(currentUserResponse.getLastname().isEmpty())
        );
        step("Проверить, что в ответе не содержится аватар", () ->
                assertTrue(currentUserResponse.getAvatar().toStringUtf8().isEmpty())
        );
    }

    @Test
    @DisplayName("GRPC: Обновление пользователя в rococo-userdata")
    @User
    void updateUserTest(UserJson createdUser) {
        UserRequest userRequest = UserRequest.newBuilder()
                .setUsername(createdUser.username())
                .build();
        UserResponse user = userdataStub.getUser(userRequest);
        String firstname = randomName();
        String lastname = randomSurname();


        UpdateUserRequest updateUserRequest = UpdateUserRequest.newBuilder()
                .setId(user.getId())
                .setUsername(createdUser.username())
                .setFirstname(firstname)
                .setLastname(lastname)
                .setAvatar(copyFromUtf8(convertImageToBase64(PROFILE_IMAGE_PATH)))
                .build();

        UserResponse response = userdataStub.updateUser(updateUserRequest);

        step("Проверить, что в ответе содержится id", () ->
                assertEquals(user.getId(), response.getId())
        );
        step("Проверить, что в ответе содержится имя", () ->
                assertEquals(firstname, response.getFirstname())
        );
        step("Проверить, что в ответе содержится фамилия", () ->
                assertEquals(lastname, response.getLastname())
        );
        step("Проверить, что в ответе содержится фото", () ->
                assertEquals(convertImageToBase64(PROFILE_IMAGE_PATH), response.getAvatar().toStringUtf8())
        );
    }
}
