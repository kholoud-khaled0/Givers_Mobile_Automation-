package utils.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public record RegisterTestData(
        @JsonProperty("story") String story,
        @JsonProperty("description") String description,
        @JsonProperty("firstName") String firstName,
        @JsonProperty("lastName") String lastName,
        @JsonProperty("email") String email,
        @JsonProperty("password") String password,
        @JsonProperty("otp") String otp,
        @JsonProperty("shouldRegister") boolean shouldRegister
) {}
