package se.mau.webbserver.website;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import se.mau.webbserver.entity.cost_center.CostCenterService;

/**
 * Genererar sidan följaupp.
 */
@Controller
public class FollowUp extends Default {

    /**
     * Sätter upp kopplingen mot databasen via klassen Default.
     * @param costCenterService Kopplar mot tabellen cost_center.
     */
    @Autowired
    protected FollowUp(CostCenterService costCenterService) {
        super(costCenterService);
    }

    /**
     * URI: /foljaupp?vald_enhet=1
     * @param vald_enhet Id på kostnadsstället man jobbar med.
     * @return 302 status kod som skickar än till /foljaupp/vald_enhet.
     */
    @GetMapping("/foljaupp")
    public String ankommande(@RequestParam Integer vald_enhet) {
        return "redirect:/foljaupp/" + vald_enhet;
    }

    /**
     * URI: /foljaupp/{costCenterId}
     * Generar sidan foljaupp.
     * @param model Model som används av Thymeleaf när sidan ska byggas.
     * @param costCenterId Det kostnadsställe man jobbar med.
     * @return Den färdiga sidan.
     */
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
