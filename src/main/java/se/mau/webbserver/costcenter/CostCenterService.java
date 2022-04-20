package se.mau.webbserver.costcenter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
