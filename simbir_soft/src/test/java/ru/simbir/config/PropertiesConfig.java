package ru.simbir.config;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;


@Data
@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(ignoreInvalidFields = true)
@PropertySources({
        @PropertySource(value = "classpath:properties/application-jdbc.properties"),
        @PropertySource(value = "classpath:properties/application-var.properties"),
        @PropertySource(value = "classpath:properties/application-${spring.profiles.active}.properties", ignoreResourceNotFound = true)
})
public class PropertiesConfig {

    private Web web;
    private DataBase dataBase;
    private Variable variable;


    @Data
    public static class Web {
        private String baseurl;
        private String logoutUrl;
        private String token;


    }

    @Data
    public static class DataBase {
        private String url;
        private String name;
        private String password;
        private String driver;
    }

    @Data
    public static class Variable {
        private String token;
    }

}
