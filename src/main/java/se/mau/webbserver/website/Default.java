package se.mau.webbserver.website;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import se.mau.webbserver.entity.cost_center.CostCenterService;

/**
 * En abstrakt klass som implementerar grunderna som varje hemsida behöver.
 */
@Controller
public abstract class Default {
    private final CostCenterService costCenterService;

    /**
     * Sätter upp kopplingen mot databasen som alla hemsidor behöver.
     * @param costCenterService Kopplar mot tabellen cost_center.
     */
    protected Default(CostCenterService costCenterService) {
        this.costCenterService = costCenterService;
    }

    /**
     * Returnerar en Model innehållande id och namn för det kostnadsställe man angivit.
     * @param model Det Modelobjekt som kommer att användas av hemsidan.
     * @param costCenterId Id på det kostnadsstället man vill ha namnet för.
     * @return Model med id och namn för kostnadsstället.
     */
    public Model setModel(Model model, Integer costCenterId) {
        String costCenterName = costCenterService.getCostCenterName(costCenterId);

        if(costCenterName == null) {
            return null;
        } else {
            model.addAttribute("costCenterName", costCenterName);
            model.addAttribute("costCenterId", costCenterId);
            return model;
        }
    }
}
