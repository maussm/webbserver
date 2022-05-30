package se.mau.webbserver.entity.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ReportDataService {
    private final ReportDataRepository reportDataRepository;

    @Autowired
    public ReportDataService(ReportDataRepository reportDataRepository) {
        this.reportDataRepository = reportDataRepository;
    }

    public List<ReportData> getReportData() {
        return reportDataRepository.findAll();
    }

    public List<ReportData> getByCostCenterNameAndOccurrenceDate(String costCenterName, LocalDate date) {
        Optional<List<ReportData>> request = reportDataRepository.findByCostCenterNameAndOccurrenceDate(costCenterName, date);
        return request.orElse(null);
    }
}
