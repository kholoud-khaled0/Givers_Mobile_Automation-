package utils.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Test data model for Reset Password Feature.
 * Compatible with Jackson for JSON mapping.
 */
public record ResetPasswordTestData(

        @JsonProperty("email")
        String email,

        @JsonProperty("oldPassword")
        String oldPassword,

        @JsonProperty("newPassword")
        String newPassword,

        @JsonProperty("shouldReset")
        boolean shouldReset,

        @JsonProperty("story")
        String story,

        @JsonProperty("description")
        String description
) {}
