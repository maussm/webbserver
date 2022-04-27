package se.mau.webbserver.restapi.costcenter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(path = "/api")
public class CostCenterController {
    private final CostCenterService costCenterService;

    @Autowired
    public CostCenterController(CostCenterService costCenterService) {
        this.costCenterService = costCenterService;
    }
    @GetMapping("/CostCenters")
    public List<CostCenter> getCostCenters() {
        return costCenterService.getCostCenters();
    }
}
