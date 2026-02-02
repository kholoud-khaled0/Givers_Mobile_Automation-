package utils.model;
import com.fasterxml.jackson.annotation.JsonProperty;
/** * Test data model for Forgot Password feature. */
public record NeedyTestData(
        @JsonProperty("email") String email,
        @JsonProperty("password") String password,
        @JsonProperty("ID") String ID,
        @JsonProperty("Name") String Name,
        @JsonProperty("story") String story,
        @JsonProperty("description") String description
) {}