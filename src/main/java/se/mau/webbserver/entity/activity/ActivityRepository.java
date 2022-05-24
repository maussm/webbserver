package se.mau.webbserver.entity.activity;

import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface ActivityRepository extends JpaRepository<Activity, Integer> {
    Optional<List<Activity>> findByCostCenter_IdAndOccurrenceDate(Integer id, LocalDate date);
}
