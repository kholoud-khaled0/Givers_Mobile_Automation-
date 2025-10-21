package utils.model;


import com.fasterxml.jackson.annotation.JsonProperty;

public record LoginTestData(
        @JsonProperty("email") String email,
        @JsonProperty("password") String password,
        @JsonProperty("shouldLogin") boolean shouldLogin,
        @JsonProperty("story") String story,
        @JsonProperty("description") String description
) {

}
