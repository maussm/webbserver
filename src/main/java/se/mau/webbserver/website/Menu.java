package se.mau.webbserver.website;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;
import se.mau.webbserver.entity.cost_center.CostCenter;
import se.mau.webbserver.entity.cost_center.CostCenterService;
import javax.websocket.server.PathParam;
import java.util.List;

@Controller
public class Menu {

    private final CostCenterService costCenterService;

    @Autowired
    public Menu(CostCenterService costCenterService) {
        this.costCenterService = costCenterService;
    }


    @GetMapping("/meny")
    public String menyRedirect(@RequestParam Long vald_enhet) {
        return "redirect:/meny/" + vald_enhet;
    }

    @GetMapping("/meny/{vald_enhet}")
    public String meny(Model model, @PathVariable Long vald_enhet) {
        String response = "meny";

        String costCenterName = costCenterService.getCostCenterName(vald_enhet);
        model.addAttribute("costCenterName", costCenterName);
        model.addAttribute("costCenterId", vald_enhet);

        if(costCenterName == null) {
            response = "error";
        }
        return response;
    }
}
