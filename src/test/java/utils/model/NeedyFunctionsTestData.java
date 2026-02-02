package utils.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public record NeedyFunctionsTestData(
        @JsonProperty("email") String email,
        @JsonProperty("password") String password,
        @JsonProperty("dropDownValues") List<String> dropDownValues,
        @JsonProperty("state") String state,
        @JsonProperty("city") String city,
        @JsonProperty("gender") String gender,
        @JsonProperty("dropDownName") String dropDownName,
        @JsonProperty("needySituation") String needySituation,
        @JsonProperty("employmentStatus") String employmentStatus,
        @JsonProperty("housingStatus") String housingStatus,
        @JsonProperty("healthCondition") String healthCondition
) {}
