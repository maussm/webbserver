package se.mau.webbserver.website;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import se.mau.webbserver.entity.cost_center.CostCenter;
import se.mau.webbserver.entity.cost_center.CostCenterService;
import java.util.List;

@Controller
public class Index {
    private final CostCenterService costCenterService;

    public Index(CostCenterService costCenterService) {
        this.costCenterService = costCenterService;
    }

    @GetMapping()
    public String index(Model model) {
        List<CostCenter> costCenters = costCenterService.getCostCenters();
        model.addAttribute("costCenters", costCenters);
        return "index";
    }
}
