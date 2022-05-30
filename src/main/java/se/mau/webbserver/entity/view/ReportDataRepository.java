package se.mau.webbserver.entity.view;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface ReportDataRepository extends JpaRepository<ReportData, Integer> {
    Optional<List<ReportData>> findByCostCenterNameAndOccurrenceDate(String costCenterName, LocalDate occurrenceDate);
}
