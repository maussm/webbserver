package se.mau.webbserver.activity;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.time.LocalDate;
import java.util.List;

@Component
public class ActivityConfiguration implements CommandLineRunner {
    private final ActivityRepository repository;

    public ActivityConfiguration(ActivityRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... args) throws Exception {
        Activity fika1 = new Activity(
                LocalDate.of(2022, 4, 13),
                LocalDate.of(2022, 4, 13),
                "STHLM25",
                "FIKA1",
                15
            );
            Activity fika2 = new Activity(
                LocalDate.of(2022, 4, 13),
                LocalDate.of(2022, 4, 13),
                "STHLM35",
                "FIKA2",
                15
            );
            Activity fika3 = new Activity(
                LocalDate.of(2022, 4, 13),
                LocalDate.of(2022, 4, 13),
                "STHLM12",
                "FIKA3",
                15
            );
            Activity fika4 = new Activity(
                LocalDate.of(2022, 4, 13),
                LocalDate.of(2022, 4, 13),
                "STHLM16",
                "FIKA4",
                15
            );
            Activity fika5 = new Activity(
                LocalDate.of(2022, 4, 13),
                LocalDate.of(2022, 4, 13),
                "STHLM29",
                "FIKA5",
                15
            );

            repository.saveAll(List.of(fika1, fika2, fika3, fika4, fika5));
    }
}
