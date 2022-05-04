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

    @GetMapping("/registrera_hand/{costCenterId}")
    public String record_event(Model model, @PathVariable Long costCenterId) {
        String response = "registrera_hand";

        String costCenterName = costCenterService.getCostCenterName(costCenterId);
        model.addAttribute("costCenterName", costCenterName);

        if(costCenterName.isEmpty()) {
            response = "error";
        }
        return response;
    }

    @GetMapping("/registrera_del/{costCenterId}")
    public String record_participant(Model model, @PathVariable Long costCenterId) {
        String response = "registrera_del";

        String costCenterName = costCenterService.getCostCenterName(costCenterId);
        model.addAttribute("costCenterName", costCenterName);

        if (costCenterName.isEmpty()) {
            response = "error";
        }
        return response;
    }
    public boolean checkName(String name) {
        return name != null;
    }
}
