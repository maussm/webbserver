package se.mau.webbserver.activity;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.time.LocalDate;
import java.util.List;

@Configuration
public class ActivityConfiguration {

    @Bean
    CommandLineRunner commandLineRunner(ActivityRepository repository) {
        return args -> {
            Activity fika2 = new Activity(
                1L,
                LocalDate.of(2022, 4, 13),
                LocalDate.of(2022, 4, 13),
                "STHLM14",
                "FIKA2",
                15
            );
            Activity fika5 = new Activity(
                1L,
                LocalDate.of(2022, 4, 13),
                LocalDate.of(2022, 4, 13),
                "STHLM16",
                "FIKA5",
                15
            );

            repository.saveAll(List.of(fika2, fika5));
        };

    }
}
