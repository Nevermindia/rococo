package guru.qa.rococo.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonInclude;
import guru.qa.grpc.rococo.grpc.UserResponse;
import guru.qa.rococo.data.model.AuthUserEntity;

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

    public static UserJson fromEntity(AuthUserEntity entity) {
        return new UserJson(
                entity.getId(),
                entity.getUsername(),
                null,
                null,
                null,
                new TestData(entity.getEncodedPassword())
        );
    }
}