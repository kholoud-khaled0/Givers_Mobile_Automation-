package utils.common;

import com.fasterxml.jackson.annotation.JsonProperty;

public record DocumentData(
        @JsonProperty("documentName") String documentName,
        @JsonProperty("dropdownValue") String dropdownValue
) {}
