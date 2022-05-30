package se.mau.webbserver.website;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import se.mau.webbserver.entity.cost_center.CostCenterService;

@Controller
public class FollowUp extends Default {

    @Autowired
    protected FollowUp(CostCenterService costCenterService) {
        super(costCenterService);
    }

    @GetMapping("/foljaupp")
    public String ankommande(@RequestParam Integer vald_enhet) {
        return "redirect:/foljaupp/" + vald_enhet;
    }

    @GetMapping("/foljaupp/{costCenterId}")
    public String ankommande(Model model, @PathVariable Integer costCenterId) {
        String response = "foljaupp";
        model = super.setModel(model, costCenterId);
        if(model == null) {
            response = "error";
        }
        return response;
    }
}
