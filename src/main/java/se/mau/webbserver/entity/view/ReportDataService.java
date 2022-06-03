package se.mau.webbserver.entity.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

/**
 * Innehåller all logik för att hämta data från vyn report_data.
 */
@Service
public class ReportDataService {
    private final ReportDataRepository reportDataRepository;

    /**
     * Skapas automatiskt av Spring Boot och initierar kopplingar till de olika tabellerna som krävs.
     * @param reportDataRepository Kopplingen mot vyn report_data.
     */
    @Autowired
    public ReportDataService(ReportDataRepository reportDataRepository) {
        this.reportDataRepository = reportDataRepository;
    }

    /**
     * Hämtar alla rader från databasen.
     * @return En lista av ReportData med alla rader som finns.
     */
    public List<ReportData> getReportData() {
        return reportDataRepository.findAll();
    }

    /**
     * Hämtar data baserat på angivet namn för ett kostandsställe samt datum när en aktivitet ägde rum.
     * @param costCenterName Namnet på kostnadsstället.
     * @param date Datumet då aktiviteten ägde rum.
     * @return En lista av ReportData om data hittades, annars null.
     */
    public List<ReportData> getByCostCenterNameAndOccurrenceDate(String costCenterName, LocalDate date) {
        Optional<List<ReportData>> request = reportDataRepository.findByCostCenterNameAndOccurrenceDate(costCenterName, date);
        return request.orElse(null);
    }
}
