package se.mau.webbserver.participant;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ParticipantConfiguration {
    @Bean
    CommandLineRunner commandLineRunner(ParticipantRepository repository) {
        return args -> {
            Participant person1 = new Participant(
                    1L,
                    "Jens Bjerre"
            );
            repository.saveAll(List.of(person1));
        };
    }
}
