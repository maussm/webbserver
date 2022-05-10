package se.mau.webbserver.website;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import se.mau.webbserver.entity.cost_center.CostCenterService;

@Controller
public class Register {
    private final CostCenterService costCenterService;

    @Autowired
    public Register(CostCenterService costCenterService) {
        this.costCenterService = costCenterService;
    }

    @GetMapping("/reg_hand/{costCenterId}")
    public String record_event(Model model, @PathVariable Integer costCenterId) {
        String response = "reg-handelse";

        String costCenterName = costCenterService.getCostCenterName(costCenterId);
        model.addAttribute("costCenterName", costCenterName);
        model.addAttribute("costCenterId", costCenterId);

        if(costCenterName.isEmpty()) {
            response = "error";
        }
        return response;
    }

    @GetMapping("/reg_del/{costCenterId}")
    public String record_participant(Model model, @PathVariable Integer costCenterId) {
        String response = "reg-deltagare";

        String costCenterName = costCenterService.getCostCenterName(costCenterId);
        model.addAttribute("costCenterName", costCenterName);
        model.addAttribute("costCenterId", costCenterId);

        if (costCenterName.isEmpty()) {
            response = "error";
        }
        return response;
    }
    public boolean checkName(String name) {
        return name != null;
    }
}
