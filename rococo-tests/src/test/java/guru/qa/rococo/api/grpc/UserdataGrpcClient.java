package guru.qa.rococo.api.grpc;

import guru.qa.grpc.rococo.grpc.RococoUserdataServiceGrpc;
import guru.qa.grpc.rococo.grpc.UserRequest;
import guru.qa.rococo.model.UserJson;
import io.qameta.allure.Step;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;

import static guru.qa.rococo.model.UserJson.fromGrpc;

@ParametersAreNonnullByDefault
public class UserdataGrpcClient extends GrpcClient {

    public UserdataGrpcClient() {
        super(CFG.userdataGrpcAddress(), CFG.userdataGrpcPort());
    }

    private final RococoUserdataServiceGrpc.RococoUserdataServiceBlockingStub userdataStub =
            RococoUserdataServiceGrpc.newBlockingStub(channel);


    @Step("Get current user '{0}' from Userdata Grpc service")
    public @Nonnull UserJson getCurrent(@Nonnull String username) {
        return fromGrpc(
                userdataStub.getUser(
                        UserRequest.newBuilder()
                                .setUsername(username)
                                .build()
                        )
        );
    }
}
