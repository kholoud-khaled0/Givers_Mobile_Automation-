package utils.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Test data model for Personal Information Feature.
 */
public record PersonalInformationTestData(

        @JsonProperty("email")
        String email,

        @JsonProperty("password")
        String password,

        @JsonProperty("firstName")
        String firstName,

        @JsonProperty("lastName")
        String lastName,

        @JsonProperty("newEmail")
        String newEmail,

        @JsonProperty("otp")
        String otp,

        @JsonProperty("story")
        String story,

        @JsonProperty("description")
        String description
) {}
