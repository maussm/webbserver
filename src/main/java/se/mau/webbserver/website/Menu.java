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

/**
 * Genererar sidan ankommande, reg-händelse och reg-deltagare.
 */
@Controller
public class Menu extends Default{

    private final AliasService aliasService;

    /**
     * Sätter upp kopplingen mot databasen via klassen Default.
     * @param costCenterService Kopplar mot tabellen cost_center.
     */
    @Autowired
    protected Menu(CostCenterService costCenterService, AliasService aliasService) {
        super(costCenterService);
        this.aliasService = aliasService;
    }

    /**
     * URI: /ankommande?vald_enhet=1
     * @param vald_enhet Id på kostnadsstället man jobbar med.
     * @return 302 status kod som skickar än till /ankommande/vald_enhet.
     */
    @GetMapping("/ankommande")
    public String ankommande(@RequestParam Integer vald_enhet) {
        return "redirect:/ankommande/" + vald_enhet;
    }

    /**
     * URI: /ankommande/{costCenterId}
     * Generar sidan ankommande.
     * @param model Model som används av Thymeleaf när sidan ska byggas.
     * @param costCenterId Det kostnadsställe man jobbar med.
     * @return Den färdiga sidan.
     */
    @GetMapping("/ankommande/{costCenterId}")
    public String ankommande(Model model, @PathVariable Integer costCenterId) {
        String response = "ankommande";
        model = super.setModel(model, costCenterId);
        if(model == null) {
            response = "error";
        }
        return response;
    }

    /**
     * URI: /reg-handelse?vald_enhet=1
     * @param vald_enhet Id på kostnadsstället man jobbar med.
     * @return 302 status kod som skickar än till /reg-handelse/vald_enhet.
     */
    @GetMapping("/reg-handelse")
    public String handelse(@RequestParam Integer vald_enhet) {
        return "redirect:/reg-handelse/" + vald_enhet;
    }

    /**
     * URI: /reg-handelse/{costCenterId}
     * Generar sidan reg-handelse.
     * @param model Model som används av Thymeleaf när sidan ska byggas.
     * @param costCenterId Det kostnadsställe man jobbar med.
     * @return Den färdiga sidan.
     */
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

    /**
     * URI: /reg-deltagare?vald_enhet=1
     * @param vald_enhet Id på kostnadsstället man jobbar med.
     * @return 302 status kod som skickar än till /reg-deltagare/vald_enhet.
     */
    @GetMapping("/reg-deltagare")
    public String deltagare(@RequestParam Integer vald_enhet) {
        return "redirect:/reg-deltagare/" + vald_enhet;
    }

    /**
     * URI: /reg-deltagare/{costCenterId}
     * Generar sidan reg-deltagare.
     * @param model Model som används av Thymeleaf när sidan ska byggas.
     * @param costCenterId Det kostnadsställe man jobbar med.
     * @return Den färdiga sidan.
     */
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
