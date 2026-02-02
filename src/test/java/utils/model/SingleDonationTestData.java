package utils.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public record SingleDonationTestData(
        @JsonProperty("email") String email,
        @JsonProperty("password") String password
) {}
