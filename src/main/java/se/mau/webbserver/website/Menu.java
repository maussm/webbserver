package se.mau.webbserver.website;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import se.mau.webbserver.entity.cost_center.CostCenterService;
import se.mau.webbserver.entity.tk.alias.Alias;
import se.mau.webbserver.entity.tk.alias.AliasService;

import java.util.List;

@Controller
public class Menu extends Default{

    private final AliasService aliasService;

    @Autowired
    protected Menu(CostCenterService costCenterService, AliasService aliasService) {
        super(costCenterService);
        this.aliasService = aliasService;
    }

    @GetMapping("/ankommande")
    public String ankommande(@RequestParam Integer vald_enhet) {
        return "redirect:/ankommande/" + vald_enhet;
    }

    @GetMapping("/ankommande/{costCenterId}")
    public String ankommande(Model model, @PathVariable Integer costCenterId) {
        String response = "ankommande";
        model = super.setModel(model, costCenterId);
        if(model == null) {
            response = "error";
        }
        return response;
    }

    @GetMapping("/reg-handelse")
    public String handelse(@RequestParam Integer vald_enhet) {
        return "redirect:/reg-handelse/" + vald_enhet;
    }

    @GetMapping("/reg-handelse/{costCenterId}")
    public String handelse(Model model, @PathVariable Integer costCenterId) {
        String response = "reg-handelse";
        List<Alias> aliases = aliasService.getAliasesPerCostCenter(costCenterId);
        model = super.setModel(model, costCenterId);
        model.addAttribute("aliases", aliases);
        if(model == null) {
            response = "error";
        }
        return response;
    }

    @GetMapping("/reg-deltagare")
    public String deltagare(@RequestParam Integer vald_enhet) {
        return "redirect:/reg-deltagare/" + vald_enhet;
    }

    @GetMapping("/reg-deltagare/{costCenterId}")
    public String deltagare(Model model, @PathVariable Integer costCenterId) {
        String response = "reg-deltagare";
        model = super.setModel(model, costCenterId);
        if(model == null) {
            response = "error";
        }
        return response;
    }
}
