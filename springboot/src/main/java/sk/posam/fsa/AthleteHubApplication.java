package sk.posam.fsa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "sk.posam.fsa.repository")
@EntityScan(basePackages = "sk.posam.fsa.entity")
public class AthleteHubApplication {
    public static void main(String[] args) {
        SpringApplication.run(AthleteHubApplication.class, args);
    }
}
