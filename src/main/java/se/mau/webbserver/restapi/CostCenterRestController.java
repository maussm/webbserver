package se.mau.webbserver.restapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import se.mau.webbserver.entity.cost_center.CostCenter;
import se.mau.webbserver.entity.cost_center.CostCenterService;
import java.util.List;

/**
 * REST API klass för tabellen cost_center.
 */
@RestController
@RequestMapping("/api/cost_center")
public class CostCenterRestController {

    private final CostCenterService service;

    /**
     * Skapar upp alla kopplingen mot databasen som klassen behöver.
     * @param service Koppling mot tabellen cost_center.
     */
    @Autowired
    public CostCenterRestController(CostCenterService service) {
        this.service = service;
    }

    /**
     * URI: /api/cost_center
     * METOD: GET
     * Hämtar alla CostCenter.
     * @return Alla CostCenter som finns.
     */
    @GetMapping
    public List<CostCenter> getCostCenters() {
        return service.getCostCenters();
    }

    /**
     * URI: /api/cost_center/{id}
     * METOD: GET
     * Hämtar en CostCenter med angivet id.
     * @param id Id på CostCenter.
     * @return Ett CostCenter med angivet id.
     */
    @GetMapping("/{id}")
    public CostCenter getCostCenter(@PathVariable Integer id) {
        return service.getCostCenter(id);
    }

    /**
     * URI: /api/cost_center
     * METOD: POST
     * Tar emot ett objekt i JSON format som sedan sparas i databasen.
     * @param costCenter Det objekt som ska läggs till i databasen.
     */
    @PostMapping
    public void addCostCenter(@RequestBody CostCenter costCenter) {
        service.addCostCenter(costCenter);
    }

    /**
     * URI: /api/cost_center/{id}
     * METOD: DELETE
     * Tar bort en CostCenter från databasen med ett visst id.
     * @param id Id på det objekt som ska tas bort från databasen.
     */
    @DeleteMapping("/{id}")
    public void deleteCostCenter(@PathVariable Integer id) {
        service.deleteCostCenter(id);
    }

    /**
     * URI: /api/cost_center/{id}
     * METOD: PATCH
     * Uppdaterar en CostCenter i databasen med ett visst id.
     * @param id Id på det objekt som ska uppdateras i databasen.
     */
    @PatchMapping("/{id}")
    public void patchCostCenter(@PathVariable Integer id, @RequestBody CostCenter costCenter) {
        service.patchCostCenter(id, costCenter);
    }
}
