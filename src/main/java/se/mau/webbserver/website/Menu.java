package se.mau.webbserver.website;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import se.mau.webbserver.entity.cost_center.CostCenterService;

@Controller
public class Menu {
    private final CostCenterService costCenterService;

    @Autowired
    public Menu(CostCenterService costCenterService) {
        this.costCenterService = costCenterService;
    }

    @GetMapping("/menu/{costCenterId}")
    public String meny(Model model, @PathVariable Long costCenterId) {
        String response = "registrera_del";

        String costCenterName = costCenterService.getCostCenterName(costCenterId);
        model.addAttribute("costCenterName", costCenterName);

        if(costCenterName == null) {
            response = "error";
        }
        return response;
    }
}
