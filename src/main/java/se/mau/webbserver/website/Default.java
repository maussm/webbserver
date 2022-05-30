package se.mau.webbserver.website;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import se.mau.webbserver.entity.cost_center.CostCenterService;

@Controller
public abstract class Default {
    private final CostCenterService costCenterService;

    protected Default(CostCenterService costCenterService) {
        this.costCenterService = costCenterService;
    }

    public Model setModel(Model model, Integer costCenterId) {
        String costCenterName = costCenterService.getCostCenterName(costCenterId);

        if(costCenterName == null) {
            return null;
        } else {
            model.addAttribute("costCenterName", costCenterName);
            model.addAttribute("costCenterId", costCenterId);
            return model;
        }
    }
}
