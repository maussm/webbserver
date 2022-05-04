package se.mau.webbserver.website;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import se.mau.webbserver.entity.cost_center.CostCenterService;

@Controller
public class Menu {
    private final CostCenterService costCenterService;

    @Autowired
    public Menu(CostCenterService costCenterService) {
        this.costCenterService = costCenterService;
    }

    @GetMapping("/meny")
    public String meny(Model model, @RequestParam Long vald_enhet) {
        String response = "meny";

        String costCenterName = costCenterService.getCostCenterName(vald_enhet);
        model.addAttribute("costCenterName", costCenterName);

        if(costCenterName == null) {
            response = "error";
        }
        return response;
    }
}
