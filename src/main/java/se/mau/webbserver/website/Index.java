package se.mau.webbserver.website;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import se.mau.webbserver.entity.costCenter.CostCenter;
import se.mau.webbserver.entity.costCenter.CostCenterService;
import java.util.List;

@Controller
public class Index {
    private final CostCenterService costCenterService;

    public Index(CostCenterService costCenterService) {
        this.costCenterService = costCenterService;
    }

    @GetMapping()
    public String index(Model model) {
        List<CostCenter> costCenters = costCenterService.getCostCenter();
        model.addAttribute("costCenters", costCenters);
        return "index";
    }
}
