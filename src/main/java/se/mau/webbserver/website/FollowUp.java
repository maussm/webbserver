package se.mau.webbserver.website;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import se.mau.webbserver.entity.cost_center.CostCenterService;

@Controller
public class FollowUp {
    private CostCenterService costCenterService;

    @Autowired
    public FollowUp(CostCenterService costCenterService) {
        this.costCenterService = costCenterService;
    }

    @GetMapping("/foljaupp/{costCenterId}")
    public String foljaUpp(Model model, @PathVariable Integer costCenterId) {
        String response = "foljaupp";

        String costCenterName = costCenterService.getCostCenterName(costCenterId);
        model.addAttribute("costCenterName", costCenterName);

        if(costCenterName.isEmpty()) {
            response = "error";
        }
        return response;
    }
}
