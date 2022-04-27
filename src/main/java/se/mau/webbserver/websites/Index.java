package se.mau.webbserver.websites;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import se.mau.webbserver.restapi.costcenter.CostCenter;
import se.mau.webbserver.restapi.costcenter.CostCenterService;
import java.util.List;

@Controller
public class Index {
    private final CostCenterService consCenterService;

    public Index(CostCenterService consCenterService) {
        this.consCenterService = consCenterService;
    }

    @GetMapping()
    public String index(Model model) {
        List<CostCenter> costCenters = consCenterService.getCostCenters();
        model.addAttribute("costCenters", costCenters);
        return "index";
    }
}
