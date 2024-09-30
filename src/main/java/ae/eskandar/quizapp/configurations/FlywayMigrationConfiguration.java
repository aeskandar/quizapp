package ae.eskandar.quizapp.configurations;

import lombok.RequiredArgsConstructor;
import org.flywaydb.core.Flyway;
import org.springframework.boot.autoconfigure.flyway.FlywayProperties;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@EnableConfigurationProperties({FlywayProperties.class, DataSourceProperties.class})
public class FlywayMigrationConfiguration {

    @Bean(initMethod = "migrate")
    public Flyway flyway( FlywayProperties flywayProperties, DataSourceProperties dataSourceProperties) {
        flywayProperties.getLocations().stream().forEach(System.out::println);
        return Flyway.configure()
                .dataSource(dataSourceProperties.getUrl(), dataSourceProperties.getUsername(), dataSourceProperties.getPassword())
                .locations(flywayProperties.getLocations().stream().toArray(String[]::new))
                .baselineOnMigrate(true)
                .validateOnMigrate(true)
                .load();
    }
}