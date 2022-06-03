package se.mau.webbserver.restapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import se.mau.webbserver.entity.cost_center.CostCenterService;
import se.mau.webbserver.entity.view.ReportData;
import se.mau.webbserver.entity.view.ReportDataService;
import java.time.LocalDate;
import java.util.List;

/**
 * REST API klass för tabellen report_data.
 */
@RestController
@RequestMapping("/api/report_data")
public class ReportDataRestController {
    private final ReportDataService reportDataService;
    private final CostCenterService costCenterService;

    /**
     * Skapar upp alla kopplingen mot databasen som klassen behöver.
     * @param reportDataService Koppling mot tabellen report_data.
     * @param costCenterService Koppling mot tabellen cost_center.
     */
    @Autowired
    public ReportDataRestController(ReportDataService reportDataService, CostCenterService costCenterService) {
        this.reportDataService = reportDataService;
        this.costCenterService = costCenterService;
    }

    /**
     * URI: /api/report_data
     * METOD: GET
     * Hämtar alla ReportData.
     * @return Alla ReportData som finns.
     */
    public List<ReportData> getReportData() {
        return reportDataService.getReportData();
    }

    /**
     * URI: /api/report_data/cost_center_occurrence_date/{ccid}/{sdate}
     * METOD: GET
     * Hämtar alla ReportData för ett visst kostnadsställe på angivet datum.
     * @param ccid Id för ett kostnadsställe.
     * @param sdate Datum som sträng i formatet ÅÅÅÅ-MM-DD.
     * @return En lista av ReportData.
     */
    @GetMapping("/cost_center_occurrence_date/{ccid}/{sdate}")
    public List<ReportData> getActivityByCostCenter(@PathVariable Integer ccid, @PathVariable String sdate) {
        String costCenterName = costCenterService.getCostCenterName(ccid);
        LocalDate date = LocalDate.parse(sdate);

        return reportDataService.getByCostCenterNameAndOccurrenceDate(costCenterName, date);
    }
}
