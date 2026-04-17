package utils.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import utils.common.DocumentData;
import java.util.List;

public record NeedyProfileTestData(

        @JsonProperty("email") String email,
        @JsonProperty("password") String password,

        @JsonProperty("maritalStatus") String maritalStatus,
        @JsonProperty("state") String state,
        @JsonProperty("city") String city,
        @JsonProperty("address") String address,
        @JsonProperty("housingCondition") String housingCondition,

        @JsonProperty("needyDocuments") List<DocumentData> needyDocuments,
        @JsonProperty("memberDocuments") List<DocumentData> memberDocuments,

        @JsonProperty("amount") String amount,
        @JsonProperty("relationShip") String relationShip,
        @JsonProperty("story") String story,
        @JsonProperty("note") String note,

        @JsonProperty("healthStatus") String healthStatus, // Healthy / Chronic disease / Disability
        @JsonProperty("disabilityLevel") String disabilityLevel, // Fully Disabled / Partial Disability
        @JsonProperty("disabilityTypes") List<String> disabilityTypes, // Motion, Mental, ...
        @JsonProperty("chronicDiseaseType") String chronicDiseaseType,
        @JsonProperty("monthlyExpenses") String monthlyExpenses

) {}
