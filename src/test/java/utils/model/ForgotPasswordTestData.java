package utils.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Test data model for Forgot Password feature.
 */
public record ForgotPasswordTestData(

        @JsonProperty("email") String email,
        @JsonProperty("oldPassword") String oldPassword,
        @JsonProperty("newPassword") String newPassword,
        @JsonProperty("otp") String otp,
        @JsonProperty("shouldReset") boolean shouldReset,
        @JsonProperty("story") String story,
        @JsonProperty("description") String description
) {}
