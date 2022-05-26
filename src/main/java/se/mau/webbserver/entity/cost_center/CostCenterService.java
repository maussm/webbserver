package se.mau.webbserver.entity.cost_center;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CostCenterService {

    private final CostCenterRepository costCenterRepository;

    @Autowired
    public CostCenterService(CostCenterRepository costCenterRepository) {
        this.costCenterRepository = costCenterRepository;
    }

    public List<CostCenter> getCostCenters() {
        return costCenterRepository.findAll();
    }

    public CostCenter getCostCenter(Integer id) {
        Optional<CostCenter> optionalCostCenter = costCenterRepository.findById(id);

        if(optionalCostCenter.isPresent()) {
            return optionalCostCenter.get();
        } else {
            throw new IllegalStateException(String.format("Cost center with id %s does not exist.", id));
        }
    }

    public void addCostCenter(CostCenter costCenter) {
        costCenterRepository.save(costCenter);
    }

    public void deleteCostCenter(Integer id) {
        Optional<CostCenter> optionalCostCenter = costCenterRepository.findById(id);

        if(optionalCostCenter.isEmpty()) {
            throw new IllegalStateException(String.format("Cost center with id %s does not exist.", id));
        }

        costCenterRepository.delete(optionalCostCenter.get());
    }

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

    public String getCostCenterName(Integer id) {
        Optional<CostCenter> costCenter = costCenterRepository.findById(id);
        String name = null;

        if(costCenter.isPresent()) {
            name = costCenter.get().getName();
        }

        return name;
    }
}
