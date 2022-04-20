package se.mau.webbserver.costcenter;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class CostCenterConfiguration {

    @Bean
    CommandLineRunner commandLineRunner(CostCenterRepository repository) {
        return args -> {
            CostCenter center1 = new CostCenter(
                    1L,
                    "Bostad Ung",
                    "Boende och Stöd"
            );
            CostCenter center2 = new CostCenter(
                    2L,
                    "Bostad Först",
                    "Boende och Stöd"
            );
            CostCenter center3 = new CostCenter(
                    3L,
                    "Nattjouren",
                    "Boende och Stöd"
            );
          repository.saveAll(List.of(center1, center2, center3));
        };
    }
}
