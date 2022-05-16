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

@RestController
@RequestMapping("/api/cost_center")
public class CostCenterRestController {

    private final CostCenterService service;

    @Autowired
    public CostCenterRestController(CostCenterService service) {
        this.service = service;
    }

    @GetMapping
    public List<CostCenter> getCostCenters() {
        return service.getCostCenters();
    }

    @GetMapping("/{id}")
    public CostCenter getCostCenter(@PathVariable Integer id) {
        return service.getCostCenter(id);
    }

    @PostMapping
    public void addCostCenter(@RequestBody CostCenter costCenter) {
        service.addCostCenter(costCenter);
    }

    @DeleteMapping("/{id}")
    public void deleteCostCenter(@PathVariable Integer id) {
        service.deleteCostCenter(id);
    }

    @PatchMapping("/{id}")
    public void patchCostCenter(@PathVariable Integer id, @RequestBody CostCenter costCenter) {
        service.patchCostCenter(id, costCenter);
    }
}
