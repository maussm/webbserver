package se.mau.webbserver.entity.cost_center;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CostCenterService {

    private final CostCenterRepository repository;

    @Autowired
    public CostCenterService(CostCenterRepository repository) {
        this.repository = repository;
    }

    public List<CostCenter> getCostCenter() {
        return repository.findAll();
    }

    public CostCenter getCostCenter(Long id) {
        Optional<CostCenter> optionalCostCenter = repository.findById(id);

        if(optionalCostCenter.isPresent()) {
            return optionalCostCenter.get();
        } else {
            throw new IllegalStateException(String.format("Cost center with id %s does not exist.", id));
        }
    }

    public void addCostCenter(CostCenter costCenter) {
        Optional<CostCenter> optionalCostCenter = repository.findById(costCenter.getId());

        if(optionalCostCenter.isPresent()) {
            throw new IllegalStateException(String.format("Cost center with id %s already exists.", costCenter.getId()));
        }

        repository.save(costCenter);
    }

    public void deleteCostCenter(Long id) {
        Optional<CostCenter> optionalCostCenter = repository.findById(id);

        if(optionalCostCenter.isEmpty()) {
            throw new IllegalStateException(String.format("Cost center with id %s does not exist.", id));
        }

        repository.delete(optionalCostCenter.get());
    }

    public void patchCostCenter(Long id, CostCenter costCenter) {
        Optional<CostCenter> optionalCostCenter = repository.findById(id);

        if(optionalCostCenter.isEmpty()) {
            throw new IllegalStateException(String.format("Cost center with id %s does not exist.", id));
        }

        CostCenter _costCenter = optionalCostCenter.get();

        if(!(_costCenter.equals(costCenter))) {
            if(costCenter.getName() != null) {
                _costCenter.setName(costCenter.getName());
            }
            if(costCenter.getLocaiton() != null) {
                _costCenter.setLocaiton(costCenter.getLocaiton());
            }
            repository.save(_costCenter);
        }
    }

    public String getCostCenterName(Long id) {
        Optional<CostCenter> costCenter = repository.findById(id);
        String name = null;

        if(costCenter.isPresent()) {
            name = costCenter.get().getName();
        }

        return name;
    }
}
