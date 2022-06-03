package se.mau.webbserver.website;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import se.mau.webbserver.entity.cost_center.CostCenter;
import se.mau.webbserver.entity.cost_center.CostCenterService;
import java.util.List;

/**
 * Genererar förstasidan.
 */
@Controller
public class Index {
    private final CostCenterService costCenterService;

    /**
     * Sätter upp kopplingen mot databasen via klassen Default.
     * @param costCenterService Kopplar mot tabellen cost_center.
     */
    public Index(CostCenterService costCenterService) {
        this.costCenterService = costCenterService;
    }

    /**
     * URI: /
     * Hämtar alla kostnadsställen från databasen och lägger in dom i model som sedan populerar hemsidan.
     * @param model Model som används av Thymeleaf när sidan ska byggas.
     * @return Den färdiga sidan.
     */
    @GetMapping()
    public String index(Model model) {
        List<CostCenter> costCenters = costCenterService.getCostCenters();
        model.addAttribute("costCenters", costCenters);
        return "index";
    }
}
