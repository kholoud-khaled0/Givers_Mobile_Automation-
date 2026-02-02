package utils.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import utils.common.CommunityType;

public record CommunityTestData(

        @JsonProperty("email")
        String email,

        @JsonProperty("password")
        String password,

        @JsonProperty("communityName")
        String communityName,

        @JsonProperty("giverId")
        String giverId,

        @JsonProperty("expectedType")
        String expectedType,

        @JsonProperty("otp")
        String otp,

        @JsonProperty("secondEmail")
        String secondEmail,

        @JsonProperty("secondPassword")
        String secondPassword,

        @JsonProperty("story")
        String story,

        @JsonProperty("description")
        String description,

        @JsonProperty("scenarioType")
        String scenarioType



        ) {

        // 🔹 Mapper method
        public CommunityType getCommunityType() {

                if (expectedType == null) {
                        throw new IllegalStateException("expectedType is null in test data");
                }

                return switch (expectedType.trim().toLowerCase()) {

                        case "created by givers" ->
                                CommunityType.CREATED_BY_GIVERS;

                        case "official community" ->
                                CommunityType.OFFICIAL;

                        default ->
                                throw new IllegalArgumentException(
                                        "Unknown community type: " + expectedType
                                );
                };
        }
}
