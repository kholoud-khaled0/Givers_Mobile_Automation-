package utils.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public record EasyGiveTestData(
        @JsonProperty("email") String email,
        @JsonProperty("password") String password,
        @JsonProperty("story") String story,
        @JsonProperty("description") String description)
{}
