package se.mau.webbserver.entity.cost_center;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

/**
 * Innehåller all logik för att hämta data från tabellen cost_center.
 */
@Service
public class CostCenterService {

    private final CostCenterRepository costCenterRepository;

    /**
     * Skapas automatiskt av Spring Boot och initierar kopplingar till de olika tabellerna som krävs.
     * @param costCenterRepository kopplingen mot tabellen cost_center.
     */
    @Autowired
    public CostCenterService(CostCenterRepository costCenterRepository) {
        this.costCenterRepository = costCenterRepository;
    }

    /**
     * Hämtar alla rader från databasen.
     * @return En lista av CostCenter med alla rader som finns.
     */
    public List<CostCenter> getCostCenters() {
        return costCenterRepository.findAll();
    }

    /**
     * Hämtar CostCenter med ett visst id.
     * @param id Id som ska sökas på i databasen.
     * @return CostCenter om den finnas, annars kastas ett felmeddelande.
     */
    public CostCenter getCostCenter(Integer id) {
        Optional<CostCenter> optionalCostCenter = costCenterRepository.findById(id);

        if(optionalCostCenter.isPresent()) {
            return optionalCostCenter.get();
        } else {
            throw new IllegalStateException(String.format("Cost center with id %s does not exist.", id));
        }
    }

    /**
     * Lägger till ny data i databasen.
     * @param costCenter Datan som ska läggas till.
     */
    public void addCostCenter(CostCenter costCenter) {
        costCenterRepository.save(costCenter);
    }

    /**
     * Tar bort data med ett specifikt id från databasen.
     * @param id Id på den data som ska tas bort.
     */
    public void deleteCostCenter(Integer id) {
        Optional<CostCenter> optionalCostCenter = costCenterRepository.findById(id);

        if(optionalCostCenter.isEmpty()) {
            throw new IllegalStateException(String.format("Cost center with id %s does not exist.", id));
        }

        costCenterRepository.delete(optionalCostCenter.get());
    }

    /**
     * Uppdaterar data i databasen.
     * @param id Id på den data som ska uppdateras.
     * @param costCenter Uppdaterade datan som ska sparas i databasen.
     */
    public void patchCostCenter(Integer id, CostCenter costCenter) {
        Optional<CostCenter> optionalCostCenter = costCenterRepository.findById(id);

        if(optionalCostCenter.isEmpty()) {
            throw new IllegalStateException(String.format("Cost center with id %s does not exist.", id));
        }

        CostCenter _costCenter = optionalCostCenter.get();

        if(costCenter.getName() != null) {
            _costCenter.setName(costCenter.getName());
        }
        costCenterRepository.save(_costCenter);
    }

    /**
     * Hämtar namnet på ett CostCenter från databasen.
     * @param id Id på det CostCenter som namnet ska hämtas för.
     * @return Namnet på CostCenter om det finns, annars null.
     */
    public String getCostCenterName(Integer id) {
        Optional<CostCenter> costCenter = costCenterRepository.findById(id);
        String name = null;

        if(costCenter.isPresent()) {
            name = costCenter.get().getName();
        }

        return name;
    }
}
