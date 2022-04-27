package se.mau.webbserver.restapi.costcenter;

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

    public String getCostCenterName(Long id) {
        Optional<CostCenter> costCenter = costCenterRepository.findById(id);
        String name = null;

        if(costCenter.isPresent()) {
            name = costCenter.get().getCenterName();
        }

        return name;
    }
}
