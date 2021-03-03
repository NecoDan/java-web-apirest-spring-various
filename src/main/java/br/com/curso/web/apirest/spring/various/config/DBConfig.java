package br.com.curso.web.apirest.spring.various.config;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

//@Getter
//@Setter
@Slf4j
//@Configuration
//@ConfigurationProperties("spring.datasource")
public class DBConfig {

    private String driverClassName;
    private String url;
    private String username;
    private String password;

    @Profile("dev")
    @Bean
    public String devDataBaseConnection() {
        log.info("DB Connection for DEV - H2");
        log.info(driverClassName);
        log.info(url);
        return "Db Connection to H2_DEV - Dev Instance";
    }

    @Profile("prod")
    @Bean
    public String prodDataBaseConnection() {
        log.info("DB Connection for PROD - PostgreSQL");
        log.info(driverClassName);
        log.info(url);
        return "Db Connection to PostgreSQL_PROD - Production Instance";
    }

    @Profile("dev_codenation_biblioteca")
    @Bean
    public String devCodenationBibliotecaDataBaseConnection() {
        log.info("DB Connection for DEV - PostgreSQL");
        log.info(driverClassName);
        log.info(url);
        return "Db Connection to PostgreSQL_DEV_CODENATION_BIBLIOTECA - Dev Instance";
    }

    @Profile("dev_algaworks_osworks")
    @Bean
    public String devAlgaworksOsworksDataBaseConnection() {
        log.info("DB Connection for DEV - MYSQL");
        log.info(driverClassName);
        log.info(url);
        return "Db Connection to MySQL_ALGAWORKS_OSWORKS - Dev Instance";
    }

    @Profile("dev_dio_webmvc")
    @Bean
    public String devDigitalInnovationOneDataBaseConnection() {
        log.info("DB Connection for DEV - H2 Database");
        log.info(driverClassName);
        log.info(url);
        return "Db Connection to H2 Database_DIGITAL_INNOVATION_ONE - Dev Instance";
    }

    @Profile("dev_algaworks_mongodb")
    @Bean
    public String devAlgaworksMongoDbDataBaseConnection() {
        log.info("DB Connection for DEV - MONGODB");
        log.info(driverClassName);
        log.info(url);
        return "Db Connection to MySQL_ALGAWORKS_MONGODB - Dev Instance";
    }
}
