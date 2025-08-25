package guru.qa.rococo.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonInclude;
import guru.qa.grpc.rococo.grpc.UserResponse;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record UserJson(
        @Nullable
        @JsonProperty("id")
        UUID id,
        @JsonProperty("username")
        String username,
        @JsonProperty("firstname")
        String firstname,
        @JsonProperty("lastname")
        String lastname,
        @JsonProperty("avatar")
        byte[] avatar,
        @JsonIgnore
        TestData testData
) {

    public @Nonnull UserJson addTestData(@Nonnull TestData testData) {
        return new UserJson(
                id, username, firstname, lastname, avatar, testData
        );
    }

    public static @Nonnull UserJson fromGrpc(@Nonnull UserResponse user) {
        return new UserJson(
                user.getId().isEmpty() ? null : UUID.fromString(user.getId()),
                user.getUsername(),
                user.getFirstname(),
                user.getLastname(),
                user.getAvatar().toByteArray(),
                null
        );
    }
}