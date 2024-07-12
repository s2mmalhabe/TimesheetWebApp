package com.example.Timesheet.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Data
@Configuration
@ConfigurationProperties(prefix = "application", ignoreUnknownFields = false)
public class ApplicationProperties {
    private CORS cors;
    private JWT jwt;

    @Data
    public static class CORS {
        private List<String> allowedOrigins;
        private List<String> allowedMethods;
        private List<String> allowedHeaders;
        private List<String> exposedHeaders;
        private boolean allowCredentials;
        private String[] authorizedPaths;
    }

    @Data
    public static class JWT {
        private String secret;
        private long expirationInMinutes;
        private String header;
        private String bearer;
    }
}
