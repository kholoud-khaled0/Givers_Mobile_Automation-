package utils.common;

import java.util.Map;

public class MaritalStatusConfig {

    public static final Map<String, String> EXTRA_DOCUMENT_BY_STATUS = Map.of(
            "married", "marriage-certificate-uploader",
            "divorced", "divorce-certificate-uploader",
            "widowed", "death-certificate-uploader",
            "abandoned", "abandonment-certificate-uploader",
            "spouse in prison", "prison-certificate-uploader"
    );
}
