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

@RestController
@RequestMapping("/api/report_data")
public class ReportDataRestController {
    private final ReportDataService reportDataService;
    private final CostCenterService costCenterService;

    @Autowired
    public ReportDataRestController(ReportDataService reportDataService, CostCenterService costCenterService) {
        this.reportDataService = reportDataService;
        this.costCenterService = costCenterService;
    }

    public List<ReportData> getReportData() {
        return reportDataService.getReportData();
    }

    @GetMapping("/cost_center_occurrence_date/{ccid}/{sdate}")
    public List<ReportData> getActivityByCostCenter(@PathVariable Integer ccid, @PathVariable String sdate) {
        String costCenterName = costCenterService.getCostCenterName(ccid);
        LocalDate date = LocalDate.parse(sdate);

        return reportDataService.getByCostCenterNameAndOccurrenceDate(costCenterName, date);
    }
}
